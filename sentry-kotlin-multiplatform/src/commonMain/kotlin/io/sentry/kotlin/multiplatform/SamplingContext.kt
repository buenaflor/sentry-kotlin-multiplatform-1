package io.sentry.kotlin.multiplatform

/**
 * Context used to determine if transaction is going to be sampled.
 */
public data class SamplingContext(

    /**
     * Returns the transaction context.
     */
    public val transactionContext: TransactionContext
)
