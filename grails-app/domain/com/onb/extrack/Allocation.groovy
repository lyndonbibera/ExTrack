package com.onb.extrack

class Allocation implements Serializable {

    BigDecimal amount
    Transaction transaction
    BudgetEnvelope budgetEnvelope

    static constraints = {
        transaction(validator: { value, obj ->
            value.amount.compareTo(obj.amount) >= 0
        })
        budgetEnvelope()
        amount(min: BigDecimal.ZERO)
    }

    @Override
    String toString() {
        "Transaction: [$transaction] BudgetEnvelope: [$budgetEnvelope] Amount: [$amount]"
    }
}
