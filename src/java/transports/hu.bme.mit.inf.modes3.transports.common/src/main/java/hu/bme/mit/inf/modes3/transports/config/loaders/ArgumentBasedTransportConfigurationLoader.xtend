package hu.bme.mit.inf.modes3.transports.config.loaders

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration

class ArgumentBasedTransportConfigurationLoader {
		
	static def TransportConfiguration loadMQTTConfiguration(ArgumentRegistry registry){
		val address = registry.getParameterStringValue('address')
		val id = registry.getParameterStringValue('id')
		val port = registry.getParameterIntegerValue('port')
		val topic = registry.getParameterStringValue('topic')
		
		return new TransportConfiguration(id, address, port, topic)
	}
	
}
