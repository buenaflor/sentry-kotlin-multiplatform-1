package io.sentry.kotlin.multiplatform.utils

public actual class StringUtils {
    public actual companion object {
        private const val CORRUPTED_NIL_UUID = "0000-0000"
        private const val PROPER_NIL_UUID = "00000000-0000-0000-0000-000000000000"

        /**
         * Normalizes UUID string representation to adhere to the actual UUID standard
         *
         *
         * Because Motorola decided that nil UUIDs should look like this: "0000-0000" ;)
         *
         * @param uuidString the original UUID string representation
         * @return proper UUID string, in case it's a corrupted one
         */
        public actual fun normalizeUUID(uuidString: String): String {
            return if (uuidString == CORRUPTED_NIL_UUID) {
                PROPER_NIL_UUID
            } else uuidString
        }
    }
}