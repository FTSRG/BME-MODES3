package hu.bme.mit.inf.modes3.messaging.messages.status

import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import org.eclipse.xtend.lib.annotations.Data

/**
 * Status info about a train's reference speed. 
 * 
 * @author benedekh
 */
@Data
class TrainReferenceSpeedMessage extends InternalMessage {
	int trainId
	int referenceSpeed
	TrainDirection direction
}
