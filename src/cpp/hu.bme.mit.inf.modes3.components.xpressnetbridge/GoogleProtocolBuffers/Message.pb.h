// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

#ifndef PROTOBUF_Message_2eproto__INCLUDED
#define PROTOBUF_Message_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3004000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3004000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_table_driven.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/unknown_field_set.h>
#include "DccOperationsCommand.pb.h"
#include "DccOperationsState.pb.h"
#include "Enums.pb.h"
#include "SegmentCommand.pb.h"
#include "SegmentState.pb.h"
#include "TrainReferenceSpeed.pb.h"
#include "TrainReferenceSpeedCommand.pb.h"
#include "TurnoutCommand.pb.h"
#include "TurnoutState.pb.h"
#include "TurnoutReferenceState.pb.h"
#include "SegmentOccupancy.pb.h"
#include "SendAllStatus.pb.h"
#include "ComputerVisionObjectPositions.pb.h"
// @@protoc_insertion_point(includes)
namespace modes3 {
namespace protobuf {
class Message;
class MessageDefaultTypeInternal;
extern MessageDefaultTypeInternal _Message_default_instance_;
}  // namespace protobuf
}  // namespace modes3

namespace modes3 {
namespace protobuf {

namespace protobuf_Message_2eproto {
// Internal implementation detail -- do not call these.
struct TableStruct {
  static const ::google::protobuf::internal::ParseTableField entries[];
  static const ::google::protobuf::internal::AuxillaryParseTableField aux[];
  static const ::google::protobuf::internal::ParseTable schema[];
  static const ::google::protobuf::uint32 offsets[];
  static const ::google::protobuf::internal::FieldMetadata field_metadata[];
  static const ::google::protobuf::internal::SerializationTable serialization_table[];
  static void InitDefaultsImpl();
};
void AddDescriptors();
void InitDefaults();
}  // namespace protobuf_Message_2eproto

// ===================================================================

class Message : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:modes3.protobuf.Message) */ {
 public:
  Message();
  virtual ~Message();

  Message(const Message& from);

  inline Message& operator=(const Message& from) {
    CopyFrom(from);
    return *this;
  }
  #if LANG_CXX11
  Message(Message&& from) noexcept
    : Message() {
    *this = ::std::move(from);
  }

  inline Message& operator=(Message&& from) noexcept {
    if (GetArenaNoVirtual() == from.GetArenaNoVirtual()) {
      if (this != &from) InternalSwap(&from);
    } else {
      CopyFrom(from);
    }
    return *this;
  }
  #endif
  static const ::google::protobuf::Descriptor* descriptor();
  static const Message& default_instance();

  static inline const Message* internal_default_instance() {
    return reinterpret_cast<const Message*>(
               &_Message_default_instance_);
  }
  static PROTOBUF_CONSTEXPR int const kIndexInFileMessages =
    0;

  void Swap(Message* other);
  friend void swap(Message& a, Message& b) {
    a.Swap(&b);
  }

  // implements Message ----------------------------------------------

  inline Message* New() const PROTOBUF_FINAL { return New(NULL); }

  Message* New(::google::protobuf::Arena* arena) const PROTOBUF_FINAL;
  void CopyFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void MergeFrom(const ::google::protobuf::Message& from) PROTOBUF_FINAL;
  void CopyFrom(const Message& from);
  void MergeFrom(const Message& from);
  void Clear() PROTOBUF_FINAL;
  bool IsInitialized() const PROTOBUF_FINAL;

