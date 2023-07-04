package io.sentry.kotlin.multiplatform.protocol

import io.sentry.kotlin.multiplatform.CocoaSpanId
import io.sentry.kotlin.multiplatform.utils.StringUtils
import platform.Foundation.NSUUID

public actual class SpanId public actual constructor(value: String) {

    private val value: String = CocoaSpanId.empty.toString()

    public actual constructor() : this(NSUUID())

    private constructor(uuid: NSUUID) : this(
        StringUtils.normalizeUUID(uuid.UUIDString()).replace("-", "").substring(0, 16)
    )

    actual override fun toString(): String {
        return value
    }

    public actual companion object {
        public actual val EMPTY_ID: SpanId = SpanId(CocoaSpanId.empty.toString())
    }
}