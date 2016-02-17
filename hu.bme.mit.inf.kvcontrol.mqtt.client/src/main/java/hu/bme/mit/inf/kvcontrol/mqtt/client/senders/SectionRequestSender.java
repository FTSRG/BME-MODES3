package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.GET_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_DISABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.LINE_ENABLE;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_SECTION_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.DISABLED;
import static hu.bme.mit.inf.mqtt.common.data.SectionStatus.ENABLED;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.sendCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.util.ClientIdGenerator.generateId;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class SectionRequestSender implements MqttCallback {

    private final MQTTPublisherSubscriber sender;

    private final Map<Integer, CompletableFuture<SectionStatus>> sectionStatuses = new ConcurrentHashMap<>();

    public SectionRequestSender(MQTTConfiguration config) {
        config.setClientID(generateId(getClass().getSimpleName()));

        this.sender = new MQTTPublisherSubscriber(config);
        this.sender.subscribe(this);
    }

    public boolean isSectionEnabled(int sectionId) {
        if (!sectionStatuses.containsKey(sectionId)) {
            sectionStatuses.put(sectionId, new CompletableFuture<>());
        }

        Section section = new Section(sectionId);
        sendCommandWithContent(GET_SECTION_STATUS, section, sender);

        SectionStatus status = null;
        try {
            status = sectionStatuses.get(sectionId).get();
            sectionStatuses.remove(sectionId);
        } catch (InterruptedException | ExecutionException ex) {
            logException(getClass().getName(), ex);
        }

        return status == ENABLED;
    }

    public void enableSection(int sectionId) {
        Section section = new Section(sectionId, ENABLED);
        sendCommandWithContent(LINE_ENABLE, section, sender);
    }

    public void disableSection(int sectionId) {
        Section section = new Section(sectionId, DISABLED);
        sendCommandWithContent(LINE_DISABLE, section, sender);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            if (!sender.getSubscribedTopic().equals(topic)) {
                return;
            }

            Payload payload = getPayloadFromMessage(message);
            Command command = payload.getCommand();

            switch (command) {
                case SEND_SECTION_STATUS:
                    Section section = payload.getContentAs(Section.class);
                    CompletableFuture<SectionStatus> future = sectionStatuses.get(
                            section.getId());

                    if (future != null) {
                        future.complete(section.getStatus());
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(getClass().getName(), new Exception(ex));
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logException(getClass().getName(), new Exception(cause));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // deliberately left empty
    }
}
