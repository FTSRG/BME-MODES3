package hu.bme.mit.inf.modes3.components.trackelementcontroller.controllers

import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio
import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.InputStateListener
import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Level
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioNotConfiguratedException
import hu.bme.mit.inf.modes3.components.trackelementcontroller.config.ExpanderConfigInterpreter
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * The state controller of a turnout.
 * It can switch the direction of a turnout physically, through GPIO ports. 
 * 
 * @author hegyibalint
 */
class PhysicalTurnoutController implements InputStateListener {
	
	/**
	 * A listener for the change of the turnout state. 
	 * 
	 * @author hegyibalint
	 */
	public interface ITurnoutStateChangedListener {
	/**
	 * Processes the change of the turnout's state.
	 * 
	 * @param newState the new state of the turnout
	 */
		def void onStateChanged(TurnoutState newState);
	}

	/**
	 * for each turnout controller, we have to use four gpio pins:
	 * two for control the turnout itself, and other two to get info
	 * about the current state
	 */
	Gpio straightControl;

	Gpio divergentControl;

	Gpio straightState;

	Gpio divergentState;

	PhysicalTurnoutController.ITurnoutStateChangedListener listener;

	private final static int TURNOUT_IMPULSE_WIDTH = 200;

	val Logger logger

	String expander

	/**
	 * @param pinout the interpeter of the pinout configuration
	 * @param expander the ID of the expander that controls the turnout (physically)
	 * @param factory the logger factory
	 */
	new(ExpanderConfigInterpreter pinout, String expander, ILoggerFactory factory) {
		this.expander = expander;
		logger = factory.getLogger(PhysicalTurnoutController.name);
		val String[] pins = pinout.getHeaderPins(expander);
		try {
			straightControl = GpioManager.getGpio(pins.get(0), Gpio.Direction.OUT);
			divergentControl = GpioManager.getGpio(pins.get(1), Gpio.Direction.OUT);

			straightState = GpioManager.getGpio(pins.get(2), Gpio.Direction.IN);
			divergentState = GpioManager.getGpio(pins.get(3), Gpio.Direction.IN);
		} catch(GpioNotConfiguratedException ex) {
			// TODO this exception should be handled correctly!
			logger.error("GPIO pin could not be set!", ex);
		}

		// there will be only one listener for both input, therefore we could handle the change
		// correctly
		straightState.addInputStateListener(this);
		divergentState.addInputStateListener(this);
	}
	
	/**
	 * Sets a turnout state change listener.
	 * 
	 * @param listener the listener to be set
	 */
	def setTurnoutStateChangedListener(ITurnoutStateChangedListener listener) {
		this.listener = listener;
	}

	/**
	 * @return the recent state (direction) of the turnout
	 */
	def getTurnoutState() {
		if((straightState.level == Level.HIGH) && (divergentState.level == Level.LOW)) {
			return TurnoutState.STRAIGHT;
		} else if((straightState.level == Level.LOW) && (divergentState.level == Level.HIGH)) {
			return TurnoutState.DIVERGENT;
		} else {
			return TurnoutState.ILLEGAL;
		}
	}

	/**
	 * Sets the turnout to the given direction (state).
	 * 
	 * @param state the state of the turnout to be set for
	 */
	def setTurnoutState(TurnoutState state) {
		try {
			switch state {
				case DIVERGENT: {
					divergentControl.impulse(TURNOUT_IMPULSE_WIDTH, false);
				}
				case STRAIGHT: {
					straightControl.impulse(TURNOUT_IMPULSE_WIDTH, false);
				}
				case ILLEGAL: {
					throw new RuntimeException("ILLEGAL state received, simply ignoring it")
				}
			}
		} catch(Exception ex) {
			// TODO this exception should be handled correctly!
			logger.debug("Exception during turnout switching!", ex);
		}
	}

	override levelStateChanged(Level newLevel) {
		logger.info('''level state changed! expander: «expander»''');
		listener?.onStateChanged(turnoutState);
	}

}
