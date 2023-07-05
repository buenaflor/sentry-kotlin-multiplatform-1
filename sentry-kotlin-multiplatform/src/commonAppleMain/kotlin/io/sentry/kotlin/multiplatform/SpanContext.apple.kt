package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.extensions.toBoolean
import io.sentry.kotlin.multiplatform.protocol.SentryId
import io.sentry.kotlin.multiplatform.protocol.SpanId

public actual typealias SpanContext = cocoapods.Sentry.SentrySpanContext

/** The name of the operation associated with the span.*/
public actual val SpanContext.operation: String get() = operation()

/** Determines which trace the span belongs to.*/
public actual val SpanContext.traceId: SentryId get() = SentryId(traceId().toString())

/** The unique identifier of the span.*/
public actual val SpanContext.spanIdentifier: SpanId get() = SpanId(spanId().toString())

/** The unique identifier of the span's parent, if any.*/
public actual val SpanContext.parentSpanIdentifier: SpanId? get() = parentSpanId?.let { SpanId(it.toString()) }

/**
 * Indicates if the span is sampled.
 */
// NOTE: It's called isSampled so it doesn't clash with the existing sampled variable in the
// Java SpanContext and Cocoa SentrySpanContext due to their different expected types.
// Java requires a Boolean? while Cocoa requires a SamplingDecision which is an enum.
// You cannot commonize those in an expect so it won't work in this actual typealias.
public actual val SpanContext.isSampled: Boolean? get() = sampled().toBoolean()

/**
 * Longer description of the span's operation, which uniquely identifies the span but is
 * consistent across instances of the span.
 */
public actual val SpanContext.description: String? get() = description()
