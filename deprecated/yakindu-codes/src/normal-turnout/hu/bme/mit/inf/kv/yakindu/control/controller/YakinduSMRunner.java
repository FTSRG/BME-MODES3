package hu.bme.mit.inf.kv.yakindu.control.controller;

import hu.bme.mit.inf.kv.yakindu.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.kv.yakindu.control.sm.Section;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.getStateMachineMQTTConfiguration;
import hu.bme.mit.inf.kv.yakindu.control.transmitter.DistributedMessageTransmitter;
import hu.bme.mit.inf.kv.yakindu.control.transmitter.GeneralTransmitter;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.DistributedMessageReceiver;
import java.util.Set;

import org.yakindu.scr.turnout.TurnoutWrapper;

/**
 *
 * @author benedekh
 */
public class YakinduSMRunner {

    private final TurnoutWrapper managedStatemachine;
    private final Set<Section> managedSections;

    private final GeneralTransmitter generalTransmitter;
    private final DistributedMessageTransmitter distributedTransmitter;

    private final DistributedMessageReceiver messageReceiver;

    public YakinduSMRunner(YakinduSMConfiguration conf) {
        TurnoutWrapper statemachine = conf.getTurnoutStatemachine();
        int turnoutSectionId = conf.getTurnoutSectionId();
        Set<Section> localSections = conf.getManagedSections();

        this.managedStatemachine = statemachine;
        this.managedSections = localSections;

        int managedTurnoutId = (int) statemachine.getSCITurnout().getId();
        int managedTurnoutSectionId = turnoutSectionId;

        this.generalTransmitter = new GeneralTransmitter(managedTurnoutId,
                managedTurnoutSectionId, localSections, statemachine);
        this.distributedTransmitter = new DistributedMessageTransmitter(
                statemachine);
        this.messageReceiver = new DistributedMessageReceiver(
                getStateMachineMQTTConfiguration(), distributedTransmitter,
                managedTurnoutId);

        generalTransmitter.setName(GeneralTransmitter.class.getName());
        distributedTransmitter.setName(
                DistributedMessageTransmitter.class.getName());
    }

    public void start() {
        initializeSM();
        startSM();
    }

    private void initializeSM() {
        managedStatemachine.enter();
        for (Section sections : managedSections) {
            sections.enter();
        }
    }

    private void startSM() {
        new Thread(managedStatemachine).start();
        for (Section sections : managedSections) {
            sections.start();
        }

        generalTransmitter.start();
        distributedTransmitter.start();
    }

}
