package com.onb.extrack

import grails.test.mixin.TestFor
import org.junit.Test
import org.junit.Before

@TestFor(User)
class UserTests extends GroovyTestCase {
    User user

    @Before
    void setUp() {
        mockDomain(User)
        user = new User()
    }

    void testFieldPresence() {
        user.firstName = "F"
        user.lastName = "L"

        assert user.firstName != null
        assert user.lastName != null
    }

    void testValidUser() {
        user.firstName = "F"
        user.lastName = "L"
        user.username = "U"
        user.password = "P"
        user.passwordConfirm = "P"

        assert user.validate()
    }

    void testBudgetEnvelopesArePresent() {
        user.addToBudgetEnvelopes(new BudgetEnvelope())

        assert user.budgetEnvelopes.size() == 1
    }

    void testTransactionsArePresent() {
        user.addToTransactions(new Transaction())

        assert user.transactions.size() == 1
    }

    void testAddTheSameBudgetEnvelope() {
        user.addToBudgetEnvelopes(new BudgetEnvelope(name: 'Name1'))
        user.addToBudgetEnvelopes(new BudgetEnvelope(name: 'Name1'))

        assert user.budgetEnvelopes.size() == 1
    }

    void testAddDifferentBudgetEnvelope() {
        user.addToBudgetEnvelopes(new BudgetEnvelope(name: 'Name1'))
        user.addToBudgetEnvelopes(new BudgetEnvelope(name: 'Name2'))

        assert user.budgetEnvelopes.size() == 2
    }

}
