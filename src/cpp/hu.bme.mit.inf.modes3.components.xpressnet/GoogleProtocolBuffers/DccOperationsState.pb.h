// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DccOperationsState.proto

#ifndef PROTOBUF_DccOperationsState_2eproto__INCLUDED
#define PROTOBUF_DccOperationsState_2eproto__INCLUDED

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

namespace modes3
{
namespace protobuf
{

    // Internal implementation detail -- do not call these.
    void protobuf_AddDesc_DccOperationsState_2eproto();
    void protobuf_AssignDesc_DccOperationsState_2eproto();
    void protobuf_ShutdownFile_DccOperationsState_2eproto();

    class DccOperationsState;

    // ===================================================================

    class DccOperationsState
        : public ::google::protobuf::
              Message /* @@protoc_insertion_point(class_definition:modes3.protobuf.DccOperationsState) */
    {
    public:
        DccOperationsState();
        virtual ~DccOperationsState();

        DccOperationsState(const DccOperationsState& from);

        inline DccOperationsState& operator=(const DccOperationsState& from)
        {
            CopyFrom(from);
            return *this;
        }

        static const ::google::protobuf::Descriptor* descriptor();
        static const DccOperationsState& default_instance();

        void Swap(DccOperationsState* other);

        // implements Message ----------------------------------------------

        inline DccOperationsState* New() const
        {
            return New(NULL);
        }

        DccOperationsState* New(::google::protobuf::Arena* arena) const;
        void CopyFrom(const ::google::protobuf::Message& from);
        void MergeFrom(const ::google::protobuf::Message& from);
        void CopyFrom(const DccOperationsState& from);
        void MergeFrom(const DccOperationsState& from);
        void Clear();
        bool IsInitialized() const;

        int ByteSize() const;
        bool MergePartialFromCodedStream(::google::protobuf::io::CodedInputStream* input);
        void SerializeWithCachedSizes(::google::protobuf::io::CodedOutputStream* output) const;
        ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(bool deterministic,
            ::google::protobuf::uint8* output) const;
        ::google::protobuf::uint8* SerializeWithCachedSizesToArray(::google::protobuf::uint8* output) const
        {
            return InternalSerializeWithCachedSizesToArray(false, output);
        }
        int GetCachedSize() const
        {
            return _cached_size_;
        }

    private:
        void SharedCtor();
        void SharedDtor();
        void SetCachedSize(int size) const;
        void InternalSwap(DccOperationsState* other);

    private:
        inline ::google::protobuf::Arena* GetArenaNoVirtual() const
        {
            return _internal_metadata_.arena();
        }
        inline void* MaybeArenaPtr() const
        {
            return _internal_metadata_.raw_arena_ptr();
        }

    public:
        ::google::protobuf::Metadata GetMetadata() const;

        // nested types ----------------------------------------------------

        // accessors -------------------------------------------------------

        // optional .modes3.protobuf.DccOperations dccOperations = 1;
        void clear_dccoperations();
        static const int kDccOperationsFieldNumber = 1;
        ::modes3::protobuf::DccOperations dccoperations() const;
        void set_dccoperations(::modes3::protobuf::DccOperations value);

        // @@protoc_insertion_point(class_scope:modes3.protobuf.DccOperationsState)
    private:
        ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
        bool _is_default_instance_;
        int dccoperations_;
        mutable int _cached_size_;
        friend void protobuf_AddDesc_DccOperationsState_2eproto();
        friend void protobuf_AssignDesc_DccOperationsState_2eproto();
        friend void protobuf_ShutdownFile_DccOperationsState_2eproto();

        void InitAsDefaultInstance();
        static DccOperationsState* default_instance_;
    };
// ===================================================================

// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
    // DccOperationsState

    // optional .modes3.protobuf.DccOperations dccOperations = 1;
    inline void DccOperationsState::clear_dccoperations()
    {
        dccoperations_ = 0;
    }
    inline ::modes3::protobuf::DccOperations DccOperationsState::dccoperations() const
    {
        // @@protoc_insertion_point(field_get:modes3.protobuf.DccOperationsState.dccOperations)
        return static_cast< ::modes3::protobuf::DccOperations>(dccoperations_);
    }
    inline void DccOperationsState::set_dccoperations(::modes3::protobuf::DccOperations value)
    {

        dccoperations_ = value;
        // @@protoc_insertion_point(field_set:modes3.protobuf.DccOperationsState.dccOperations)
    }

#endif // !PROTOBUF_INLINE_NOT_IN_HEADERS

    // @@protoc_insertion_point(namespace_scope)

} // namespace protobuf
} // namespace modes3

// @@protoc_insertion_point(global_scope)

#endif // PROTOBUF_DccOperationsState_2eproto__INCLUDED