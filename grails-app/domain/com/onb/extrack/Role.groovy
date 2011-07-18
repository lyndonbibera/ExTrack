package com.onb.extrack

class Role implements Serializable {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}

    @Override
    String toString() {
        "$authority"
    }
}
