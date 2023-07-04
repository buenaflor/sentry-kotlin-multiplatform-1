package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.protocol.SentryId
import io.sentry.kotlin.multiplatform.protocol.SpanId

/** An interface representing the context of a span. */
public expect open class SpanContext {

    /** A longer description of the span's operation, which uniquely identifies the span but is
     * consistent across instances of the span.*/
    // protected val description: String?
}
/** The name of the operation associated with the span.*/
public expect val SpanContext.operation: String

/** Determines which trace the span belongs to.*/
public expect val SpanContext.traceId: SentryId

/** The unique identifier of the span.*/
public expect val SpanContext.spanId: SpanId

/** The unique identifier of the span's parent, if any.*/
public expect val SpanContext.parentSpanId: SpanId?

/** Indicates if the span is sampled.*/
public expect val SpanContext.sampled: Boolean?
