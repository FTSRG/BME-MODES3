package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.messaging.mms.handlers.signal.TurnoutStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateOrBuilder

package class TurnoutStateClient implements TurnoutStateHandler {
	private var TrackElementStateCallback callback
	
	new(TrackElementStateCallback controller){
		callback = controller
	}
	
	override handleMessage(TurnoutStateOrBuilder message) {
		val id = message.turnoutID
		val state = message.state
		callback.onTurnoutState(id, state)
	}
	
}
