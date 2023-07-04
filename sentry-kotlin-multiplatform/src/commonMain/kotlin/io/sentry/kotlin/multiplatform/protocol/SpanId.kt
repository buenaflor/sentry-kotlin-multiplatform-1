package io.sentry.kotlin.multiplatform.protocol

public expect class SpanId public constructor() {

    public constructor(value: String)

    override fun equals(other: Any?): Boolean

    override fun hashCode(): Int

    override fun toString(): String

    public companion object {
        public val EMPTY_ID: SpanId
    }
}
