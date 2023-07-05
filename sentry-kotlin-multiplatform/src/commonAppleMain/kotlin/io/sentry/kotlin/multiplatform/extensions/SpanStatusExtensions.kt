package io.sentry.kotlin.multiplatform.extensions

import io.sentry.kotlin.multiplatform.CocoaSpanStatus
import io.sentry.kotlin.multiplatform.SpanStatus

internal fun SpanStatus.toCocoa(): CocoaSpanStatus {
    return when (this) {
        SpanStatus.ABORTED -> CocoaSpanStatus.kSentrySpanStatusAborted
        SpanStatus.ALREADY_EXISTS -> CocoaSpanStatus.kSentrySpanStatusAlreadyExists
        SpanStatus.CANCELLED -> CocoaSpanStatus.kSentrySpanStatusCancelled
        SpanStatus.DATA_LOSS -> CocoaSpanStatus.kSentrySpanStatusDataLoss
        SpanStatus.DEADLINE_EXCEEDED -> CocoaSpanStatus.kSentrySpanStatusDeadlineExceeded
        SpanStatus.FAILED_PRECONDITION -> CocoaSpanStatus.kSentrySpanStatusFailedPrecondition
        SpanStatus.INVALID_ARGUMENT -> CocoaSpanStatus.kSentrySpanStatusInvalidArgument
        SpanStatus.NOT_FOUND -> CocoaSpanStatus.kSentrySpanStatusNotFound
        SpanStatus.OK -> CocoaSpanStatus.kSentrySpanStatusOk
        SpanStatus.OUT_OF_RANGE -> CocoaSpanStatus.kSentrySpanStatusOutOfRange
        SpanStatus.PERMISSION_DENIED -> CocoaSpanStatus.kSentrySpanStatusPermissionDenied
        SpanStatus.RESOURCE_EXHAUSTED -> CocoaSpanStatus.kSentrySpanStatusResourceExhausted
        SpanStatus.UNAUTHENTICATED -> CocoaSpanStatus.kSentrySpanStatusUnauthenticated
        SpanStatus.UNAVAILABLE -> CocoaSpanStatus.kSentrySpanStatusUnavailable
        SpanStatus.UNIMPLEMENTED -> CocoaSpanStatus.kSentrySpanStatusUnimplemented
        else -> {
            CocoaSpanStatus.kSentrySpanStatusUnknownError
        }
    }
}
