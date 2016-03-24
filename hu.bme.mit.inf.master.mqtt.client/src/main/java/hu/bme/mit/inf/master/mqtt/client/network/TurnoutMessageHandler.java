package hu.bme.mit.inf.master.mqtt.client.network;

import hu.bme.mit.inf.master.bbb.strategy.ExpanderTurnoutController;
import hu.bme.mit.inf.mqtt.common.data.Command;
import static hu.bme.mit.inf.mqtt.common.data.Command.SEND_TURNOUT_STATUS;
import hu.bme.mit.inf.mqtt.common.data.Payload;
import hu.bme.mit.inf.mqtt.common.data.Turnout;
import hu.bme.mit.inf.mqtt.common.data.TurnoutStatus;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.createCommandWithContent;
import static hu.bme.mit.inf.mqtt.common.network.PayloadHelper.getPayloadFromMessage;
import hu.bme.mit.inf.mqtt.common.network.RequestSender;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author benedekh
 */
public class TurnoutMessageHandler extends RequestSender {

    private static final String CLASS_NAME = SectionsMessageHandler.class.getName();

    private final ExpanderTurnoutController turnoutController;

    public TurnoutMessageHandler(MQTTPublisherSubscriber pubsub) throws MqttException {
        super("modes3/kvcontrol/turnout", pubsub);
        this.turnoutController = new ExpanderTurnoutController(this);
    }

    @Override
    public void filteredMessageArrived(MqttMessage message) {
        try {
            Payload payload = getPayloadFromMessage(message);
            Command command = payload.getCommand();

            switch (command) {
                case IDENTIFY:
                    handleIdentify();
                    break;
                case GET_TURNOUT_STATUS:
                    handleGetTurnoutStatus(payload);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            logException(CLASS_NAME, new Exception(ex));
        }
    }

    private void handleIdentify() throws InterruptedException {
        List<Turnout> turnouts = turnoutController.getTurnoutsWithStatus();
        for (Turnout turnout : turnouts) {
            Payload payload = createCommandWithContent(SEND_TURNOUT_STATUS,
                    turnout);
            publishMessage(payload);
            Thread.sleep(10);
        }
    }

    private void handleGetTurnoutStatus(Payload receivedPayload) {
        Turnout turnout = receivedPayload.getContentAs(Turnout.class);
        if (turnoutController.controllerManagesTurnout(turnout)) {
            logInfoMessage(CLASS_NAME,
                    "turnout status query received");

            TurnoutStatus status = turnoutController.getTurnoutStatus(
                    turnout.getId());
            turnout.setStatus(status);
            Payload payload = createCommandWithContent(SEND_TURNOUT_STATUS,
                    turnout);
            publishMessage(payload);
        }
    }

}
