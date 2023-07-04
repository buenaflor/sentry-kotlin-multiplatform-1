package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.protocol.SpanId

public actual typealias Span = io.sentry.ISpan

/** The span operation. */
public actual val Span.operation: String get() = operation

/** The span description. */
public actual val Span.description: String? get() = description

/** The span id */
public actual val Span.spanId: SpanId get() = SpanId(spanId.toString())

/** The parent span id */
public actual val Span.parentSpanId: SpanId? get() = parentSpanId?.let { SpanId(it.toString()) }

/**
 * Starts a child Span.
 *
 * @param operation - new span operation name
 * @return a new transaction span
 */
public actual fun Span.startChild(operation: String): Span = startChild(operation)

/**
 * Starts a child Span.
 *
 * @param operation - new span operation name
 * @param description - new span description name
 * @return a new transaction span
 */
public actual fun Span.startChild(operation: String, description: String?): Span =
    startChild(operation, description)

/** Sets span timestamp marking this span as finished.  */
public actual fun Span.finish(): Unit = finish()

/**
 * Sets span timestamp marking this span as finished.
 *
 * @param status - the status
 */
public actual fun Span.finish(status: SpanStatus?): Unit = finish(status)

/**
 * Sets the tag on span or transaction.
 *
 * @param key the tag key
 * @param value the tag value
 */
public actual fun Span.setTag(key: String, value: String): Unit = setTag(key, value)

/**
 * Returns the tag value with the specified key
 *
 * @param key the tag key
 *
 */
public actual fun Span.getTag(key: String): String? = getTag(key)

/**
 * Returns if span has finished.
 *
 * @return if span has finished.
 */
public actual fun Span.isFinished(): Boolean = isFinished

/**
 * Sets extra data on span or transaction.
 *
 * @param key the data key
 * @param value the data value
 */
public actual fun Span.setData(key: String, value: Any): Unit = setData(key, value)

/**
 * Returns extra data from span or transaction.
 *
 * @return the data
 */
public actual fun Span.getData(key: String): Any? = getData(key)
