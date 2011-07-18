package com.onb.extrack

import grails.test.mixin.*
import org.junit.*

@TestFor(Transaction)
class TransactionTests extends GroovyTestCase {
    Transaction transaction

    @Before
    void setUp() {
        mockDomain(Transaction)
        transaction = new Transaction()
    }

    void testFieldPresence() {
        transaction.amount = BigDecimal.ZERO
        transaction.transactedWith = ""
        transaction.dateOfTransaction = new Date()
        transaction.note = ""
        transaction.transactionType = TransactionType.INCOME

        assert transaction.amount != null
        assert transaction.transactedWith != null
        assert transaction.dateOfTransaction != null
        assert transaction.note != null
        assert transaction.transactionType != null
    }

    void testValidTransaction() {
        transaction.amount = BigDecimal.ZERO
        transaction.transactedWith = "T"
        transaction.dateOfTransaction = new Date()
        transaction.note = "N"
        transaction.transactionType = TransactionType.INCOME
        transaction.user = new User()

        assert transaction.validate()
    }

    void testNegativeAmount() {
        transaction.amount = new BigDecimal("-1.00")

        assert !transaction.validate(['amount'])
    }

    void testValidAmount() {
        transaction.amount = BigDecimal.ZERO

        assert transaction.validate(['amount'])
    }

    void testBlankName() {
        transaction.transactedWith = ""

        assert !transaction.validate(['transactedWith'])
    }

    void testCorrectName() {
        transaction.transactedWith = "T"

        assert transaction.validate(['transactedWith'])
    }

}
