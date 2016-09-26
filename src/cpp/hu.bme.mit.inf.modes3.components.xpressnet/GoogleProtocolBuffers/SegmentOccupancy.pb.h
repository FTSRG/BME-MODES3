// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SegmentOccupancy.proto

#ifndef PROTOBUF_SegmentOccupancy_2eproto__INCLUDED
#define PROTOBUF_SegmentOccupancy_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3000000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3000000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>
#include <google/protobuf/extension_set.h>
#include <google/protobuf/unknown_field_set.h>
#include "Enums.pb.h"
// @@protoc_insertion_point(includes)

namespace modes3 {
namespace protobuf {

// Internal implementation detail -- do not call these.
void protobuf_AddDesc_SegmentOccupancy_2eproto();
void protobuf_AssignDesc_SegmentOccupancy_2eproto();
void protobuf_ShutdownFile_SegmentOccupancy_2eproto();

class SegmentOccupancy;

// ===================================================================

class SegmentOccupancy : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:modes3.protobuf.SegmentOccupancy) */ {
 public:
  SegmentOccupancy();
  virtual ~SegmentOccupancy();

  SegmentOccupancy(const SegmentOccupancy& from);

  inline SegmentOccupancy& operator=(const SegmentOccupancy& from) {
    CopyFrom(from);
    return *this;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const SegmentOccupancy& default_instance();

  void Swap(SegmentOccupancy* other);

  // implements Message ----------------------------------------------

  inline SegmentOccupancy* New() const { return New(NULL); }

  SegmentOccupancy* New(::google::protobuf::Arena* arena) const;
  void CopyFrom(const ::google::protobuf::Message& from);
  void MergeFrom(const ::google::protobuf::Message& from);
  void CopyFrom(const SegmentOccupancy& from);
  void MergeFrom(const SegmentOccupancy& from);
  void Clear();
  bool IsInitialized() const;

  int ByteSize() const;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input);
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* output) const;
  ::google::protobuf::uint8* SerializeWithCachedSizesToArray(::google::protobuf::uint8* output) const {
    return InternalSerializeWithCachedSizesToArray(false, output);
  }
  int GetCachedSize() const { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const;
  void InternalSwap(SegmentOccupancy* other);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return _internal_metadata_.arena();
  }
  inline void* MaybeArenaPtr() const {
    return _internal_metadata_.raw_arena_ptr();
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // optional uint32 segmentID = 1;
  void clear_segmentid();
  static const int kSegmentIDFieldNumber = 1;
  ::google::protobuf::uint32 segmentid() const;
  void set_segmentid(::google::protobuf::uint32 value);

  // optional .modes3.protobuf.SegmentOccupancyValue state = 2;
  void clear_state();
  static const int kStateFieldNumber = 2;
  ::modes3::protobuf::SegmentOccupancyValue state() const;
  void set_state(::modes3::protobuf::SegmentOccupancyValue value);

  // @@protoc_insertion_point(class_scope:modes3.protobuf.SegmentOccupancy)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  bool _is_default_instance_;
  ::google::protobuf::uint32 segmentid_;
  int state_;
  mutable int _cached_size_;
  friend void  protobuf_AddDesc_SegmentOccupancy_2eproto();
  friend void protobuf_AssignDesc_SegmentOccupancy_2eproto();
  friend void protobuf_ShutdownFile_SegmentOccupancy_2eproto();

  void InitAsDefaultInstance();
  static SegmentOccupancy* default_instance_;
};
// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
// SegmentOccupancy

// optional uint32 segmentID = 1;
inline void SegmentOccupancy::clear_segmentid() {
  segmentid_ = 0u;
}
inline ::google::protobuf::uint32 SegmentOccupancy::segmentid() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.SegmentOccupancy.segmentID)
  return segmentid_;
}
inline void SegmentOccupancy::set_segmentid(::google::protobuf::uint32 value) {
  
  segmentid_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.SegmentOccupancy.segmentID)
}

// optional .modes3.protobuf.SegmentOccupancyValue state = 2;
inline void SegmentOccupancy::clear_state() {
  state_ = 0;
}
inline ::modes3::protobuf::SegmentOccupancyValue SegmentOccupancy::state() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.SegmentOccupancy.state)
  return static_cast< ::modes3::protobuf::SegmentOccupancyValue >(state_);
}
inline void SegmentOccupancy::set_state(::modes3::protobuf::SegmentOccupancyValue value) {
  
  state_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.SegmentOccupancy.state)
}

#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)

}  // namespace protobuf
}  // namespace modes3

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_SegmentOccupancy_2eproto__INCLUDED
