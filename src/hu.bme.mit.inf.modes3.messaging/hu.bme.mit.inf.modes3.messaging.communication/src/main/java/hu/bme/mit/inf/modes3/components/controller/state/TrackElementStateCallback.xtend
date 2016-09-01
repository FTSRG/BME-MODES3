package hu.bme.mit.inf.modes3.components.controller.state

import hu.bme.mit.inf.modes3.components.controller.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentOccupancyListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ISegmentStateListener
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITurnoutStateListener
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

class TrackElementStateCallback {
	@Accessors(PROTECTED_GETTER, PUBLIC_SETTER) var ISegmentStateListener segmentStateListener
	@Accessors(PROTECTED_GETTER, PUBLIC_SETTER) var ITurnoutStateListener turnoutStateListener
	@Accessors(PROTECTED_GETTER, PUBLIC_SETTER) var ISegmentOccupancyListener segmentOccupancyListener
	var ProtobufMessageDispatcher dispatcher
	
	new(ProtobufMessageDispatcher dispatcher, ISegmentStateListener segmentStateListener, ITurnoutStateListener turnoutStateListener, ISegmentOccupancyListener segmentOccupancyListener) {
		this.segmentStateListener = segmentStateListener
		this.turnoutStateListener = turnoutStateListener
		this.segmentOccupancyListener = segmentOccupancyListener
		this.dispatcher = dispatcher
		
		val segmentStateClient = new SegmentStateClient(this)
		val turnoutStateClient = new TurnoutStateClient(this)
		val segmentOccupancyClient = new SegmentOccupancyClient(this)

		dispatcher.segmentStateHandler = segmentStateClient
		dispatcher.turnoutStateHandler = turnoutStateClient
		dispatcher.segmentOccupancyHandler = segmentOccupancyClient
	}
	
	def onSegmentState(int id, SegmentState state){
		segmentStateListener?.onSegmentState(id, state)
	}
	
	def onTurnoutState(int id, TurnoutState state){
		turnoutStateListener?.onTurnoutState(id, state)
	}
	
	def onSegmentOccupancy(int id, SegmentOccupancy state){
		segmentOccupancyListener?.onSegmentOccupancy(id, state)
	}
}
