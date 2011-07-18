package com.onb.extrack

class Transaction implements Serializable {
    BigDecimal amount
    String transactedWith
    Date dateOfTransaction
    String note
    TransactionType transactionType

    static hasMany = [allocations: Allocation]

    static belongsTo = [user:User, allocations: Allocation]

    static constraints = {
        transactedWith(validator: {
            !it.equals("")
        })
        dateOfTransaction()
        amount(min: BigDecimal.ZERO)
        note()
    }

    @Override
    String toString() {
        "$transactionType of $user Amount: [$amount]"
    }
}

enum TransactionType {
    EXPENSE,
    INCOME
}
