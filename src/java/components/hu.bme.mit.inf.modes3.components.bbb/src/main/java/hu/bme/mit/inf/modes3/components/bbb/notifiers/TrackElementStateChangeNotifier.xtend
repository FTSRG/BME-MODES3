package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.BoardWrapper
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.slf4j.ILoggerFactory

/**
 * Encapsulates a SectionStateNotifier along with a TurnoutStateNotifier so that instantiating
 * this class can send status change information about the sections and turnouts to the network.
 * 
 * @author benedekh
 */
class TrackElementStateChangeNotifier extends TrackElementStateNotifier {

	new(TrackCommunicationServiceLocator locator, ExpanderSectionController sectionController, ExpanderTurnoutController turnoutController, ILoggerFactory factory) {
		super(new SectionStateChangeNotifier(locator.trackElementStateSender, sectionController, factory), new TurnoutStateChangeNotifier(locator.trackElementStateSender, turnoutController, factory),
			factory)
	}

	private new(int turnoutID, TrackCommunicationServiceLocator locator, BoardWrapper board, ILoggerFactory factory) {
		this(locator, new ExpanderSectionController(turnoutID, board, factory), new ExpanderTurnoutController(turnoutID, board, factory), factory)
	}

	new(int turnoutID, TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		this(turnoutID, locator, new BoardWrapper(factory), factory)
	}
}
