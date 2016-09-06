package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import java.util.Map
import java.util.TreeMap
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Implements a runnable which frequently polls the sections status 
 * (ENABLED or DISABLED) and transfers this to the network so that 
 * everyone who is subscribed can receive it.
 * 
 * This class only transfers the information if the respective section's status
 * has changed (e.g. from ENABLED to DISABLED). Otherwise it does not send any
 * notification on the network.
 * 
 * @author benedekh
 */
class SectionStateChangeNotifier extends SectionStateNotifier {

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val Map<String, SegmentState> latestSectionStates

	new(ITrackElementStateSender _trackElementStateSender, ExpanderSectionController _sectionController) {
		super(_trackElementStateSender, _sectionController)

		latestSectionStates = new TreeMap
		for (sectionStr : sectionController.managedSections) {
			val sectionId = HexConversionUtil.fromString(sectionStr)
			val status = sectionController.getSectionStatus(sectionId)
			latestSectionStates.put(sectionStr, status)
		}
	}

	override run() {
		while (!Thread.interrupted) {
			for (sectionStr : sectionController.managedSections) {
				val sectionId = HexConversionUtil.fromString(sectionStr)
				val status = sectionController.getSectionStatus(sectionId)
				if (latestSectionStates.get(sectionStr) != status) {
					latestSectionStates.put(sectionStr, status)
					trackElementStateSender.sendSegmentState(sectionId, status)
				}
			}
			Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
		}
	}
}
