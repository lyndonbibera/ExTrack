package com.onb.extrack

class RegistrationServiceTests {
    def springSecurityService

    void testSomething() {
        assert springSecurityService != null

        User user = new User(username: 'user1', password: 'user1', firstName: 'L', lastName: 'B', passwordConfirm: 'user1')

        assert user.validate()

        RegistrationService registrationService = new RegistrationService()
        registrationService.springSecurityService = springSecurityService

        assert springSecurityService != null

        registrationService.register(user)
    }
}
