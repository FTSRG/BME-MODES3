package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.messages.yakindu.YakinduProtocolMessage
import java.util.Set

import static extension hu.bme.mit.inf.modes3.utils.common.extensions.SetExtensions.asStringSet

/**
 * A topic factory for the Yakindu messages.
 * 
 * @author benedekh
 */
abstract class YakinduTopicFactory extends TopicFactory {

	private new() {
	}

	/**
	 * @return Yakindu topics with every possible substitution of {id} parameter in the topic name as a segment ID
	 */
	def static createEveryYakinduTopic() {
		createYakinduTopics(TopicFactory::SEGMENT_IDS)
	}

	/**
	 * @param segmentIDs the ID of the segments to be substituted in the topic names
	 * @return Yakindu topics for the referred segmentIDs
	 */
	def static createYakinduTopics(Set<Integer> segmentIDs) {
		TopicFactory::createTopicsWithSubstitutedParameters(YakinduProtocolMessage, segmentIDs.asStringSet)
	}
}
