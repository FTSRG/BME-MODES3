package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperations
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedCommand
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.messages.DccOperationsStateOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler

class SafetyLogic extends AbstractRailRoadCommunicationComponent implements INotifiable {

	@Accessors(PUBLIC_GETTER) protected ModelUtil model // XXX IModelInteractor should be the static type
	private ILoggerFactory factory
	val List<ISegmentDisableStrategy> segmentDisableStrategies = #[
		new ISegmentDisableStrategy() {

			override disableSection(int id) {
				locator.trackElementCommander.sendSegmentCommand(id, SegmentState.DISABLED)
			}

		},
		new ISegmentDisableStrategy() {

			override disableSection(int id) {
				val train = model.model.trains.findFirst[currentlyOn.id == id]
				if(train != null) {
					communication.mms.sendMessage((TrainReferenceSpeedCommand.newBuilder => [trainID = train.id; referenceSpeed = 0; it.direction = TrainDirectionValue.FORWARD]).build)
				} else {
					logger.info('''You are disabling section #«id» which has no train on it''')
				}
			}
		},
		new ISegmentDisableStrategy() {

			override disableSection(int id) {
				val train = model.model.trains.findFirst[currentlyOn.id == id]
				if(train != null) {
					communication.mms.sendMessage((TrainReferenceSpeedCommand.newBuilder => [
						trainID = train.id; referenceSpeed = 0; 
						it.direction = 
							if(locator.trainReferenceSpeedState.getDirection(train.id) == TrainDirectionValue.FORWARD) TrainDirectionValue.BACKWARD 
							else TrainDirectionValue.FORWARD
					]).build)
				} else {
					logger.info('''You are disabling section #«id» which has no train on it''')
				}
			}

		}, new ISegmentDisableStrategy(){
			
			override disableSection(int id) {
				communication.mms.sendMessage((DccOperationsCommand.newBuilder => [it.dccOperations = DccOperations.STOP_OPERATIONS]).build)
			}
			
		}
	]
	val List<ISegmentEnableStrategy> segmentEnableStrategies = #[
		new ISegmentEnableStrategy() {
			override enableSection(int id) {
				locator.trackElementCommander.sendSegmentCommand(id, SegmentState.ENABLED)
			}
		}
	]

	new(CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)
		this.factory = factory
		logger.info('Construction started')
		model = new ModelUtil(factory)
		logger.info('Construction finished')
	}

	private def Iterable<Turnout> getTurnouts(Iterable<RailRoadElement> railRoadElements) {
		railRoadElements.filter[it instanceof Turnout].map[it as Turnout]
	}

	private def Iterable<Segment> getSegments(Iterable<RailRoadElement> railRoadElements) {
		railRoadElements.filter[it instanceof Segment].map[it as Segment]
	}

	private def turn(RailRoadElement element, SegmentState state) {
		if(element instanceof Segment) element.isEnabled = (state == SegmentState.ENABLED)
	}

	private def void initRailRoad() {
		val sleepTimes = 200
		logger.info('Railroad initialization started, sleep times are ' + sleepTimes)
		val turnouts = model.model.sections.getTurnouts
		turnouts.forEach [
			locator.trackElementCommander.sendTurnoutCommand(id, TurnoutState.STRAIGHT)
		]
		logger.info('All turnout set straight')
		Thread.sleep(sleepTimes)
		turnouts.forEach [
			locator.trackElementCommander.sendTurnoutCommand(id, TurnoutState.DIVERGENT)
		]
		logger.info('All turnout set divergent')
		Thread.sleep(sleepTimes)

		val segments = model.model.sections.getSegments
		segments.forEach [
			locator.trackElementCommander.sendSegmentCommand(id, SegmentState.DISABLED)
		]
		logger.info('Disabling all sections')
		Thread.sleep(sleepTimes)
		segments.forEach [
			locator.trackElementCommander.sendSegmentCommand(id, SegmentState.ENABLED)
		]
		logger.info('Enabling all sections')
		Thread.sleep(sleepTimes)
		logger.info('Railroad initialization finished')
	}

	override void run() {
//		for(value: 0..<126) {
//			communication.mms.sendMessage((TrainReferenceSpeedCommand.newBuilder => [trainID = 9; referenceSpeed = value; direction = TrainDirectionValue.FORWARD]).build)
//			println('Msg sent ' +value)
//			Thread.sleep(1000)
//		}
//		(communication.dispatcher as ProtobufMessageDispatcher).dccOperationStateHandler = new MessageHandler<DccOperationsStateOrBuilder>(){
//			override handleMessage(DccOperationsStateOrBuilder message) {
//				println('Value = ' + message.dccOperationsValue)
//				println(switch(message.dccOperations){
//					case NORMAL_OPERATIONS: 'normal'
//					case STOP_ALL_LOCOMOTIVES: 'stop loco'
//					case STOP_OPERATIONS: 'stop all'
//					case UNRECOGNIZED: 'unrecognized'
//				})
//			}
//		}
//		communication.mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.STOP_OPERATIONS]).build)
//		println('STOPPED')
//		Thread.sleep(5000)
//		println('STARTED')
//		communication.mms.sendMessage((DccOperationsCommand.newBuilder => [dccOperations = DccOperations.NORMAL_OPERATIONS]).build)
//		
//		Thread.sleep(5000)
		
		this.logger.info("Running started...")
		locator.trackElementStateRegistry.segmentOccupancyChangeListener = new TrainMovementEstimator(model, this, factory)
		locator.trackElementStateRegistry.turnoutStateChangeListener = new ITurnoutStateChangeListener() {

			override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
				(model.model.sections.findFirst[it.id == id] as Turnout).currentlyDivergent = (newValue == TurnoutState.DIVERGENT)
				refreshSafetyLogicState
			}
		}

		initRailRoad()
	}

	def public void refreshSafetyLogicState() {
		logger.info('''Refreshing state: #of cuts «model.cuts.size», #of hits «model.hits.size»''')
		model.model.sections.filter[it instanceof Segment].map[it as Segment].forEach[isEnabled = true] // Enable all sections virtually first
		model.cuts.forEach [ cut |
			logger.info('''CUT: victim on «(cut.victim).id» cuts «(cut.offender).currentlyOn.id»''')
			model.getSegment(cut.offender.currentlyOn.id).turn(SegmentState.DISABLED) // disable the trains which cut sections
		]

		model.hits.forEach [ hit |
			logger.info('''HIT: offender on «(hit.offender).currentlyOn.id», victim on «(hit.victim).currentlyOn.id»''')
			model.getSegment(hit.offender.currentlyOn.id).turn(SegmentState.DISABLED) // disable the trains which hit another
		]

		sendMessages()
	}

	private def void sendMessages() {
		val sectionsToEnable = model.model.sections.getSegments().filter[isEnabled]
		val sectionsToDisable = model.model.sections.getSegments().filter[!isEnabled]
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
	}

	override onUpdate() {
		refreshSafetyLogicState
	}

}
