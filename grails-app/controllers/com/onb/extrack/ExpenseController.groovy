package com.onb.extrack

class ExpenseController {

    def index = {
        redirect(action: 'record')
    }

    def recordFlow = {
        initRecord {
            action {

            }
            on.("success"). to "displayExpenseForm"
            on.("error"). to "recordCancelled"
        }

        displayExpenseForm {

        }

        recordSuccess {

        }

        recordCancelled {

        }

    }
}
