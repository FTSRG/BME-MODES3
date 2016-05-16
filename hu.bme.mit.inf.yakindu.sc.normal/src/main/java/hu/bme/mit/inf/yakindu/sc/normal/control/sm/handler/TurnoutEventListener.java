package hu.bme.mit.inf.yakindu.sc.normal.control.sm.handler;

import static hu.bme.mit.inf.yakindu.sc.normal.control.helper.NullSection.NULL_SECTION;
import hu.bme.mit.inf.yakindu.sc.normal.control.sm.RemoteTurnout;

import java.util.Map;
import static hu.bme.mit.inf.yakindu.sc.normal.control.sm.handler.DirectionConverterHelper.getDirectionFromValue;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logInfoMessage;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance.ALLOWED;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Allowance.DENIED;
import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.DistributedMessageReceiver;
import hu.bme.mit.inf.yakindu.mqtt.client.senders.PassageRequestSender;
import hu.bme.mit.inf.yakindu.mqtt.client.senders.PassageResponseSender;
import hu.bme.mit.inf.yakindu.mqtt.client.senders.ShortPassageRequestSender;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.ISectionStatemachine.SCISection;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCISectionsListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

/**
 * Event handler for outgoing events from the turnout's statechart.
 *
 * @author benedekh
 */
public class TurnoutEventListener implements SCITurnoutListener, SCISectionsListener {

    // the remote turnout's sections with their connection directions
    private final Map<Direction, RemoteTurnout> remoteSections;
    // the local sections statecharts with their connection directions
    private final Map<Direction, ISectionStatemachine> localSections;

    // passage request sender object (for communication between remote statecharts)
    private PassageRequestSender passageRequest = null;
    // short passage request sender object (for communication between remote statecharts)
    private ShortPassageRequestSender shortPassageRequest = null;
    // passage response sender object (for communication between remote statecharts)
    private PassageResponseSender passageResponse = null;

    /**
     * @param remoteSections // the remote turnout's sections with their
     * connection directions
     * @param localSections the local sections statecharts with their connection
     * directions
     */
    public TurnoutEventListener(Map<Direction, RemoteTurnout> remoteSections,
            Map<Direction, ISectionStatemachine> localSections) {
        this.remoteSections = remoteSections;
        this.localSections = localSections;
    }

    /**
     * Initialize the [Short]Passage[Request|Response]Senders based on the
     * common MQTT connection.
     *
     * @param sender the common MQTT sender/receiver.
     */
    public void setRequestSenders(DistributedMessageReceiver sender) {
        this.passageRequest = new PassageRequestSender(sender);
        this.shortPassageRequest = new ShortPassageRequestSender(sender);
        this.passageResponse = new PassageResponseSender(sender);
    }

    @Override
    public void onSectionAllowedToRaised(long directionValue) {
        getLocalSectionByDirectionValue(directionValue).raiseSectionAllowedTo(
                directionValue);
    }

    @Override
    public void onSectionLockedToRaised(long directionValue) {
        getLocalSectionByDirectionValue(directionValue).raiseSectionLockedTo(
                directionValue);
    }

    @Override
    public void onSectionLockedWithReplyToRaised(long directionValue) {
        getLocalSectionByDirectionValue(directionValue).raiseSectionLockedWithReplyTo(
                directionValue);
    }

    @Override
    public void onLockRequestToRaised(long directionValue) {
        getLocalSectionByDirectionValue(directionValue).raiseLockRequestTo(
                directionValue);
    }

    /**
     * Get the local section's event handler by its connection direction.
     *
     * @param directionValue the connection direction based on the statechart
     * long value
     * @return
     */
    private SCISection getLocalSectionByDirectionValue(long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        SCISection section;
        try {
            section = localSections.get(direction).getSCISection();
        } catch (NullPointerException ex) {
            section = NULL_SECTION;
        }
        return section;
    }

    @Override
    public void onRemShortPassageRequestToRaised(long directionValue) {
        sendShortPassageRequest(directionValue);
    }

    @Override
    public void onRemPassageAllowedToRaised(long directionValue) {
        sendPassageAllowed(directionValue);
    }

    @Override
    public void onRemPassageDeniedToRaised(long directionValue) {
        sendPassageDeniedTo(directionValue);
    }

    @Override
    public void onRemPassageRequestToRaised(long directionValue) {
        sendPassageRequest(directionValue);
    }

    @Override
    public void onRemPassageDeniedToAllRaised() {
        for (Direction direction : remoteSections.keySet()) {
            sendPassageDenied(direction);
        }
    }

    /**
     * Send a short passage request to the remote turnout through MQTT.
     *
     * @param directionValue the direction of the connecting turnout's
     * statechart
     */
    private void sendShortPassageRequest(long directionValue) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(
                directionValue);

        shortPassageRequest.sendShortPassageRequest(
                remoteTurnout.getLocalDirection(), remoteTurnout.getTurnoutId());

        logInfoMessage(getClass().getName(),
                "short passage request sent to " + remoteTurnout.getTurnoutId());
    }

    /**
     * Send a passage request to the remote turnout through MQTT.
     *
     * @param directionValue the direction of the connecting turnout's
     * statechart
     */
    private void sendPassageRequest(long directionValue) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(
                directionValue);

        passageRequest.sendPassageRequest(remoteTurnout.getLocalDirection(),
                remoteTurnout.getTurnoutId());

        logInfoMessage(getClass().getName(),
                "passage request sent to " + remoteTurnout.getTurnoutId());
    }

    /**
     * Send a passage allowed response to the remote turnout through MQTT.
     *
     * @param directionValue the direction of the connecting turnout's
     * statechart
     */
    private void sendPassageAllowed(long directionValue) {
        RemoteTurnout remoteTurnout = getRemoteTurnoutByDirectionValue(
                directionValue);

        passageResponse.sendPassageResponse(remoteTurnout.getLocalDirection(),
                ALLOWED, remoteTurnout.getTurnoutId());

        logInfoMessage(getClass().getName(),
                "passage allowed sent to " + remoteTurnout.getTurnoutId());
    }

    /**
     * Send a passage denied response to the remote turnout through MQTT.
     *
     * @param directionValue the direction of the connecting turnout's
     * statechart
     */
    private void sendPassageDeniedTo(long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        sendPassageDenied(direction);
    }

    /**
     * Send a passage denied response to the remote turnout through MQTT.
     *
     * @param direction the direction of the connecting turnout's statechart
     */
    private void sendPassageDenied(Direction direction) {
        RemoteTurnout remoteTurnout = remoteSections.get(direction);

        passageResponse.sendPassageResponse(remoteTurnout.getLocalDirection(),
                DENIED, remoteTurnout.getTurnoutId());

        logInfoMessage(getClass().getName(),
                "passage denied sent to " + remoteTurnout.getTurnoutId());
    }

    /**
     * Get the remote turnout's object by its connection direction in the
     * statechart.
     *
     * @param directionValue the direction of the connection turnout's
     * statechart
     * @return
     */
    private RemoteTurnout getRemoteTurnoutByDirectionValue(long directionValue) {
        Direction direction = getDirectionFromValue(directionValue);
        RemoteTurnout remoteTurnout = remoteSections.get(direction);
        return remoteTurnout;
    }

}
