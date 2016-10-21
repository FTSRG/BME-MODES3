package hu.bme.mit.inf.modes3.components.bbb

import hu.bme.mit.inf.modes3.components.bbb.config.Configuration
import hu.bme.mit.inf.modes3.components.bbb.config.ExpanderConfigInterpreter
import hu.bme.mit.inf.modes3.components.bbb.controllers.PhysicalSegmentController
import hu.bme.mit.inf.modes3.components.bbb.controllers.PhysicalTurnoutController
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.update.IAllStatusUpdateListener
import java.util.HashMap
import java.util.List
import org.slf4j.ILoggerFactory

class BBBComponent extends AbstractRailRoadCommunicationComponent implements ISegmentCommandListener, ITurnoutCommandListener, IAllStatusUpdateListener {

	Configuration config
	val int id

	private HashMap<Integer, PhysicalSegmentController> segmentControllers = newHashMap()

	private List<PhysicalTurnoutController> turnoutControllers = newArrayList()

	new(int turnoutID, CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)

		id = turnoutID
		
		// TODO move out configuration files from resources and get the path of them from parameters

		// loading configurations
		config = Configuration::loadPinoutConfig(turnoutID, factory)
		val pinout = ExpanderConfigInterpreter.loadPinoutConfig(factory);
		GpioManager.loadGpioMappingFromFile("gpio.json")

		logger.info('''segments: «config.sectionNames»''')
		logger.info('''turnout expander: «config.turnoutExpanders»''')

		// for each and every segment we need to create a segmentController class
		for (String section : config.sectionNames) {
			try {
				var segmentId = Integer.parseInt(section);
				var expander = config.getSectionExpander(Integer.parseInt(section));
				segmentControllers.put(segmentId, new PhysicalSegmentController(pinout, expander, factory));
			} catch (NumberFormatException exp) {
				// TODO if section is not a number, it is a problem!
			}
		}

		// we will have an turnoutController class as well
		// in only one case, there will be two turnout controller to work with, therefore
		// we need a list of the controllers also
		for (String turnout : config.turnoutExpanders) {
			turnoutControllers.add(new PhysicalTurnoutController(pinout, turnout, factory));
		}

		// adding component as segmentCommandListener
		locator.trackElementCommandCallback.segmentCommandListener = this;
		locator.trackElementCommandCallback.turnoutCommandListener = this;
//		locator.sendAllStatusCallback.statusUpdateListener = this;

	}

	override run() {
		System.console.readLine("Press ENTER for ending BBB component running");
		logger.info('''Stopping BBBComponent...''')
		GpioManager.cleanup
	}

	override onSegmentCommand(int id, SegmentState state) {

		// if new segment command received on network, we need to check if it's our obligation to handle or not
		if (!segmentControllers.keySet.contains(id)) {
			return;
		}

		logger.info('''Segment state change command received on segment #«id»: «state»''');

		// set state of segment
		segmentControllers.get(id).segmentState = state;
		
		// also we need to send segmentState over network
		locator.trackElementStateSender.sendSegmentState(id, segmentControllers.get(id).segmentState);
	}

	override onTurnoutCommand(int id, TurnoutState state) {

		// if new turnout command received on network, we need to check if it's our obligation to handle or not
		if (this.id != id) {
			return;
		}

		logger.info('''Turnout state change command received on turnout #«id»: «state»''');

		for (PhysicalTurnoutController controller : turnoutControllers) {
			controller.turnoutState = state;
		}
		
		// TODO send turnout state back on network!
	}

	override onAllStatusUpdate() {

		// sending state of every segment located in the expanders
//		for (Entry<Integer, PhysicalSegmentController> controllerEntry : segmentControllers.entrySet) {
//			locator.trackElementStateSender.sendSegmentState(controllerEntry.key, controllerEntry.value.segmentState);
//		}
	}

}