  size_t ByteSizeLong() const PROTOBUF_FINAL;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input) PROTOBUF_FINAL;
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const PROTOBUF_FINAL;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* target) const PROTOBUF_FINAL;
  int GetCachedSize() const PROTOBUF_FINAL { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const PROTOBUF_FINAL;
  void InternalSwap(Message* other);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return NULL;
  }
  inline void* MaybeArenaPtr() const {
    return NULL;
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const PROTOBUF_FINAL;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // .modes3.protobuf.SegmentCommand segmentCommand = 2;
  bool has_segmentcommand() const;
  void clear_segmentcommand();
  static const int kSegmentCommandFieldNumber = 2;
  const ::modes3::protobuf::SegmentCommand& segmentcommand() const;
  ::modes3::protobuf::SegmentCommand* mutable_segmentcommand();
  ::modes3::protobuf::SegmentCommand* release_segmentcommand();
  void set_allocated_segmentcommand(::modes3::protobuf::SegmentCommand* segmentcommand);

  // .modes3.protobuf.SegmentState segmentState = 3;
  bool has_segmentstate() const;
  void clear_segmentstate();
  static const int kSegmentStateFieldNumber = 3;
  const ::modes3::protobuf::SegmentState& segmentstate() const;
  ::modes3::protobuf::SegmentState* mutable_segmentstate();
  ::modes3::protobuf::SegmentState* release_segmentstate();
  void set_allocated_segmentstate(::modes3::protobuf::SegmentState* segmentstate);

  // .modes3.protobuf.TrainReferenceSpeed trainReferenceSpeed = 4;
  bool has_trainreferencespeed() const;
  void clear_trainreferencespeed();
  static const int kTrainReferenceSpeedFieldNumber = 4;
  const ::modes3::protobuf::TrainReferenceSpeed& trainreferencespeed() const;
  ::modes3::protobuf::TrainReferenceSpeed* mutable_trainreferencespeed();
  ::modes3::protobuf::TrainReferenceSpeed* release_trainreferencespeed();
  void set_allocated_trainreferencespeed(::modes3::protobuf::TrainReferenceSpeed* trainreferencespeed);

  // .modes3.protobuf.TrainReferenceSpeedCommand trainReferenceSpeedCommand = 5;
  bool has_trainreferencespeedcommand() const;
  void clear_trainreferencespeedcommand();
  static const int kTrainReferenceSpeedCommandFieldNumber = 5;
  const ::modes3::protobuf::TrainReferenceSpeedCommand& trainreferencespeedcommand() const;
  ::modes3::protobuf::TrainReferenceSpeedCommand* mutable_trainreferencespeedcommand();
  ::modes3::protobuf::TrainReferenceSpeedCommand* release_trainreferencespeedcommand();
  void set_allocated_trainreferencespeedcommand(::modes3::protobuf::TrainReferenceSpeedCommand* trainreferencespeedcommand);

  // .modes3.protobuf.TurnoutCommand turnoutCommand = 6;
  bool has_turnoutcommand() const;
  void clear_turnoutcommand();
  static const int kTurnoutCommandFieldNumber = 6;
  const ::modes3::protobuf::TurnoutCommand& turnoutcommand() const;
  ::modes3::protobuf::TurnoutCommand* mutable_turnoutcommand();
  ::modes3::protobuf::TurnoutCommand* release_turnoutcommand();
  void set_allocated_turnoutcommand(::modes3::protobuf::TurnoutCommand* turnoutcommand);

  // .modes3.protobuf.TurnoutState turnoutState = 7;
  bool has_turnoutstate() const;
  void clear_turnoutstate();
  static const int kTurnoutStateFieldNumber = 7;
  const ::modes3::protobuf::TurnoutState& turnoutstate() const;
  ::modes3::protobuf::TurnoutState* mutable_turnoutstate();
  ::modes3::protobuf::TurnoutState* release_turnoutstate();
  void set_allocated_turnoutstate(::modes3::protobuf::TurnoutState* turnoutstate);

  // .modes3.protobuf.SegmentOccupancy segmentOccupancy = 8;
  bool has_segmentoccupancy() const;
  void clear_segmentoccupancy();
  static const int kSegmentOccupancyFieldNumber = 8;
  const ::modes3::protobuf::SegmentOccupancy& segmentoccupancy() const;
  ::modes3::protobuf::SegmentOccupancy* mutable_segmentoccupancy();
  ::modes3::protobuf::SegmentOccupancy* release_segmentoccupancy();
  void set_allocated_segmentoccupancy(::modes3::protobuf::SegmentOccupancy* segmentoccupancy);

  // .modes3.protobuf.TurnoutReferenceState turnoutReferenceState = 9;
  bool has_turnoutreferencestate() const;
  void clear_turnoutreferencestate();
  static const int kTurnoutReferenceStateFieldNumber = 9;
  const ::modes3::protobuf::TurnoutReferenceState& turnoutreferencestate() const;
  ::modes3::protobuf::TurnoutReferenceState* mutable_turnoutreferencestate();
  ::modes3::protobuf::TurnoutReferenceState* release_turnoutreferencestate();
  void set_allocated_turnoutreferencestate(::modes3::protobuf::TurnoutReferenceState* turnoutreferencestate);

  // .modes3.protobuf.DccOperationsCommand dccOperationsCommand = 10;
  bool has_dccoperationscommand() const;
  void clear_dccoperationscommand();
  static const int kDccOperationsCommandFieldNumber = 10;
  const ::modes3::protobuf::DccOperationsCommand& dccoperationscommand() const;
  ::modes3::protobuf::DccOperationsCommand* mutable_dccoperationscommand();
  ::modes3::protobuf::DccOperationsCommand* release_dccoperationscommand();
  void set_allocated_dccoperationscommand(::modes3::protobuf::DccOperationsCommand* dccoperationscommand);

  // .modes3.protobuf.DccOperationsState dccOperationsState = 11;
  bool has_dccoperationsstate() const;
  void clear_dccoperationsstate();
  static const int kDccOperationsStateFieldNumber = 11;
  const ::modes3::protobuf::DccOperationsState& dccoperationsstate() const;
  ::modes3::protobuf::DccOperationsState* mutable_dccoperationsstate();
  ::modes3::protobuf::DccOperationsState* release_dccoperationsstate();
  void set_allocated_dccoperationsstate(::modes3::protobuf::DccOperationsState* dccoperationsstate);

  // .modes3.protobuf.SendAllStatus allStatus = 12;
  bool has_allstatus() const;
  void clear_allstatus();
  static const int kAllStatusFieldNumber = 12;
  const ::modes3::protobuf::SendAllStatus& allstatus() const;
  ::modes3::protobuf::SendAllStatus* mutable_allstatus();
  ::modes3::protobuf::SendAllStatus* release_allstatus();
  void set_allocated_allstatus(::modes3::protobuf::SendAllStatus* allstatus);

  // .modes3.protobuf.ComputerVisionObjectPositions computerVisionObjectPositions = 13;
  bool has_computervisionobjectpositions() const;
  void clear_computervisionobjectpositions();
  static const int kComputerVisionObjectPositionsFieldNumber = 13;
  const ::modes3::protobuf::ComputerVisionObjectPositions& computervisionobjectpositions() const;
  ::modes3::protobuf::ComputerVisionObjectPositions* mutable_computervisionobjectpositions();
  ::modes3::protobuf::ComputerVisionObjectPositions* release_computervisionobjectpositions();
  void set_allocated_computervisionobjectpositions(::modes3::protobuf::ComputerVisionObjectPositions* computervisionobjectpositions);

  // .modes3.protobuf.MessageType type = 1;
  void clear_type();
  static const int kTypeFieldNumber = 1;
  ::modes3::protobuf::MessageType type() const;
  void set_type(::modes3::protobuf::MessageType value);

  // @@protoc_insertion_point(class_scope:modes3.protobuf.Message)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::modes3::protobuf::SegmentCommand* segmentcommand_;
  ::modes3::protobuf::SegmentState* segmentstate_;
  ::modes3::protobuf::TrainReferenceSpeed* trainreferencespeed_;
  ::modes3::protobuf::TrainReferenceSpeedCommand* trainreferencespeedcommand_;
  ::modes3::protobuf::TurnoutCommand* turnoutcommand_;
  ::modes3::protobuf::TurnoutState* turnoutstate_;
  ::modes3::protobuf::SegmentOccupancy* segmentoccupancy_;
  ::modes3::protobuf::TurnoutReferenceState* turnoutreferencestate_;
  ::modes3::protobuf::DccOperationsCommand* dccoperationscommand_;
  ::modes3::protobuf::DccOperationsState* dccoperationsstate_;
  ::modes3::protobuf::SendAllStatus* allstatus_;
  ::modes3::protobuf::ComputerVisionObjectPositions* computervisionobjectpositions_;
  int type_;
  mutable int _cached_size_;
  friend struct protobuf_Message_2eproto::TableStruct;
};
// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
#ifdef __GNUC__
  #pragma GCC diagnostic push
  #pragma GCC diagnostic ignored "-Wstrict-aliasing"
