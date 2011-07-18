package com.onb.extrack

import grails.test.mixin.TestFor
import org.junit.Before

@TestFor(Allocation)
class AllocationTests extends GroovyTestCase {
    Allocation allocation

    @Before
    void setUp() {
        mockDomain(Allocation)
        allocation = new Allocation()
    }

    void testFieldPresence() {
        allocation.amount = BigDecimal.ZERO
        allocation.budgetEnvelope = new BudgetEnvelope()
        allocation.transaction = new Transaction()

        assert allocation.budgetEnvelope != null
        assert allocation.transaction != null
        assert allocation.amount != null
    }

    void testValidAllocation() {
        allocation.amount = BigDecimal.ZERO
        allocation.budgetEnvelope = new BudgetEnvelope()
        allocation.transaction = new Transaction(amount: BigDecimal.ZERO)

        assert allocation.validate()
    }

    void testInvalidAmount() {
        allocation.amount = new BigDecimal("-1.00")

        assert !allocation.validate(['amount'])
    }

    void testValidAmount() {
        allocation.amount = new BigDecimal("1.00")

        assert allocation.validate(['amount'])
    }

    void testNullTransaction() {
        assert !allocation.validate(['transaction'])
    }

    void testExceedTransactionAmount() {
        allocation.amount = new BigDecimal("100.01")
        allocation.transaction = new Transaction(amount: new BigDecimal("100.00"))

        assert !allocation.validate(['transaction'])
    }

    void testValidTransaction() {
        allocation.amount = new BigDecimal("100.00")
        allocation.transaction = new Transaction(amount: new BigDecimal("100.00"))

        assert allocation.validate(['transaction'])
    }

    void testNullBudgetEnvelope() {

        assert !allocation.validate(['budgetEnvelope'])
    }

    void testValidBudgetEnvelope() {
        allocation.budgetEnvelope = new BudgetEnvelope()

        assert allocation.validate(['budgetEnvelope'])
    }
}
