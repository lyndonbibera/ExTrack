package com.onb.extrack

class RegistrationService {
    static transactional = true
    def springSecurityService //inject spring sec

    /**
     * Registers a new non-admin user.
     * @param user
     * @return
     */
    def register(User user) {
        //make the new user non-admin
        Role role = Role.findByAuthority("USER") ?: new Role(authority: "USER", flush: true, insert: true)

        assert role.validate()
        //hash password
        user.password = springSecurityService.encodePassword(user.password)
        user.passwordConfirm = springSecurityService.encodePassword(user.passwordConfirm)
        user.save(flush: true)

        assert user.validate()

        UserRole.create(user, role, true)
    }
}
