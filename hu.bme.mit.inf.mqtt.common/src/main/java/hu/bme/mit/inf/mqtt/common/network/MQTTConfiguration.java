package hu.bme.mit.inf.mqtt.common.network;

/**
 *
 * @author benedekh
 */
public class MQTTConfiguration {

    private String protocol = "tcp";
    private String address = "localhost";
    private int port = 1883;

    private int qos = 1;
    private String clientId = new String();

    public MQTTConfiguration() {
    	
    }
    
    public MQTTConfiguration(String address) {
    	this.address = address;
    }
    
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setQOS(int qos) {
        this.qos = qos;
    }

    public void setClientID(String clientId) {
        this.clientId = clientId;
    }

    public String getClientID() {
        return this.clientId;
    }

    public String getFullAddress() {
        return protocol + "://" + address + ":" + port;
    }

    public int getQOS() {
        return this.qos;
    }

}
