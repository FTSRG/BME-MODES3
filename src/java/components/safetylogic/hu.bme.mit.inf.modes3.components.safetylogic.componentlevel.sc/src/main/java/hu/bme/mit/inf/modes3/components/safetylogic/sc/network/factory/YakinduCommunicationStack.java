package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.factory;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.YakinduMessageDispatcher;
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.transports.common.Transport;

public class YakinduCommunicationStack extends CommunicationStack {

	protected YakinduCommunicationStack(MessagingService mms, Transport transport) {
		super(mms, transport, new YakinduMessageDispatcher());
	}

	public YakinduCommunicationStack(MessagingService mms, Transport transport, YakinduMessageDispatcher dispatcher) {
		super(mms, transport, dispatcher);
	}

}