#endif  // __GNUC__
// Message

// .modes3.protobuf.MessageType type = 1;
inline void Message::clear_type() {
  type_ = 0;
}
inline ::modes3::protobuf::MessageType Message::type() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.type)
  return static_cast< ::modes3::protobuf::MessageType >(type_);
}
inline void Message::set_type(::modes3::protobuf::MessageType value) {
  
  type_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.Message.type)
}

// .modes3.protobuf.SegmentCommand segmentCommand = 2;
inline bool Message::has_segmentcommand() const {
  return this != internal_default_instance() && segmentcommand_ != NULL;
}
inline void Message::clear_segmentcommand() {
  if (GetArenaNoVirtual() == NULL && segmentcommand_ != NULL) delete segmentcommand_;
  segmentcommand_ = NULL;
}
inline const ::modes3::protobuf::SegmentCommand& Message::segmentcommand() const {
  const ::modes3::protobuf::SegmentCommand* p = segmentcommand_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.segmentCommand)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::SegmentCommand*>(
      &::modes3::protobuf::_SegmentCommand_default_instance_);
}
inline ::modes3::protobuf::SegmentCommand* Message::mutable_segmentcommand() {
  
  if (segmentcommand_ == NULL) {
    segmentcommand_ = new ::modes3::protobuf::SegmentCommand;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.segmentCommand)
  return segmentcommand_;
}
inline ::modes3::protobuf::SegmentCommand* Message::release_segmentcommand() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.segmentCommand)
  
  ::modes3::protobuf::SegmentCommand* temp = segmentcommand_;
  segmentcommand_ = NULL;
  return temp;
}
inline void Message::set_allocated_segmentcommand(::modes3::protobuf::SegmentCommand* segmentcommand) {
  delete segmentcommand_;
  segmentcommand_ = segmentcommand;
  if (segmentcommand) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.segmentCommand)
}

