package io.sentry.kotlin.multiplatform

import io.sentry.protocol.TransactionNameSource

public actual typealias TransactionContext = io.sentry.TransactionContext

public actual val TransactionContext.name: String get() = name
public actual val TransactionContext.transactionNameSource: TransactionNameSource get() = transactionNameSource
public actual val TransactionContext.parentSampled: Boolean? get() = parentSampled
