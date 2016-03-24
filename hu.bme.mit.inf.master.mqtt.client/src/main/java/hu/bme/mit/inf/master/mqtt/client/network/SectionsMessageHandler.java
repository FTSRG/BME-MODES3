package hu.bme.mit.inf.master.mqtt.client.network;

import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_SECTION_STATUS;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import hu.bme.mit.inf.master.bbb.strategy.ExpanderSectionController;
import hu.bme.mit.inf.mqtt.common.data.Command;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.SectionStatus;
import hu.bme.mit.inf.mqtt.common.network.MessageFilter;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import java.util.List;

/**
 *
 * @author benedekh, hegyibalint
 */
public class SectionsMessageHandler implements MessageFilter {

    private static final String topic = "modes3/kvcontrol/section";
    private static final String CLASS_NAME = SectionsMessageHandler.class.getName();

    private final ExpanderSectionController sectionController;
    private final MQTTPublishSubscribeDispatcher sender;

    public SectionsMessageHandler(MQTTPublishSubscribeDispatcher sender) {
        this.sender = sender;
        this.sender.subscribe(topic, this);
        this.sectionController = new ExpanderSectionController(this.sender,
                topic);
    }

    @Override
    public void filteredMessageArrived(MqttMessage message) {
        try {
            Payload payload = getPayloadFromMessage(message);
            Command command = payload.getCommand();

            switch (command) {
                case IDENTIFY:
                    handleIdentify();
                case GET_SECTION_STATUS:
                    handleGetSectionStatus(payload);
                    break;
                case LINE_ENABLE:
                    handleLineEnable(payload);
                    break;
                case LINE_DISABLE:
                    handleLineDisable(payload);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(CLASS_NAME, new Exception(ex));
        }
    }

    private void handleIdentify() throws InterruptedException {
        List<Section> sections = sectionController.getSectionsWithStatus();
        for (Section section : sections) {
            Payload payload = createCommandWithContent(SEND_SECTION_STATUS,
                    section);
            sender.publishMessage(payload, topic);
            Thread.sleep(10);
        }
    }

    private void handleGetSectionStatus(Payload receivedPayload) {
        Section section = receivedPayload.getContentAs(Section.class);
        if (sectionController.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "section " + section.getId() + " status query received");

            SectionStatus status = sectionController.getSectionStatus(
                    section.getId());
            section.setStatus(status);
            Payload payload = createCommandWithContent(SEND_SECTION_STATUS,
                    section);
            sender.publishMessage(payload, topic);
        }
    }

    private void handleLineEnable(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (sectionController.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "enable section " + section.getId() + " command received");

            sectionController.enableSection(section.getId());
        }
    }

    private void handleLineDisable(Payload payload) {
        Section section = payload.getContentAs(Section.class);
        if (sectionController.controllerManagesSection(section)) {
            logInfoMessage(CLASS_NAME,
                    "disable section " + section.getId() + " command received");

            sectionController.disableSection(section.getId());
        }
    }

}
