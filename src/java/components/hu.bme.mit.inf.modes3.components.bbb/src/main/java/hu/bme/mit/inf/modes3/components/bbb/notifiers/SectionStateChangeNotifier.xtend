package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import java.util.Map
import java.util.TreeMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory

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
package class SectionStateChangeNotifier extends SectionStateNotifier {

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val Map<Integer, SegmentState> latestSectionStates

	new(ITrackElementStateSender _trackElementStateSender, ExpanderSectionController _sectionController, ILoggerFactory factory) {
		super(_trackElementStateSender, _sectionController, factory)

		latestSectionStates = new TreeMap
		for (sectionId : sectionController.managedSections) {
			val status = sectionController.getSectionStatus(sectionId)
			latestSectionStates.put(sectionId, status)
		}
	}

	override run() {
		logger.info('''SectionStateChangeNotifier started''')

		while(!Thread.interrupted) {
			try {
				for (sectionId : sectionController.managedSections) {
					val status = sectionController.getSectionStatus(sectionId)
					if(latestSectionStates.get(sectionId) != status) {
						latestSectionStates.put(sectionId, status)
						trackElementStateSender.sendSegmentState(sectionId, status)

						logger.info('''Section «sectionId»'s status «status» is sent.''')
					}
				}
				Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
			} catch(InterruptedException ex) {
				logger.error(ex.message, ex)
				Thread.currentThread.interrupt
			}
		}
	}
}
