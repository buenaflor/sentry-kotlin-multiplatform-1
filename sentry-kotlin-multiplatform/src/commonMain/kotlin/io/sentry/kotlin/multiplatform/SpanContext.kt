package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.protocol.SentryId
import io.sentry.kotlin.multiplatform.protocol.SpanId

/** An interface representing the context of a span. */
public expect open class SpanContext

/** The name of the operation associated with the span.*/
public expect val SpanContext.operation: String

/** Determines which trace the span belongs to.*/
public expect val SpanContext.traceId: SentryId

/** The unique identifier of the span.*/
public expect val SpanContext.spanId: SpanId

/** The unique identifier of the span's parent, if any.*/
public expect val SpanContext.parentSpanId: SpanId?

/** Indicates if the span is sampled.*/
/**
 * Indicates if the span is sampled.
 */
// NOTE: It's called isSampled so it doesn't clash with the existing sampled variable in the
// Java SpanContext and Cocoa SentrySpanContext due to their different expected types.
// Java requires a Boolean? while Cocoa requires a SamplingDecision which is an enum.
// You cannot commonize those in an expect so it won't work in this actual typealias.
public expect val SpanContext.isSampled: Boolean?

/**
 * Longer description of the span's operation, which uniquely identifies the span but is
 * consistent across instances of the span.
 */
public expect val SpanContext.description: String?
