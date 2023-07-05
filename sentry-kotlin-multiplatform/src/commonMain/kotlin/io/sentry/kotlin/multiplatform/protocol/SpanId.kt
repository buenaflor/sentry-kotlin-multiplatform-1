package io.sentry.kotlin.multiplatform.protocol

/**
 * Represents the span identifier.
 */
public expect class SpanId public constructor() {

    public constructor(value: String)

    override fun equals(other: Any?): Boolean

    override fun hashCode(): Int

    override fun toString(): String

    public companion object {
        /**
         * Returns an empty SpanId.
         */
        public val EMPTY_ID: SpanId
    }
}
