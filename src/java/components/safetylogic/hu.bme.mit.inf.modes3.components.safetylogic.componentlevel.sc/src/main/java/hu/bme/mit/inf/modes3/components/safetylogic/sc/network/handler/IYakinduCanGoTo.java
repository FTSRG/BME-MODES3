package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;

public interface IYakinduCanGoTo {
	void canGoTo(final int targetID, final ConnectionDirection direction);
}
