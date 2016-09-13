package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent

class SampleComponent extends AbstractRailRoadCommunicationComponent {

	val knownSegments = 1 ..< 10

	new(CommunicationStack communicationStack) {
		super(communicationStack)
	}

	def turnOffAll() {
		for (i : knownSegments) {
			locator.trackElementCommander.sendSegmentCommand(i, SegmentState.DISABLED)
		}
	}

	def getStateOfAll() {
		for (i : knownSegments) {
			processState(locator.trackElementStateRegistry.getSegmentState(i), i)
		}
	}

	def void processState(SegmentState state, int id) {
		println(
			'''Segment #«id» is «switch(state){case ENABLED: 'Enabled' case DISABLED: "Disabled"}»'''
		)
	}
	
	
	//The 'main' method of the sample component
	override run() {
		turnOffAll
		
	}

}
