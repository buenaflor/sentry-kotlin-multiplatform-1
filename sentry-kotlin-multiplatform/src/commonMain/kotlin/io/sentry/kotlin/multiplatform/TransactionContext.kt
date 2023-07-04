package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.protocol.TransactionNameSource

public expect class TransactionContext : SpanContext

public expect val TransactionContext.name: String
public expect val TransactionContext.transactionNameSource: TransactionNameSource
public expect val TransactionContext.parentSampled: Boolean?