// .modes3.protobuf.SegmentState segmentState = 3;
inline bool Message::has_segmentstate() const {
  return this != internal_default_instance() && segmentstate_ != NULL;
}
inline void Message::clear_segmentstate() {
  if (GetArenaNoVirtual() == NULL && segmentstate_ != NULL) delete segmentstate_;
  segmentstate_ = NULL;
}
inline const ::modes3::protobuf::SegmentState& Message::segmentstate() const {
  const ::modes3::protobuf::SegmentState* p = segmentstate_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.segmentState)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::SegmentState*>(
      &::modes3::protobuf::_SegmentState_default_instance_);
}
inline ::modes3::protobuf::SegmentState* Message::mutable_segmentstate() {
  
  if (segmentstate_ == NULL) {
    segmentstate_ = new ::modes3::protobuf::SegmentState;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.segmentState)
  return segmentstate_;
}
inline ::modes3::protobuf::SegmentState* Message::release_segmentstate() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.segmentState)
  
  ::modes3::protobuf::SegmentState* temp = segmentstate_;
  segmentstate_ = NULL;
  return temp;
}
inline void Message::set_allocated_segmentstate(::modes3::protobuf::SegmentState* segmentstate) {
  delete segmentstate_;
  segmentstate_ = segmentstate;
  if (segmentstate) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.segmentState)
}

