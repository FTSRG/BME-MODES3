package hu.bme.mit.inf.modes3.safetylogic.sc.conf;

public class TurnoutConfiguration {

	protected String name;

	protected int occupancyId;

	protected ConnectingTrackElementConfiguration straight;

	protected ConnectingTrackElementConfiguration divergent;

	protected ConnectingTrackElementConfiguration top;

	public TurnoutConfiguration(String name, int occupancyId, ConnectingTrackElementConfiguration straight, ConnectingTrackElementConfiguration divergent,
			ConnectingTrackElementConfiguration top) {
		this.name = name;
		this.occupancyId = occupancyId;
		this.straight = straight;
		this.divergent = divergent;
		this.top = top;
	}

	public String getName() {
		return name;
	}

	public int getOccupancyId() {
		return occupancyId;
	}

	public ConnectingTrackElementConfiguration getStraight() {
		return straight;
	}

	public ConnectingTrackElementConfiguration getDivergent() {
		return divergent;
	}

	public ConnectingTrackElementConfiguration getTop() {
		return top;
	}

}
