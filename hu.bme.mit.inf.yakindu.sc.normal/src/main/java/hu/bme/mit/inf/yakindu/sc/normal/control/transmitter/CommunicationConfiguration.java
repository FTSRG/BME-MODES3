package hu.bme.mit.inf.yakindu.sc.normal.control.transmitter;

import hu.bme.mit.inf.kvcontrol.requests.AbstractRequest;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;

/**
 *
 * @author benedekh
 */
public class CommunicationConfiguration {

    private static MQTTConfiguration statemachineMQTTConf;

    public static void setKvControlAddress(String address) {
        AbstractRequest.setDefultAddress("http://" + address);
    }

    public static void setKvControlPort(int port) {
        AbstractRequest.setDefaultPort(port);
    }

    public static void setStateMachineMQTTConfiguration(MQTTConfiguration conf) {
        statemachineMQTTConf = conf;
    }

    public static MQTTConfiguration getStateMachineMQTTConfiguration() {
        return statemachineMQTTConf;
    }
}
