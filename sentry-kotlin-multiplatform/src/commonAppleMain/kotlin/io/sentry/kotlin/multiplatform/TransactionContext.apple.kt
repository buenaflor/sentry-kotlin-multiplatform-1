package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.extensions.toBoolean
import io.sentry.kotlin.multiplatform.extensions.toKmpTransactionNameSource
import io.sentry.kotlin.multiplatform.protocol.TransactionNameSource

public actual typealias TransactionContext = cocoapods.Sentry.SentryTransactionContext

public actual val TransactionContext.name: String get() = name
public actual val TransactionContext.transactionNameSource: TransactionNameSource get() = nameSource().toKmpTransactionNameSource()
public actual val TransactionContext.isParentSampled: Boolean? get() = parentSampled().toBoolean()
