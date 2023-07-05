package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.protocol.TransactionNameSource

/**
 * Context infromation of the transaction.
 */
public expect class TransactionContext public constructor(name: String, operation: String) : SpanContext

/**
 * The name of the transaction.
 */
public expect val TransactionContext.name: String

/**
 * The transaction name source.
 */
public expect val TransactionContext.transactionNameSource: TransactionNameSource

/**
 * Returns true if the parent span is sampled.
 */
public expect val TransactionContext.isParentSampled: Boolean?
