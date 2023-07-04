package io.sentry.kotlin.multiplatform.utils

public expect class StringUtils {
    public companion object {
        /**
         * Normalizes UUID string representation to adhere to the actual UUID standard
         *
         *
         * Because Motorola decided that nil UUIDs should look like this: "0000-0000" ;)
         *
         * @param uuidString the original UUID string representation
         * @return proper UUID string, in case it's a corrupted one
         */
        public fun normalizeUUID(uuidString: String): String
    }
}