// .modes3.protobuf.TrainReferenceSpeed trainReferenceSpeed = 4;
inline bool Message::has_trainreferencespeed() const {
  return this != internal_default_instance() && trainreferencespeed_ != NULL;
}
inline void Message::clear_trainreferencespeed() {
  if (GetArenaNoVirtual() == NULL && trainreferencespeed_ != NULL) delete trainreferencespeed_;
  trainreferencespeed_ = NULL;
}
inline const ::modes3::protobuf::TrainReferenceSpeed& Message::trainreferencespeed() const {
  const ::modes3::protobuf::TrainReferenceSpeed* p = trainreferencespeed_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.trainReferenceSpeed)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::TrainReferenceSpeed*>(
      &::modes3::protobuf::_TrainReferenceSpeed_default_instance_);
}
inline ::modes3::protobuf::TrainReferenceSpeed* Message::mutable_trainreferencespeed() {
  
  if (trainreferencespeed_ == NULL) {
    trainreferencespeed_ = new ::modes3::protobuf::TrainReferenceSpeed;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.trainReferenceSpeed)
  return trainreferencespeed_;
}
inline ::modes3::protobuf::TrainReferenceSpeed* Message::release_trainreferencespeed() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.trainReferenceSpeed)
  
  ::modes3::protobuf::TrainReferenceSpeed* temp = trainreferencespeed_;
  trainreferencespeed_ = NULL;
  return temp;
}
inline void Message::set_allocated_trainreferencespeed(::modes3::protobuf::TrainReferenceSpeed* trainreferencespeed) {
  delete trainreferencespeed_;
  trainreferencespeed_ = trainreferencespeed;
  if (trainreferencespeed) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.trainReferenceSpeed)
}

// .modes3.protobuf.TrainReferenceSpeedCommand trainReferenceSpeedCommand = 5;
inline bool Message::has_trainreferencespeedcommand() const {
  return this != internal_default_instance() && trainreferencespeedcommand_ != NULL;
}
inline void Message::clear_trainreferencespeedcommand() {
  if (GetArenaNoVirtual() == NULL && trainreferencespeedcommand_ != NULL) delete trainreferencespeedcommand_;
  trainreferencespeedcommand_ = NULL;
}
inline const ::modes3::protobuf::TrainReferenceSpeedCommand& Message::trainreferencespeedcommand() const {
  const ::modes3::protobuf::TrainReferenceSpeedCommand* p = trainreferencespeedcommand_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.trainReferenceSpeedCommand)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::TrainReferenceSpeedCommand*>(
      &::modes3::protobuf::_TrainReferenceSpeedCommand_default_instance_);
}
inline ::modes3::protobuf::TrainReferenceSpeedCommand* Message::mutable_trainreferencespeedcommand() {
  
  if (trainreferencespeedcommand_ == NULL) {
    trainreferencespeedcommand_ = new ::modes3::protobuf::TrainReferenceSpeedCommand;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.trainReferenceSpeedCommand)
  return trainreferencespeedcommand_;
}
inline ::modes3::protobuf::TrainReferenceSpeedCommand* Message::release_trainreferencespeedcommand() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.trainReferenceSpeedCommand)
  
  ::modes3::protobuf::TrainReferenceSpeedCommand* temp = trainreferencespeedcommand_;
  trainreferencespeedcommand_ = NULL;
  return temp;
}
inline void Message::set_allocated_trainreferencespeedcommand(::modes3::protobuf::TrainReferenceSpeedCommand* trainreferencespeedcommand) {
  delete trainreferencespeedcommand_;
  trainreferencespeedcommand_ = trainreferencespeedcommand;
  if (trainreferencespeedcommand) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.trainReferenceSpeedCommand)
}

// .modes3.protobuf.TurnoutCommand turnoutCommand = 6;
inline bool Message::has_turnoutcommand() const {
  return this != internal_default_instance() && turnoutcommand_ != NULL;
}
inline void Message::clear_turnoutcommand() {
  if (GetArenaNoVirtual() == NULL && turnoutcommand_ != NULL) delete turnoutcommand_;
  turnoutcommand_ = NULL;
}
inline const ::modes3::protobuf::TurnoutCommand& Message::turnoutcommand() const {
  const ::modes3::protobuf::TurnoutCommand* p = turnoutcommand_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.turnoutCommand)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::TurnoutCommand*>(
      &::modes3::protobuf::_TurnoutCommand_default_instance_);
}
inline ::modes3::protobuf::TurnoutCommand* Message::mutable_turnoutcommand() {
  
  if (turnoutcommand_ == NULL) {
    turnoutcommand_ = new ::modes3::protobuf::TurnoutCommand;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.turnoutCommand)
  return turnoutcommand_;
}
inline ::modes3::protobuf::TurnoutCommand* Message::release_turnoutcommand() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.turnoutCommand)
  
  ::modes3::protobuf::TurnoutCommand* temp = turnoutcommand_;
  turnoutcommand_ = NULL;
  return temp;
}
inline void Message::set_allocated_turnoutcommand(::modes3::protobuf::TurnoutCommand* turnoutcommand) {
  delete turnoutcommand_;
  turnoutcommand_ = turnoutcommand;
  if (turnoutcommand) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.turnoutCommand)
}

