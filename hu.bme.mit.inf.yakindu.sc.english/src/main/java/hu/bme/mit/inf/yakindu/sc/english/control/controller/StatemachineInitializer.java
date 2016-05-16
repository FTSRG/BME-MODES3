package hu.bme.mit.inf.yakindu.sc.english.control.controller;

import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.SectionRequestSender;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.yakindu.sc.english.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.yakindu.sc.english.control.sm.RemoteTurnout;
import hu.bme.mit.inf.yakindu.sc.english.control.sm.Section;
import static hu.bme.mit.inf.yakindu.sc.english.control.sm.handler.DirectionConverterHelper.getValueFromDirection;
import hu.bme.mit.inf.yakindu.sc.english.control.sm.handler.SectionEventListener;
import hu.bme.mit.inf.yakindu.sc.english.control.sm.handler.TurnoutEventListener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.TOP;
import java.util.HashMap;
import java.util.Map;

import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.SectionWrapperWithListeners;
import org.yakindu.scr.turnout.ITurnoutStatemachine;
import org.yakindu.scr.turnout.TurnoutWrapperWithListeners;

/**
 * This class instantiates and initializes the respective statecharts, based on
 * the turnout's ID (see respective methods). Each method requires only the MQTT
 * subscriber through the MQTT communication will be done.
 *
 * @author benedekh
 */
public class StatemachineInitializer {

    private static final long DIVERGENT_VALUE = getValueFromDirection(DIVERGENT);
    private static final long STRAIGHT_VALUE = getValueFromDirection(STRAIGHT);

    /**
     * Instantiates and initializes the statemachines of 0x86 turnout, and the
     * connecting sections' statecharts as well.
     *
     * @param sender the object used for the MQTT communication
     * @return a configuration that stores the initialized statecharts
     */
    public static YakinduSMConfiguration initialize0x86(
            MQTTPublishSubscribeDispatcher sender) {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x86;
        int turnoutSectionID = 0x04;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);
        turnoutStatemachine.getSCITurnout().setIsOccupied(false);

        conf.setTurnoutSectionId(turnoutSectionID);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x10;
        int strSectionID = 0x15;

        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                divSectionID, turnoutStatemachine, DIVERGENT_VALUE, sender);
        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                strSectionID, turnoutStatemachine, STRAIGHT_VALUE, sender);

        Section divSection = new Section(divSectionID, divSectionSM);
        Section strSection = new Section(strSectionID, strSectionSM);

        Set<Section> managedSections = new HashSet<>(Arrays.asList(divSection,
                strSection));
        conf.setManagedSections(managedSections);

        Map<Direction, ISectionStatemachine> localSections = new HashMap<>();
        localSections.put(DIVERGENT, divSectionSM);
        localSections.put(STRAIGHT, strSectionSM);

        Map<Direction, RemoteTurnout> remoteTurnouts = new HashMap<>();
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, TOP, 0x84));
        remoteTurnouts.put(STRAIGHT, new RemoteTurnout(STRAIGHT, TOP, 0x85));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        conf.setTurnoutEventListener(outgoingEventListener);
        return conf;
    }

    /**
     * Instantiates and initializes the statemachines of 0x87 turnout, and the
     * connecting sections' statecharts as well.
     *
     * @param sender the object used for the MQTT communication
     * @return a configuration that stores the initialized statecharts
     */
    public static YakinduSMConfiguration initialize0x87(
            MQTTPublishSubscribeDispatcher sender) {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x87;
        int turnoutSectionID = 0x04;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);
        turnoutStatemachine.getSCITurnout().setIsOccupied(false);

        conf.setTurnoutSectionId(turnoutSectionID);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x0E;
        int strSectionID = 0x16;

        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                divSectionID, turnoutStatemachine, DIVERGENT_VALUE, sender);
        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                strSectionID, turnoutStatemachine, STRAIGHT_VALUE, sender);

        Section divSection = new Section(divSectionID, divSectionSM);
        Section strSection = new Section(strSectionID, strSectionSM);

        Set<Section> managedSections = new HashSet<>(Arrays.asList(divSection,
                strSection));
        conf.setManagedSections(managedSections);

        Map<Direction, ISectionStatemachine> localSections = new HashMap<>();
        localSections.put(DIVERGENT, divSectionSM);
        localSections.put(STRAIGHT, strSectionSM);

        Map<Direction, RemoteTurnout> remoteTurnouts = new HashMap<>();
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, TOP, 0x81));
        remoteTurnouts.put(STRAIGHT, new RemoteTurnout(STRAIGHT, STRAIGHT, 0x82));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        conf.setTurnoutEventListener(outgoingEventListener);
        return conf;
    }

    /**
     * Create the section's statemachine based on its ID.
     *
     * @param sectionID the ID of the section whose statemachine should be
     * created.
     * @param turnoutStatemachine the statechart of the turnout to whom the
     * section connects
     * @param directionValue the direction from which the section connects to
     * the turnout
     * @param sender the object used for the MQTT communication
     *
     * @return the section's statechart implementation with trace logging
     * capabilites
     */
    private static SectionWrapperWithListeners createSectionStatemachine(
            int sectionID, ITurnoutStatemachine turnoutStatemachine,
            long directionValue, MQTTPublishSubscribeDispatcher sender) {
        SectionWrapperWithListeners sectionStatemachine = new SectionWrapperWithListeners(
                "section" + String.valueOf(sectionID));
        sectionStatemachine.init();
        sectionStatemachine.getSCISection().setId(sectionID);
        sectionStatemachine.getSCISection().setDirection(directionValue);

        SectionRequestSender requestSender = new SectionRequestSender(sender);

        SectionEventListener outgoingEventListener = new SectionEventListener(
                turnoutStatemachine, requestSender);
        sectionStatemachine.addListener(outgoingEventListener);

        return sectionStatemachine;
    }

}
