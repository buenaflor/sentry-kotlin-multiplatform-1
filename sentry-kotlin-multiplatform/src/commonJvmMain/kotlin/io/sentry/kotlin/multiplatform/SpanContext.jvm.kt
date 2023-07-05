package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.protocol.SentryId
import io.sentry.kotlin.multiplatform.protocol.SpanId

public actual typealias SpanContext = io.sentry.SpanContext

public actual val SpanContext.operation: String get() = operation

public actual val SpanContext.traceId: SentryId get() = SentryId(traceId.toString())

public actual val SpanContext.spanIdentifier: SpanId get() = spanId

public actual val SpanContext.parentSpanIdentifier: SpanId? get() = parentSpanId

public actual val SpanContext.isSampled: Boolean? get() = sampled

public actual val SpanContext.description: String? get() = description
