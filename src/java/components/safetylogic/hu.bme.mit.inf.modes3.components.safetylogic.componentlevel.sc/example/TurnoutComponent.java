import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
    	
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;
import org.yakindu.scr.turnout.TurnoutStatemachine;
import org.yakindu.scr.turnout.TurnoutStatemachine.State;

interface TurnoutComponentInterface {
	
	void raiseReserveFromRight( );
	
	void raiseSwitch( );
	
	void raiseReserveFromLeft( );
	
	void raiseReserveResultFromLeft(boolean value);
	
	void raiseReserveResultFromBottom(boolean value);
	
	void raiseReleaseFromBottom( );
	
	void raiseReleaseFromLeft( );
	
	void raiseReserveFromBottom( );
	
	void raiseReleaseFromRight( );
	
	void raiseReserveResultFromRight(boolean value);
}

public class TurnoutComponent implements TurnoutComponentInterface {
	// The wrapped Yakindu statemachine
	private TurnoutStatemachine turnoutStatemachine = new TurnoutStatemachine();
	
	// Indicates which queue is active in this synchronization turn
	private boolean chooseList = true;
	// Event queues for the synchronization of statecharts
	private Queue<Message> eventQueue1 = new LinkedList<Message>();
	private Queue<Message> eventQueue2 = new LinkedList<Message>();
	
	public TurnoutComponent() {
		// Initializing and entering the wrapped statemachine
		turnoutStatemachine.init();
		turnoutStatemachine.enter();
	}

	void changeEventQueue() {
		chooseList = !chooseList;
	}
	
	boolean isEventQueueEmpty() {
		return getInsertQueue().isEmpty();
	}
	
	private Queue<Message> getInsertQueue() {
		if (chooseList) {
			return eventQueue1;
		}
		return eventQueue2;
	}
	
	private Queue<Message> getProcessQueue() {
		return getInsertQueue() == eventQueue1 ? eventQueue2 : eventQueue1; 
	}
	
	
	void runCycle() {
	   Queue<Message> eventQueue = getProcessQueue();
	   while (!eventQueue.isEmpty()) {
	   		Message event = eventQueue.remove();
	   		switch (event.getEvent()) {
	   			case "switch":
	   				turnoutStatemachine.getSCITurnout().raiseSwitch();
	   				break; 
	   			case "reserveFromLeft":
	   				turnoutStatemachine.getSCITurnout().raiseReserveFromLeft();
	   				break; 
	   			case "reserveResultFromLeft":
	   				turnoutStatemachine.getSCITurnout().raiseReserveResultFromLeft((Boolean) event.getValue());
	   				break; 
	   			case "reserveResultFromBottom":
	   				turnoutStatemachine.getSCITurnout().raiseReserveResultFromBottom((Boolean) event.getValue());
	   				break; 
	   			case "releaseFromBottom":
	   				turnoutStatemachine.getSCITurnout().raiseReleaseFromBottom();
	   				break; 
	   			case "reserveFromRight":
	   				turnoutStatemachine.getSCITurnout().raiseReserveFromRight();
	   				break; 
	   			case "releaseFromLeft":
	   				turnoutStatemachine.getSCITurnout().raiseReleaseFromLeft();
	   				break; 
	   			case "releaseFromRight":
	   				turnoutStatemachine.getSCITurnout().raiseReleaseFromRight();
	   				break; 
	   			case "reserveFromBottom":
	   				turnoutStatemachine.getSCITurnout().raiseReserveFromBottom();
	   				break; 
	   			case "reserveResultFromRight":
	   				turnoutStatemachine.getSCITurnout().raiseReserveResultFromRight((Boolean) event.getValue());
	   				break; 
	   			default:
	   				throw new IllegalArgumentException("No such event!");
	   		}
	   }
	   turnoutStatemachine.runCycle();
	}
	
	public void raiseReserveFromRight( ) {
		getInsertQueue().add(new Message("reserveFromRight", null));
	}
	
	public void raiseSwitch( ) {
		getInsertQueue().add(new Message("switch", null));
	}
	
	public void raiseReserveFromLeft( ) {
		getInsertQueue().add(new Message("reserveFromLeft", null));
	}
	
	public void raiseReserveResultFromLeft(boolean value) {
		getInsertQueue().add(new Message("reserveResultFromLeft", value));
	}
	
	public void raiseReserveResultFromBottom(boolean value) {
		getInsertQueue().add(new Message("reserveResultFromBottom", value));
	}
	
	public void raiseReleaseFromBottom( ) {
		getInsertQueue().add(new Message("releaseFromBottom", null));
	}
	
	public void raiseReleaseFromLeft( ) {
		getInsertQueue().add(new Message("releaseFromLeft", null));
	}
	
	public void raiseReserveFromBottom( ) {
		getInsertQueue().add(new Message("reserveFromBottom", null));
	}
	
	public void raiseReleaseFromRight( ) {
		getInsertQueue().add(new Message("releaseFromRight", null));
	}
	
	public void raiseReserveResultFromRight(boolean value) {
		getInsertQueue().add(new Message("reserveResultFromRight", value));
	}
	
	List<SCITurnoutListener> getSCITurnoutListeners() {
		return turnoutStatemachine.getSCITurnout().getListeners();
	}
	
	public boolean isStateActive(State state) {
		return turnoutStatemachine.isStateActive(state);
	}
	
}
