package hu.bme.mit.inf.modes3.components.controller.command.interfaces

import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue

interface ITurnoutCommandListener {
	def void onTurnoutCommand(int id, TurnoutStateValue state)
}
