package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.protocol.SpanId

public expect interface Span {
}

public expect val Span.operation: String
public expect val Span.description: String?
public expect val Span.spanId: SpanId
public expect val Span.parentSpanId: SpanId?

/**
 * Starts a child Span.
 *
 * @param operation - new span operation name
 * @return a new transaction span
 */
public expect fun Span.startChild(operation: String): Span

/**
 * Starts a child Span.
 *
 * @param operation - new span operation name
 * @param description - new span description name
 * @return a new transaction span
 */
public expect fun Span.startChild(operation: String, description: String?): Span

/** Sets span timestamp marking this span as finished.  */
public expect fun Span.finish()

/**
 * Sets span timestamp marking this span as finished.
 *
 * @param status - the status
 */
public expect fun Span.finish(status: SpanStatus?)

/**
 * Sets the tag on span or transaction.
 *
 * @param key the tag key
 * @param value the tag value
 */
public expect fun Span.setTag(key: String, value: String)

/**
 * Returns the tag value with the specified key
 *
 * @param key the tag key
 *
 */
public expect fun Span.getTag(key: String): String?

/**
 * Returns if span has finished.
 *
 * @return if span has finished.
 */
public expect fun Span.isFinished(): Boolean

/**
 * Sets extra data on span or transaction.
 *
 * @param key the data key
 * @param value the data value
 */
public expect fun Span.setData(key: String, value: Any)

/**
 * Returns extra data from span or transaction.
 *
 * @return the data
 */
public expect fun Span.getData(key: String): Any?
