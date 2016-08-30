package hu.bme.mit.inf.modes3.components.bbb.conf;

import hu.bme.mit.inf.modes3.bbb.prototypes.Pinout
import hu.bme.mit.inf.modes3.bbb.prototypes.Setting
import hu.bme.mit.inf.modes3.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.components.bbb.conf.IControllerConfiguration
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * API for the embedded controller.
 * 
 * @author hegyibalint
 */
class ExpanderControllerConfiguration implements IControllerConfiguration {

	// the pinout header configuration
	@Accessors(PACKAGE_GETTER, PACKAGE_SETTER) var Pinout pinout

	// contains the managed turnouts and sections ID
	@Accessors(PACKAGE_GETTER, PACKAGE_SETTER) var Setting setting

	/**
	 * Creates a new pinout and setting configuration based on the TURNOUT_ID
	 * environmental variable.
	 * 
	 * @throws Exception if TURNOUT_ID is not a valid environmental variable
	 */
	new() {
		val env = System.getenv();
		if (!env.containsKey("TURNOUT_ID")) {
			throw new RuntimeException("There is no TURNOUT_ID environmental variable defined");
		}
		val controllerID = HexConversionUtil.fromString(env.get("TURNOUT_ID"));

		pinout = Pinout.loadPinoutConfig();
		setting = Setting.loadPinoutConfig(controllerID);
	}

	override controllerManagesTurnout(int turnoutId) {
		setting.containsTurnout(turnoutId)
	}

	override controllerManagesSection(int sectionId) {
		setting.containsSection(sectionId)
	}

	/**
	 * @return the managed turnouts ID as String
	 */
	def getAllTurnout() {
		setting.turnouts.keySet
	}

	/**
	 * @return the managed sections ID as String
	 */
	def getAllSection() {
		setting.sections.keySet
	}

	/**
	 * 
	 * @param sectionId
	 * @return 
	 */
	def getSectionExpander(int sectionId) {
		val expander = setting.sections.get(HexConversionUtil.fromNumber(sectionId))
		pinout.headers.get(String.valueOf(expander))
	}

	/**
	 * 
	 * @param turnoutId
	 * @return 
	 */
	def getTurnoutExpander(String turnoutId) {
		val expander = setting.turnouts.get(turnoutId)
		pinout.headers.get(String.valueOf(expander))
	}

}
