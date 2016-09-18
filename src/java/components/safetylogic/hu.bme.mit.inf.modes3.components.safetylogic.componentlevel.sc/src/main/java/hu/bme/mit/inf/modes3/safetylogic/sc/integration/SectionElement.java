package hu.bme.mit.inf.modes3.safetylogic.sc.integration;

import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.ISectionStatemachine.SCIProtocolListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class SectionElement implements SCIProtocolListener, IReservationProtocol {

	protected ISectionStatemachine statemachine;
	protected NextTrackElementInReservationProtocol nextTrackElement;

	public SectionElement(ISectionStatemachine statemachine, NextTrackElementInReservationProtocol nextTrackElement) {
		this.statemachine = statemachine;
		this.nextTrackElement = nextTrackElement;

		statemachine.getSCIProtocol().getListeners().add(this);
	}

	@Override
	public void onReserveToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom)) {
			nextTrackElement.raiseReserveFrom(nextTrackElement.itSeeUsFrom.getValueInYakindu());
		}
	}

	@Override
	public void onCanGoToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom)) {
			nextTrackElement.raiseCanGoFrom(nextTrackElement.itSeeUsFrom.getValueInYakindu());
		}
	}

	@Override
	public void onCannotGoToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom)) {
			nextTrackElement.raiseCannotGoFrom(nextTrackElement.itSeeUsFrom.getValueInYakindu());
		}
	}

	@Override
	public void onReleaseToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom)) {
			nextTrackElement.raiseReleaseFrom(nextTrackElement.itSeeUsFrom.getValueInYakindu());
		}
	}

	@Override
	public void raiseReserveFrom(int value) {
		statemachine.getSCIProtocol().raiseReserveFrom(value);
	}

	@Override
	public void raiseCanGoFrom(int value) {
		statemachine.getSCIProtocol().raiseCanGoFrom(value);
	}

	@Override
	public void raiseCannotGoFrom(int value) {
		statemachine.getSCIProtocol().raiseCannotGoFrom(value);
	}

	@Override
	public void raiseReleaseFrom(int value) {
		statemachine.getSCIProtocol().raiseReleaseFrom(value);
	}

}
