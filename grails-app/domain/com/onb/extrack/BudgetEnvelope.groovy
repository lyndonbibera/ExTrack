package com.onb.extrack

class BudgetEnvelope implements Serializable {

    String name
    BigDecimal allocatedBudget = BigDecimal.ZERO
    BigDecimal runningBalance = BigDecimal.ZERO
    boolean active = true

    static hasMany = [
        allocations: Allocation
    ]

    static belongsTo = [user:User, allocations: Allocation]

    static constraints = {
        user(nullable: true)
        name(blank: false)
        allocatedBudget(nullable: true, min: BigDecimal.ZERO)
        runningBalance()
        active()
    }

    @Override
    String toString() {
        "$name"
    }
}
