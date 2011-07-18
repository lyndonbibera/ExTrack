package com.onb.extrack


import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

@TestFor(UserController)
@TestMixin(GrailsUnitTestMixin)
class UserControllerTests extends GroovyTestCase {
    UserController userController

    @Before
    void setUp() {
        userController = new UserController()
    }

    void testIndex() {
        userController.index()
        assertEquals "/user/registration", userController.response.redirectedUrl
    }
}
