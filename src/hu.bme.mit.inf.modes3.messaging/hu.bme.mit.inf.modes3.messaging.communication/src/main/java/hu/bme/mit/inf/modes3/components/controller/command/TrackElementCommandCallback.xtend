package hu.bme.mit.inf.modes3.components.controller.command

import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher

class TrackElementCommandCallback implements ITrackElementCommandCallback {
	var  ISegmentCommandListener segmentCommandListener
	var ITurnoutCommandListener turnoutCommandListener

	new(ProtobufMessageDispatcher dispatcher) {
		val segmentCommandListener = new SegmentCommandClient(this) 
		val turnoutCommandListener = new TurnoutCommandClient(this)

		dispatcher.segmentCommandHandler = segmentCommandListener
		dispatcher.turnoutCommandHandler = turnoutCommandListener
	}

	def onSegmentCommand(int id, SegmentState state) {
		segmentCommandListener?.onSegmentCommand(id, state)
	}

	def onTurnoutCommand(int id, TurnoutState state) {
		turnoutCommandListener?.onTurnoutCommand(id, state)
	}
	
	override setSegmentCommandListener(ISegmentCommandListener listener) {
		segmentCommandListener = listener
	}
	
	override setTurnoutCommandListener(ITurnoutCommandListener listener) {
		turnoutCommandListener = listener
	}

}
