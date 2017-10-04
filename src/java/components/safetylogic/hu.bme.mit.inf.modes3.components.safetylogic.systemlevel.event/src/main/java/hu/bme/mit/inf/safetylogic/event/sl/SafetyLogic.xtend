package hu.bme.mit.inf.safetylogic.event.sl

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.SafetyLogicRuleEngine
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusListener
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ComputerVisionInformation
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import hu.bme.mit.inf.safetylogic.event.ComputerVisionEstimator
import hu.bme.mit.inf.safetylogic.event.IModelInteractor
import hu.bme.mit.inf.safetylogic.event.INotifiable
import hu.bme.mit.inf.safetylogic.event.ISegmentDisableStrategy
import hu.bme.mit.inf.safetylogic.event.ISegmentEnableStrategy
import hu.bme.mit.inf.safetylogic.event.ITrainStopStrategy
import hu.bme.mit.inf.safetylogic.event.ModelUtil
import hu.bme.mit.inf.safetylogic.event.TrackDisableStrategy
import hu.bme.mit.inf.safetylogic.event.TrackEnableStrategy
import hu.bme.mit.inf.safetylogic.event.TrainMovementEstimator
import hu.bme.mit.inf.safetylogic.event.wrapper.ISafetyLogicWrapper
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SafetyLogic implements INotifiable, ISafetyLogic {

	val initializeRailRoad = true

	@Accessors(PUBLIC_GETTER) protected IModelInteractor model
	val ILoggerFactory factory
	val Logger logger

	@Accessors(PUBLIC_GETTER)
	private SafetyLogicRuleEngine rules

	static val turnoutToSenseIDMap = LayoutConfiguration.INSTANCE.turnoutIdToSegmentIdsMapping
	static val senseToTurnoutIDMap = LayoutConfiguration.INSTANCE.segmentIdToTurnoutIdMapping

	val Set<Train> stoppedTrains = newHashSet
	val ComputerVisionEstimator computerVisionEstimator

	var List<ISegmentEnableStrategy> segmentEnableStrategies
	var List<ISegmentDisableStrategy> segmentDisableStrategies
	var List<ITrainStopStrategy> trainStopStrategies

	var ISafetyLogicWrapper safetyLogicWrapper

	new(ILoggerFactory factory) {
		this.factory = factory
		this.logger = factory.getLogger(this.class.name)

		logger.info('Construction started')
		SafetyLogicRuleEngine.standaloneSetup

		model = new ModelUtil(factory)
		this.computerVisionEstimator = new ComputerVisionEstimator(model)

//		rules = new SafetyLogicRuleEngine(model.resourceSet)
		model.segments.map[it as Segment].forEach[isEnabled = true] // Enable all sections virtually first 
		logger.info('Construction finished')
	}

	override setSafetyLogicWrapper(ISafetyLogicWrapper safetyLogicWrapper) {
		this.safetyLogicWrapper = safetyLogicWrapper

		this.segmentDisableStrategies = #[
			new TrackDisableStrategy(this.safetyLogicWrapper.trackElementCommander)
		]
		this.segmentEnableStrategies = #[
			new TrackEnableStrategy(this.safetyLogicWrapper.trackElementCommander)
		]
		this.trainStopStrategies = #[ // new XPressInvertDirectionStrategy(this.safetyLogicWrapper.trainCommander, this.safetyLogicWrapper.trainSpeedStateRegistry, logger)
		]

		this.safetyLogicWrapper.sendAllStatusListener = new ISendAllStatusListener() {

			// TODO : This part still requires some testing.
			override onSendAllStatus() {
				model.turnouts.forEach [
					safetyLogicWrapper.sendTurnoutState(id,
						if(currentlyDivergent) TurnoutState.DIVERGENT else TurnoutState.STRAIGHT)
				]
				model.segments.forEach [
					safetyLogicWrapper.sendSegmentState(id,
						if(isIsEnabled) SegmentState.ENABLED else SegmentState.DISABLED)
				]
				val occupiedSections = model.sections.filter[model.trains.map[currentlyOn].toList.contains(it)]
				occupiedSections.forEach [
					safetyLogicWrapper.sendSegmentOccupation(id, SegmentOccupancy.OCCUPIED)
				]
				val freeSections = model.sections.filter[!occupiedSections.toList.contains(it)]
				freeSections.forEach [
					safetyLogicWrapper.sendSegmentOccupation(id, SegmentOccupancy.FREE)
				]
			}

		}
	}

	private def void initRailRoad() {
		model.turnouts.forEach[currentlyDivergent = false]
		val initSleepTimes = 500
		logger.info('Railroad initialization started, sleep times are ' + initSleepTimes)
		val turnouts = model.turnouts
		val segments = model.segments

		logger.info('Disabling all sections')
		segments.forEach [
			this.safetyLogicWrapper.sendSegmentCommand(id, SegmentState.DISABLED)
		]

		Thread.sleep(initSleepTimes)

		logger.info('Setting turnouts to divergent')
		turnouts.forEach [
			this.safetyLogicWrapper.sendTurnoutCommand(id, TurnoutState.DIVERGENT)
		]

		Thread.sleep(initSleepTimes)

		logger.info('Setting all turnouts to straight')
		turnouts.forEach [
			this.safetyLogicWrapper.sendTurnoutCommand(id, TurnoutState.STRAIGHT)
		]

		Thread.sleep(initSleepTimes)

		logger.info('Enabling all sections')
		segments.forEach [
			this.safetyLogicWrapper.sendSegmentCommand(id, SegmentState.ENABLED)
		]

		logger.info('Railroad initialization finished')

	}

	override void run() {

		this.logger.info("Running started...")

		this.safetyLogicWrapper.segmentOccupancyChangeListener = new TrainMovementEstimator(model, this, factory)
		this.safetyLogicWrapper.turnoutStateChangeListener = new ITurnoutStateChangeListener() {

			override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
				val senseID = turnoutToSenseIDMap.get(id)
				logger.
					info('''TurnoutStateChange arrived, id = T«id» (senseid=«senseID») oldState = «oldValue?.name» newState = «newValue.name»''')
				println(model.turnouts.filter[senseID.contains(it.id)].size) // .map[it as Turnout].size)
				model.turnouts.filter[senseID.contains(it.id)].map[it as Turnout].forEach [
					it.currentlyDivergent = (newValue == TurnoutState.DIVERGENT)
					logger.
						info('''Turnout on «senseID» «if(currentlyDivergent) TurnoutState.DIVERGENT else TurnoutState.STRAIGHT»''')
				]
				logger.info('''Turnout States: <«FOR turnout : model.turnouts.map[it as Turnout] SEPARATOR ";\t "»
				Sense=«turnout.id»,TurnoutID=«senseToTurnoutIDMap.get(turnout.id)»,State=«if(turnout.currentlyDivergent) TurnoutState.DIVERGENT else TurnoutState.STRAIGHT»
				«ENDFOR»>''')
				refreshSafetyLogicState
			}
		}

		if (initializeRailRoad) {
			initRailRoad
		}

		logger.info('adding the cv callback')

		this.safetyLogicWrapper.computerVisionListener = new IComputerVisionListener() {

			override onComputerVisionDetection(List<ComputerVisionInformation> information, long timestamp,
				long frameindex) {
				val segmentIds = information.map [
					computerVisionEstimator.getElementByCoordinates(it.realPosition.x, it.realPosition.y)
				]
				val infoIter = information.iterator
				val combined = segmentIds.map[it -> infoIter.next]
				println('''
					Information recieved @ «timestamp» frame #«frameindex»
					«FOR info : information»
						CV Estimated train «info.name» on segment #«computerVisionEstimator.getElementByCoordinates(info.realPosition.x, info.realPosition.y).id»
					«ENDFOR»
				''')
				model.ensureIds(combined)
			}
		}

		logger.info('cv callback added')
	}

	def public void refreshSafetyLogicState() {
		logger.
			info('''Refreshing state: #of trains «model.trains.size», #of trailings «model.trailings.size», #of hits «model.hits.size»''')
		logger.
			info('''Trains «FOR train : model.trains»{ID=«train.id» ON=«train.currentlyOn.id» PREV=«if(train.previouslyOn === null) "UNDEF" else train.previouslyOn.id»}«ENDFOR»''')

		val offenders = new HashSet<Train>

		model.trailings.forEach [ trailing |
			logger.
				info('''TRAILING TURNOUT: Train on «trailing.offender.currentlyOn.id» will trail turnout «trailing.victim.id»''')
			offenders.add(trailing.offender)
		]

		model.hits.forEach [ hit |
			logger.
				info('''HIT: offender on «hit.offender.currentlyOn.id», hits victim on «hit.victim.currentlyOn.id»''')
			offenders.add(hit.offender)
		]

		val trainsToStop = offenders.filter[!stoppedTrains.contains(it)]

		trainsToStop.forEach [ train |
			trainStopStrategies.forEach[it.stopTrain(train)]
		]

		val trainsToRelease = stoppedTrains.filter[!offenders.contains(it)]
		val sectionsToEnable = trainsToRelease.map[it.currentlyOn]
		val sectionsToDisable = trainsToStop.map[it.currentlyOn]

		segmentEnableStrategies.forEach [ strategy |
			sectionsToEnable.forEach [ segment |
				strategy.enableSection(segment.id)
			]
		]
		segmentDisableStrategies.forEach [ strategy |
			sectionsToDisable.forEach [ segment |
				strategy.disableSection(segment.id)
			]
		]
		if (!sectionsToEnable.empty) {
			logger.
				info('''SectionToEnable = «FOR enable : sectionsToEnable BEFORE '{' SEPARATOR ', ' AFTER '}'» «enable.id» «ENDFOR»''')
		}
		if (!sectionsToDisable.empty) {
			logger.
				info('''SectionToDisable = «FOR disable : sectionsToDisable BEFORE '{' SEPARATOR ', ' AFTER '}'» «disable.id» «ENDFOR»''')
		}

		sectionsToEnable.filter[it instanceof Segment].map[it as Segment].forEach [
			it.isEnabled = true
		]
		sectionsToDisable.filter[it instanceof Segment].map[it as Segment].forEach [
			it.isEnabled = false
		]

		stoppedTrains.clear

		if (trainStopStrategies.empty) {
			stoppedTrains.addAll(offenders.filter[currentlyOn instanceof Segment]) // As if we have no train stopping strategies 			
		} else {
			stoppedTrains.addAll(offenders)
		}

	}

	override onUpdate() {
		refreshSafetyLogicState
	}

}
