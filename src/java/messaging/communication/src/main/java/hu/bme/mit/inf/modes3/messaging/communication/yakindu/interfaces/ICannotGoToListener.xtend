package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection

/**
 * Handles a CannotGoTo message in the state machines protocol.
 * 
 * @author benedekh
 */
interface ICannotGoToListener {
	/**
	 * The train is not allowed to go the segment that connects from the given direction.
	 * 
	 * @param targetID the target segment ID
	 * @param direction the connection direction of the segment
	 */
	def void cannotGoTo(int targetID, ConnectionDirection direction)
}
