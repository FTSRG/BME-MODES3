package hu.bme.mit.inf.modes3.bbb.strategy;

import hu.bme.mit.inf.modes3.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.components.bbb.conf.ExpanderControllerConfiguration
import hu.bme.mit.inf.modes3.components.bbb.conf.IControllerConfiguration
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import io.silverspoon.bulldog.core.Signal
import io.silverspoon.bulldog.core.gpio.DigitalInput
import java.util.HashMap
import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * The turnout controller part of the embedded controller. Through it the
 * referred turnout can be managed.
 * 
 * @author hegyibalint, benedekh
 */
class ExpanderTurnoutController extends AbstractControllerStrategy implements IControllerConfiguration {

	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) val Logger logger = LoggerFactory.getLogger(ExpanderTurnoutController)

	/**
	 * The turnout direction (status) updater thread, that always refreshes the
	 * turnout's status.
	 */
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) var Thread turnoutDirectionUpdater

	// the actual embedded controller which manages the turnout
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) var ExpanderControllerConfiguration controllerConf

	// the latest turnout statuses (straight / divergent), based on turnout ID
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) var Map<String, TurnoutState> latestTurnoutStatus

	// the former (not the latest) turnout statuses (straight / divergent), based on turnout ID
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) var Map<String, TurnoutState> formerTurnoutStatus

	new() {
		try {
			controllerConf = new ExpanderControllerConfiguration
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}

		latestTurnoutStatus = new ConcurrentHashMap
		formerTurnoutStatus = new ConcurrentHashMap

		for (String to : controllerConf.getAllTurnout) {
			val defaultDirection = TurnoutState.STRAIGHT
			latestTurnoutStatus.put(to, defaultDirection)
			formerTurnoutStatus.put(to, defaultDirection)
		}

		// turnout direction updater
		turnoutDirectionUpdater = new Thread(new Runnable() {
			override run() {
				updateTurnoutDirection
			}
		})

		turnoutDirectionUpdater.start
	}

	override controllerManagesSection(int sectionId) {
		throw new UnsupportedOperationException("ExpanderTurnoutController does not support section operations")
	}

	override protected onGetSectionStatus(int sectionId) {
		throw new UnsupportedOperationException("ExpanderTurnoutController does not support section operations")
	}

	override protected onEnableSection(int sectionId) {
		throw new UnsupportedOperationException("ExpanderTurnoutController does not support section operations")
	}

	override protected onDisableSection(int sectionId) {
		throw new UnsupportedOperationException("ExpanderTurnoutController does not support section operations")
	}

	override protected onGetTurnoutStatus(int turnoutId) {
		latestTurnoutStatus.get(HexConversionUtil.fromNumber(turnoutId))
	}

	override controllerManagesTurnout(int turnoutId) {
		controllerConf.controllerManagesTurnout(turnoutId)
	}

	override protected onSetTurnoutStraight(int turnoutId) {
		// TODO implement
	}

	override protected onSetTurnoutDivergent(int turnoutId) {
		// TODO implement
	}

	/**
	 * @return the most recent turnout status information
	 */
	def getTurnoutsWithStatus() {
		latestTurnoutStatus.entrySet
	}

	/**
	 * Automatically refreshes the managed turnouts statuses
	 * (latestTurnoutStatus), if they have been changed since the last check
	 * (formerTurnoutStatus).
	 */
	private def updateTurnoutDirection() {
		val ioMap = new HashMap<String, DigitalInput>(4)

		for (String to : controllerConf.getAllTurnout) {
			val pins = controllerConf.getTurnoutExpander(to)
			ioMap.put(pins.get(0), board.getPin(pins.get(0)).^as(DigitalInput))
			ioMap.put(pins.get(1), board.getPin(pins.get(1)).^as(DigitalInput))
		}

		while (!Thread.interrupted) {
			for (String to : controllerConf.getAllTurnout) {
				val pins = controllerConf.getTurnoutExpander(to)

				if (ioMap.get(pins.get(0)).read() == Signal.High) {
					latestTurnoutStatus.put(to, TurnoutState.STRAIGHT)
				}
				if (ioMap.get(pins.get(1)).read() == Signal.High) {
					latestTurnoutStatus.put(to, TurnoutState.DIVERGENT)
				}

				val latest = latestTurnoutStatus.get(to)
				val former = formerTurnoutStatus.get(to)

				if (latest != former) {
					formerTurnoutStatus.put(to, latest)
				}
			}

			try {
				Thread.sleep(25)
			} catch (InterruptedException e) {
				logger.error(e.message, e)
				Thread.currentThread().interrupt
			}
		}
	}

}