// .modes3.protobuf.TurnoutState turnoutState = 7;
inline bool Message::has_turnoutstate() const {
  return this != internal_default_instance() && turnoutstate_ != NULL;
}
inline void Message::clear_turnoutstate() {
  if (GetArenaNoVirtual() == NULL && turnoutstate_ != NULL) delete turnoutstate_;
  turnoutstate_ = NULL;
}
inline const ::modes3::protobuf::TurnoutState& Message::turnoutstate() const {
  const ::modes3::protobuf::TurnoutState* p = turnoutstate_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.turnoutState)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::TurnoutState*>(
      &::modes3::protobuf::_TurnoutState_default_instance_);
}
inline ::modes3::protobuf::TurnoutState* Message::mutable_turnoutstate() {
  
  if (turnoutstate_ == NULL) {
    turnoutstate_ = new ::modes3::protobuf::TurnoutState;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.turnoutState)
  return turnoutstate_;
}
inline ::modes3::protobuf::TurnoutState* Message::release_turnoutstate() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.turnoutState)
  
  ::modes3::protobuf::TurnoutState* temp = turnoutstate_;
  turnoutstate_ = NULL;
  return temp;
}
inline void Message::set_allocated_turnoutstate(::modes3::protobuf::TurnoutState* turnoutstate) {
  delete turnoutstate_;
  turnoutstate_ = turnoutstate;
  if (turnoutstate) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.turnoutState)
}

// .modes3.protobuf.SegmentOccupancy segmentOccupancy = 8;
inline bool Message::has_segmentoccupancy() const {
  return this != internal_default_instance() && segmentoccupancy_ != NULL;
}
inline void Message::clear_segmentoccupancy() {
  if (GetArenaNoVirtual() == NULL && segmentoccupancy_ != NULL) delete segmentoccupancy_;
  segmentoccupancy_ = NULL;
}
inline const ::modes3::protobuf::SegmentOccupancy& Message::segmentoccupancy() const {
  const ::modes3::protobuf::SegmentOccupancy* p = segmentoccupancy_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.segmentOccupancy)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::SegmentOccupancy*>(
      &::modes3::protobuf::_SegmentOccupancy_default_instance_);
}
inline ::modes3::protobuf::SegmentOccupancy* Message::mutable_segmentoccupancy() {
  
  if (segmentoccupancy_ == NULL) {
    segmentoccupancy_ = new ::modes3::protobuf::SegmentOccupancy;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.segmentOccupancy)
  return segmentoccupancy_;
}
inline ::modes3::protobuf::SegmentOccupancy* Message::release_segmentoccupancy() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.segmentOccupancy)
  
  ::modes3::protobuf::SegmentOccupancy* temp = segmentoccupancy_;
  segmentoccupancy_ = NULL;
  return temp;
}
inline void Message::set_allocated_segmentoccupancy(::modes3::protobuf::SegmentOccupancy* segmentoccupancy) {
  delete segmentoccupancy_;
  segmentoccupancy_ = segmentoccupancy;
  if (segmentoccupancy) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.segmentOccupancy)
}

