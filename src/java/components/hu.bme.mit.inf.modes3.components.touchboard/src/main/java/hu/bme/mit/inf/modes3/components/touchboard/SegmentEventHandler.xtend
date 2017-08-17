package hu.bme.mit.inf.modes3.components.touchboard

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SegmentEventHandler {

	static val ENABLED = "enabled"
	static val DISABLED = "disabled"
	static val OCCUPIED = "occupied"

	val Logger logger
	val ThreadSafeNode node

	val ITrackElementStateRegistry trackElementStateRegistry
	val ITrackElementCommander trackElementCommander

	var int i = 0

	new(ILoggerFactory loggerFactory, ThreadSafeNode node, ITrackElementStateRegistry trackElementStateRegistry,
		ITrackElementCommander trackElementCommander) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.node = node
		this.trackElementStateRegistry = trackElementStateRegistry
		this.trackElementCommander = trackElementCommander
	}

	def setDisabled() {
		node.removeCssClass(ENABLED)
		node.addCssClass(DISABLED)
	}

	def setEnabled() {
		node.removeCssClass(DISABLED)
		node.addCssClass(ENABLED)
	}

	def setOccupied() {
		node.addCssClass(OCCUPIED)
	}

	def setFree() {
		node.removeCssClass(OCCUPIED)
	}

	def onSegmentClicked() {
		try {
			val segmentId = node.nodeId
			// FIXME use this with the track
			// val state = trackElementStateRegistry.getSegmentState(segmentId)
			val state = if((i++) % 2 === 0) SegmentState.ENABLED else SegmentState.DISABLED

			val newState = getSegmentOppositeState(state)

			trackElementCommander.sendSegmentCommand(segmentId, newState)
			updateSectionState(newState)

			logger.info('''Segment «segmentId» is «newState»''')
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	private def void updateSectionState(SegmentState newState) {
		switch (newState) {
			case ENABLED:
				setEnabled()
			case DISABLED:
				setDisabled()
		}
	}

	private def getSegmentOppositeState(SegmentState state) {
		switch (state) {
			case ENABLED:
				SegmentState.DISABLED
			case DISABLED:
				SegmentState.ENABLED
		}
	}
}
