package hu.bme.mit.inf.modes3.messaging.mms.handlers

import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegmentOrBuilder

interface TrainCurrentSegmentHandler {
	def void handleTrainCurrentSegment(TrainCurrentSegmentOrBuilder event);
}
