package hu.bme.mit.inf.modes3.components.dashboard.service;

import javax.inject.Inject;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.PathParam;
import org.atmosphere.cpr.MetaBroadcaster;
import org.slf4j.Logger;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import hu.bme.mit.inf.modes3.components.dashboard.main.DashboardManager;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentStateChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener;

@ManagedService(path = "/ws/state/{target}")
public class StateChangeService implements ISegmentOccupancyChangeListener, ITurnoutStateChangeListener, ISegmentStateChangeListener {
	
	public final static String SEGMENT_OCCUPACY = "segmentoccupancy";
	public final static String SEGMENT_STATE = "segmentstate";
	public final static String TURNOUT_STATE = "turnoutstate";
	
	Logger logger = DashboardManager.INSTANCE.getLoggerFactory().getLogger(StateChangeService.class.getName());
	
	@Inject
	protected MetaBroadcaster metaBroadcaster;
	
	@PathParam
	protected String target;
	
	hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancy.Builder segmentOccBuilder;
	hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState.Builder segmentStateBuilder;
	hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState.Builder turnoutStateBuilder;
	
	public StateChangeService() {
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setSegmentOccupancyChangeListener(this);
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setSegmentStateChangeListener(this);
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setTurnoutStateChangeListener(this);
		segmentOccBuilder = hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancy.newBuilder();
		segmentStateBuilder = hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState.newBuilder();
		turnoutStateBuilder = hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState.newBuilder();
	}
	
	@Override
	public void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		String occupancyAsJson;
		try {
			occupancyAsJson = JsonFormat.printer().print(segmentOccBuilder.clear()
					.setSegmentID(id)
					.setStateValue(newValue.ordinal()));
					metaBroadcaster.broadcastTo("/ws/state/" + SEGMENT_OCCUPACY, occupancyAsJson);
		} catch (InvalidProtocolBufferException e) {
			logger.error("Unable to convert & push segment occupancy message " + e.getMessage());
		}
	}

	@Override
	public void onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue ) {
		String stateAsJson;
		try {
			stateAsJson = JsonFormat.printer().print(segmentStateBuilder.clear()
					.setSegmentID(id)
					.setStateValue(newValue.ordinal()));
					metaBroadcaster.broadcastTo("/ws/state/" + SEGMENT_STATE, stateAsJson);
		} catch (InvalidProtocolBufferException e) {
			logger.error("Unable to convert & push turnout state message " + e.getMessage());
		}
	}

	@Override
	public void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		String stateAsJson;
		try {
			stateAsJson = JsonFormat.printer().print(turnoutStateBuilder.clear()
					.setTurnoutID(id)
					.setStateValue(newValue.ordinal()));
					metaBroadcaster.broadcastTo("/ws/state/" + TURNOUT_STATE, stateAsJson);
		} catch (InvalidProtocolBufferException e) {
			logger.error("Unable to convert & push turnout state message " + e.getMessage());
		}
	}
	
}
