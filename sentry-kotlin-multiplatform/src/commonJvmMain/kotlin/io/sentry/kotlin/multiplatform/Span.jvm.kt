package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.protocol.SpanId

public actual typealias Span = io.sentry.ISpan

public actual val Span.operation: String get() = operation

public actual val Span.description: String? get() = description

public actual val Span.spanId: SpanId get() = spanContext.spanId

public actual val Span.parentSpanId: SpanId? get() = spanContext.parentSpanId

public actual fun Span.startChild(operation: String): Span = startChild(operation)

public actual fun Span.startChild(operation: String, description: String?): Span =
    startChild(operation, description)

public actual fun Span.finish(): Unit = finish()

public actual fun Span.finish(status: SpanStatus?): Unit = finish(status)

public actual fun Span.setTag(key: String, value: String): Unit = setTag(key, value)

public actual fun Span.getTag(key: String): String? = getTag(key)

public actual fun Span.isFinished(): Boolean = isFinished

public actual fun Span.setData(key: String, value: Any): Unit = setData(key, value)

public actual fun Span.getData(key: String): Any? = getData(key)
