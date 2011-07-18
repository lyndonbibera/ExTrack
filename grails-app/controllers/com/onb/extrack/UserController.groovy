package com.onb.extrack

class UserController {
    def registrationService //inject registrationService

    def index = {
        redirect(action: 'registration')
    }

    def registrationFlow = {
        userDetails {
            on("submitUserDetails") {
                flow.user = new User(params)
                if(flow.user.validate()) {
                    flash.message = "User Details Confirmed."
                    return success()
                }
                return error()
            }.to "budgetEnvelopes"

            on("cancel").to "registrationCancelled"
        }

        budgetEnvelopes {
            on("addBudgetEnvelope") {
                flow.budgetEnvelope = new BudgetEnvelope(user: flow.user)
                flow.budgetEnvelope.properties = params

                if(flow.budgetEnvelope.validate()) {
                    flow.user.addToBudgetEnvelopes(flow.budgetEnvelope)
                    flash.message = "Added $flow.budgetEnvelope.name"
                    flow.budgetEnvelope = new BudgetEnvelope() //clean variable
                    return success()
                }
                return error()
            }.to "budgetEnvelopes"

            on("submit").to "submitRegistration"
            on("cancel").to "registrationCancelled"
        }

        submitRegistration {     //BUG: looking for submitRegistration.jsp ???
            action {
                registrationService.register(flow.user)
                [user:flow.user]
            }
            on("success").to "registrationSuccess"
            on("error").to "budgetEnvelopes"
        }

        registrationSuccess {

        }

        registrationCancelled {

        }
    }
}