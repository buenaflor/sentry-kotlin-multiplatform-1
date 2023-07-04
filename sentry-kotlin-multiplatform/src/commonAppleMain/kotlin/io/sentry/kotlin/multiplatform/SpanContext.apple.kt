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
public actual val SpanContext.spanId: SpanId get() = SpanId(spanId().toString())

/** The unique identifier of the span's parent, if any.*/
public actual val SpanContext.parentSpanId: SpanId? get() = parentSpanId?.let { SpanId(it.toString()) }

/** Indicates if the span is sampled.*/
public actual val SpanContext.sampled: Boolean? get() = sampled().toBoolean()
