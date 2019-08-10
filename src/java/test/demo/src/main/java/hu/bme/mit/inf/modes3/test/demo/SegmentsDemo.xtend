package hu.bme.mit.inf.modes3.test.demo

import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.utils.conf.layout.LayoutConfiguration
import org.slf4j.ILoggerFactory

/**
 * A show-case (demo), how you can get diverse information about the segments (section + turnout) and 
 * how you can control the segments too.
 * 
 * @author benedekh
 */
class SegmentsDemo extends AbstractCommunicationComponent implements ISegmentCommandListener {

	val knownSegments = LayoutConfiguration.INSTANCE.segments

	/**
	 * @param locator the high-level communication service of the railway track
	 * @param factory the logger factory
	 */
	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		super(locator, factory)
		locator.trackElementCommandCallback.segmentCommandListener = this
	}

	/**
	 * Runs the demo of how to get status information from the segments and how you can control them.
	 */
	override run() {
		getOccupancyOfAll
		printSeparatorAndSleep
		disableAllSegment
		printSeparatorAndSleep
		getStateOfAll
		printSeparatorAndSleep
		enableAllSegment
		printSeparatorAndSleep
		getStateOfAll
		printSeparatorAndSleep
		sendOccupancyOfAll
		printSeparatorAndSleep
		sendStateOfAll
		printSeparatorAndSleep
	}

	override onSegmentCommand(int id, SegmentState state) {
		logger.info('''Command SET «state» is received for segment #«id»''')
	}

	private def printSeparatorAndSleep() {
		logger.info('''--------''')
		Thread.sleep(40)
	}

	private def disableAllSegment() {
		setAllSegment(SegmentState.DISABLED)
	}

	private def enableAllSegment() {
		setAllSegment(SegmentState.ENABLED)
	}

	private def setAllSegment(SegmentState state) {
		knownSegments.forEach[locator.trackElementCommander.sendSegmentCommand(it, state)]
	}

	private def getStateOfAll() {
		knownSegments.forEach [
			val state = locator.trackElementStateRegistry.getSegmentState(it)
			logger.info('''Segment #«it» is «state»''')
		]
	}

	private def getOccupancyOfAll() {
		knownSegments.forEach [
			val state = locator.trackElementStateRegistry.getSegmentOccupancy(it)
			logger.info('''Segment #«it» is «state»''')
		]
	}

	private def sendStateOfAll() {
		knownSegments.forEach [
			val state = locator.trackElementStateRegistry.getSegmentState(it)
			locator.trackElementStateSender.sendSegmentState(it, state)
			logger.info('''Segment #«it» is «state» was SENT over the network''')
		]
	}

	private def sendOccupancyOfAll() {
		knownSegments.forEach [
			val state = locator.trackElementStateRegistry.getSegmentOccupancy(it)
			locator.trackElementStateSender.sendSegmentOccupation(it, state)
			logger.info('''Segment #«it» is «state» was SENT over the network''')
		]
	}

}
