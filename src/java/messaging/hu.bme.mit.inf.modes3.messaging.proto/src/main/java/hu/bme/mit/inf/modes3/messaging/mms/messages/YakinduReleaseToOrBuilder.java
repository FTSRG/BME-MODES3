// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: YakinduReleaseTo.proto

package hu.bme.mit.inf.modes3.messaging.mms.messages;

public interface YakinduReleaseToOrBuilder extends
    // @@protoc_insertion_point(interface_extends:YakinduReleaseTo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional uint32 targetID = 1;</code>
   */
  int getTargetID();

  /**
   * <code>optional .YakinduConnectionDirection direction = 2;</code>
   */
  int getDirectionValue();
  /**
   * <code>optional .YakinduConnectionDirection direction = 2;</code>
   */
  hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection getDirection();
}