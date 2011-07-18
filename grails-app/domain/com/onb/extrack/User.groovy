package com.onb.extrack

class User implements Serializable {

	String username
	String password
    String passwordConfirm
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false
    String firstName
    String lastName

    static hasMany = [
        budgetEnvelopes: BudgetEnvelope,
        transactions: Transaction
    ]

	static constraints = {
		username(blank: false, unique: true)
		password(blank: false, validator: { password, obj ->
            String passwordConfirm = obj.properties['passwordConfirm']
            password.equals(passwordConfirm) ? true : 'user.registration.password.mismatch'
        })
        firstName(blank: false)
        lastName(blank:  false)
	}

    static transients = ['passwordConfirm']

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

    @Override
    String toString() {
        "$firstName $lastName"
    }

    /**
     * Ensures the uniqueness of a budget envelope name (on a per-user basis)
     * @param budgetEnvelope
     */
    @Override
    void addToBudgetEnvelopes(BudgetEnvelope budgetEnvelope) {
        boolean existsByName = false
        if(budgetEnvelopes == null) {
            budgetEnvelopes = new HashSet()
        }
        budgetEnvelopes.each {
            if(it.name.equals(budgetEnvelope.name)) {
                existsByName = true
            }
        }
        if(!existsByName) {
            budgetEnvelopes.add(budgetEnvelope)
        }
    }
}