// .modes3.protobuf.TurnoutReferenceState turnoutReferenceState = 9;
inline bool Message::has_turnoutreferencestate() const {
  return this != internal_default_instance() && turnoutreferencestate_ != NULL;
}
inline void Message::clear_turnoutreferencestate() {
  if (GetArenaNoVirtual() == NULL && turnoutreferencestate_ != NULL) delete turnoutreferencestate_;
  turnoutreferencestate_ = NULL;
}
inline const ::modes3::protobuf::TurnoutReferenceState& Message::turnoutreferencestate() const {
  const ::modes3::protobuf::TurnoutReferenceState* p = turnoutreferencestate_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.turnoutReferenceState)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::TurnoutReferenceState*>(
      &::modes3::protobuf::_TurnoutReferenceState_default_instance_);
}
inline ::modes3::protobuf::TurnoutReferenceState* Message::mutable_turnoutreferencestate() {
  
  if (turnoutreferencestate_ == NULL) {
    turnoutreferencestate_ = new ::modes3::protobuf::TurnoutReferenceState;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.turnoutReferenceState)
  return turnoutreferencestate_;
}
inline ::modes3::protobuf::TurnoutReferenceState* Message::release_turnoutreferencestate() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.turnoutReferenceState)
  
  ::modes3::protobuf::TurnoutReferenceState* temp = turnoutreferencestate_;
  turnoutreferencestate_ = NULL;
  return temp;
}
inline void Message::set_allocated_turnoutreferencestate(::modes3::protobuf::TurnoutReferenceState* turnoutreferencestate) {
  delete turnoutreferencestate_;
  turnoutreferencestate_ = turnoutreferencestate;
  if (turnoutreferencestate) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.turnoutReferenceState)
}

// .modes3.protobuf.DccOperationsCommand dccOperationsCommand = 10;
inline bool Message::has_dccoperationscommand() const {
  return this != internal_default_instance() && dccoperationscommand_ != NULL;
}
inline void Message::clear_dccoperationscommand() {
  if (GetArenaNoVirtual() == NULL && dccoperationscommand_ != NULL) delete dccoperationscommand_;
  dccoperationscommand_ = NULL;
}
inline const ::modes3::protobuf::DccOperationsCommand& Message::dccoperationscommand() const {
  const ::modes3::protobuf::DccOperationsCommand* p = dccoperationscommand_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.dccOperationsCommand)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::DccOperationsCommand*>(
      &::modes3::protobuf::_DccOperationsCommand_default_instance_);
}
inline ::modes3::protobuf::DccOperationsCommand* Message::mutable_dccoperationscommand() {
  
  if (dccoperationscommand_ == NULL) {
    dccoperationscommand_ = new ::modes3::protobuf::DccOperationsCommand;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.dccOperationsCommand)
  return dccoperationscommand_;
}
inline ::modes3::protobuf::DccOperationsCommand* Message::release_dccoperationscommand() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.dccOperationsCommand)
  
  ::modes3::protobuf::DccOperationsCommand* temp = dccoperationscommand_;
  dccoperationscommand_ = NULL;
  return temp;
}
inline void Message::set_allocated_dccoperationscommand(::modes3::protobuf::DccOperationsCommand* dccoperationscommand) {
  delete dccoperationscommand_;
  dccoperationscommand_ = dccoperationscommand;
  if (dccoperationscommand) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.dccOperationsCommand)
}

// .modes3.protobuf.DccOperationsState dccOperationsState = 11;
inline bool Message::has_dccoperationsstate() const {
  return this != internal_default_instance() && dccoperationsstate_ != NULL;
}
inline void Message::clear_dccoperationsstate() {
  if (GetArenaNoVirtual() == NULL && dccoperationsstate_ != NULL) delete dccoperationsstate_;
  dccoperationsstate_ = NULL;
}
inline const ::modes3::protobuf::DccOperationsState& Message::dccoperationsstate() const {
  const ::modes3::protobuf::DccOperationsState* p = dccoperationsstate_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.dccOperationsState)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::DccOperationsState*>(
      &::modes3::protobuf::_DccOperationsState_default_instance_);
}
inline ::modes3::protobuf::DccOperationsState* Message::mutable_dccoperationsstate() {
  
  if (dccoperationsstate_ == NULL) {
    dccoperationsstate_ = new ::modes3::protobuf::DccOperationsState;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.dccOperationsState)
  return dccoperationsstate_;
}
inline ::modes3::protobuf::DccOperationsState* Message::release_dccoperationsstate() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.dccOperationsState)
  
  ::modes3::protobuf::DccOperationsState* temp = dccoperationsstate_;
  dccoperationsstate_ = NULL;
  return temp;
}
inline void Message::set_allocated_dccoperationsstate(::modes3::protobuf::DccOperationsState* dccoperationsstate) {
  delete dccoperationsstate_;
  dccoperationsstate_ = dccoperationsstate;
  if (dccoperationsstate) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.dccOperationsState)
}

