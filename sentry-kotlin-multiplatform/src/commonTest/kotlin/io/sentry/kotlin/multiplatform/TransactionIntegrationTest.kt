package io.sentry.kotlin.multiplatform

import io.sentry.kotlin.multiplatform.utils.fakeDsn
import kotlin.test.Test
import kotlin.test.assertEquals

class TransactionIntegrationTest : BaseSentryTest() {

    @Test
    fun `tracesSampler can receive correct TransactionContext name`() {
        val expectedName = "test"
        var actualName = ""
        sentryInit {
            it.dsn = fakeDsn
            it.tracesSampler = { context ->
                actualName = context.transactionContext.name
                null
            }
        }
        val transaction = Sentry.startTransaction("test", "testOperation")
        transaction.finish()
        assertEquals(expectedName, actualName)
    }

    @Test
    fun `tracesSampler can receive correct TransactionContext spanId`() {
        var actualSpanId = ""
        sentryInit {
            it.dsn = fakeDsn
            it.tracesSampler = { context ->
                actualSpanId = context.transactionContext.spanIdentifier.toString()
                null
            }
        }
        val transaction = Sentry.startTransaction("test", "testOperation")
        transaction.finish()
        assertEquals(transaction.spanId.toString(), actualSpanId)
    }

    @Test
    fun `parentSpanId is correct after starting child span`() {
        sentryInit {
            it.dsn = fakeDsn
        }
        val transaction = Sentry.startTransaction("test", "testOperation")
        val child = transaction.startChild("child")
        child.finish()
        transaction.finish()
        assertEquals(child.parentSpanId?.toString(), transaction.spanId.toString())
    }

    @Test
    fun `tracesSampler can receive correct TransactionContext operation`() {
        val expectedOperation = "testOperation"
        var actualOperation = ""
        sentryInit {
            it.dsn = fakeDsn
            it.tracesSampler = { context ->
                actualOperation = context.transactionContext.operation
                null
            }
        }
        val transaction = Sentry.startTransaction("test", "testOperation")
        transaction.finish()
        assertEquals(expectedOperation, actualOperation)
    }

    @Test
    fun `tracesSampler can receive correct TransactionContext sampled`() {
        val expectedSampled = false
        var actualSampled: Boolean? = null
        sentryInit {
            it.dsn = fakeDsn
            it.tracesSampler = { context ->
                actualSampled = context.transactionContext.isSampled
                null
            }
        }
        val transaction = Sentry.startTransaction("test", "testOperation")
        transaction.finish()
        assertEquals(expectedSampled, actualSampled)
    }

    @Test
    fun `tracesSampler can receive correct TransactionContext parentSampled`() {
        val expectedSampled = false
        var actualSampled: Boolean? = null
        sentryInit {
            it.dsn = fakeDsn
            it.tracesSampler = { context ->
                actualSampled = context.transactionContext.isParentSampled
                null
            }
        }
        val transaction = Sentry.startTransaction("test", "testOperation")
        transaction.finish()
        assertEquals(expectedSampled, actualSampled)
    }
}
