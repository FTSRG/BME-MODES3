package hu.bme.mit.inf.modes3.components.controller.state.interfaces

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancyValue

interface ISegmentOccupancyChangeListener {
		def void onSegmentOccupancyChange(int id, SegmentOccupancyValue oldValue, SegmentOccupancyValue newValue);
}