package hu.bme.mit.inf.modes3.messaging.communication.state.computervision

import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionStateSender
import hu.bme.mit.inf.modes3.messaging.messages.status.ComputerVisionObjectPositionsMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.PhysicalObject
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Sends Computer Vision states.
 * 
 * @author benedekh
 */
class ComputerVisionStateSender implements IComputerVisionStateSender {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var MessagingService mms
	
	/**
	 * @param mms the messaging service to the track
	 * @param factory the logger factory
	 */
	new(MessagingService mms, ILoggerFactory factory) {
		this.mms = mms
		this.logger = factory.getLogger(this.class.name)
	}

	override sendComputerVisionState(Map<String, PhysicalObject> physicalObjects, long timestamp, long frameIndex) {
		mms.sendMessage(new ComputerVisionObjectPositionsMessage(physicalObjects, timestamp, frameIndex))
		logger.debug('''ComputerVisionState message sent with physicalObjects=«physicalObjects» timestamp=«timestamp» frameIndex=«frameIndex»''')
	}

}
