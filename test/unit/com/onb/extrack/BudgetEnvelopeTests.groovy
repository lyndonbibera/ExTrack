package com.onb.extrack

import grails.test.mixin.*
import org.junit.*

@TestFor(BudgetEnvelope)
class BudgetEnvelopeTests extends GroovyTestCase {
    BudgetEnvelope budgetEnvelope

    @Before
    void setUp() {
        mockDomain(BudgetEnvelope)
        budgetEnvelope = new BudgetEnvelope()
    }

    void testFieldPresence() {
        budgetEnvelope.name = ""
        budgetEnvelope.allocatedBudget = BigDecimal.ZERO
        budgetEnvelope.runningBalance = BigDecimal.ZERO
        budgetEnvelope.active = true
        budgetEnvelope.user = new User()

        assert budgetEnvelope.name != null
        assert budgetEnvelope.allocatedBudget != null
        assert budgetEnvelope.runningBalance != null
        assert budgetEnvelope.active != null
        assert budgetEnvelope.user != null
    }

    void testValidBudgetEnvelope() {
        budgetEnvelope.name = "Food"
        budgetEnvelope.allocatedBudget = BigDecimal.ZERO
        budgetEnvelope.runningBalance = BigDecimal.ZERO
        budgetEnvelope.active = true
        budgetEnvelope.user = new User()

        assert budgetEnvelope.validate()
    }

    void testAllocationsList() {
        budgetEnvelope.addToAllocations(new Allocation())

        assert budgetEnvelope.allocations.size() == 1
    }

    void testShortName() {
        budgetEnvelope.name = ""

        assert !budgetEnvelope.validate(['name'])
    }

    void testNullName() {
        assert  !budgetEnvelope.validate(['name'])
    }

    void testValidName() {
        budgetEnvelope.name = "V"
        assert  budgetEnvelope.validate(['name'])
    }

    void testNegativeAllocatedBudget() {
        budgetEnvelope.allocatedBudget = new BigDecimal("-100.00")

        assert !budgetEnvelope.validate(['allocatedBudget'])
    }

    void testValidAllocatedBudget() {
        budgetEnvelope.allocatedBudget = new BigDecimal("100.00")

        assert budgetEnvelope.validate(['allocatedBudget'])
    }

}