// .modes3.protobuf.SendAllStatus allStatus = 12;
inline bool Message::has_allstatus() const {
  return this != internal_default_instance() && allstatus_ != NULL;
}
inline void Message::clear_allstatus() {
  if (GetArenaNoVirtual() == NULL && allstatus_ != NULL) delete allstatus_;
  allstatus_ = NULL;
}
inline const ::modes3::protobuf::SendAllStatus& Message::allstatus() const {
  const ::modes3::protobuf::SendAllStatus* p = allstatus_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.allStatus)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::SendAllStatus*>(
      &::modes3::protobuf::_SendAllStatus_default_instance_);
}
inline ::modes3::protobuf::SendAllStatus* Message::mutable_allstatus() {
  
  if (allstatus_ == NULL) {
    allstatus_ = new ::modes3::protobuf::SendAllStatus;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.allStatus)
  return allstatus_;
}
inline ::modes3::protobuf::SendAllStatus* Message::release_allstatus() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.allStatus)
  
  ::modes3::protobuf::SendAllStatus* temp = allstatus_;
  allstatus_ = NULL;
  return temp;
}
inline void Message::set_allocated_allstatus(::modes3::protobuf::SendAllStatus* allstatus) {
  delete allstatus_;
  allstatus_ = allstatus;
  if (allstatus) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.allStatus)
}

// .modes3.protobuf.ComputerVisionObjectPositions computerVisionObjectPositions = 13;
inline bool Message::has_computervisionobjectpositions() const {
  return this != internal_default_instance() && computervisionobjectpositions_ != NULL;
}
inline void Message::clear_computervisionobjectpositions() {
  if (GetArenaNoVirtual() == NULL && computervisionobjectpositions_ != NULL) delete computervisionobjectpositions_;
  computervisionobjectpositions_ = NULL;
}
inline const ::modes3::protobuf::ComputerVisionObjectPositions& Message::computervisionobjectpositions() const {
  const ::modes3::protobuf::ComputerVisionObjectPositions* p = computervisionobjectpositions_;
  // @@protoc_insertion_point(field_get:modes3.protobuf.Message.computerVisionObjectPositions)
  return p != NULL ? *p : *reinterpret_cast<const ::modes3::protobuf::ComputerVisionObjectPositions*>(
      &::modes3::protobuf::_ComputerVisionObjectPositions_default_instance_);
}
inline ::modes3::protobuf::ComputerVisionObjectPositions* Message::mutable_computervisionobjectpositions() {
  
  if (computervisionobjectpositions_ == NULL) {
    computervisionobjectpositions_ = new ::modes3::protobuf::ComputerVisionObjectPositions;
  }
  // @@protoc_insertion_point(field_mutable:modes3.protobuf.Message.computerVisionObjectPositions)
  return computervisionobjectpositions_;
}
inline ::modes3::protobuf::ComputerVisionObjectPositions* Message::release_computervisionobjectpositions() {
  // @@protoc_insertion_point(field_release:modes3.protobuf.Message.computerVisionObjectPositions)
  
  ::modes3::protobuf::ComputerVisionObjectPositions* temp = computervisionobjectpositions_;
  computervisionobjectpositions_ = NULL;
  return temp;
}
inline void Message::set_allocated_computervisionobjectpositions(::modes3::protobuf::ComputerVisionObjectPositions* computervisionobjectpositions) {
  delete computervisionobjectpositions_;
  computervisionobjectpositions_ = computervisionobjectpositions;
  if (computervisionobjectpositions) {
    
  } else {
    
  }
  // @@protoc_insertion_point(field_set_allocated:modes3.protobuf.Message.computerVisionObjectPositions)
}

#ifdef __GNUC__
  #pragma GCC diagnostic pop
#endif  // __GNUC__
#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)


}  // namespace protobuf
}  // namespace modes3

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_Message_2eproto__INCLUDED