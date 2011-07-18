package com.onb.extrack

import grails.converters.JSON

class BudgetEnvelopeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[budgetEnvelopeInstanceList: BudgetEnvelope.list(params), budgetEnvelopeInstanceTotal: BudgetEnvelope.count()]
	}

    def create = {
        def budgetEnvelopeInstance = new BudgetEnvelope()
        budgetEnvelopeInstance.properties = params
        return [budgetEnvelopeInstance: budgetEnvelopeInstance]
    }

    def save = {
        def budgetEnvelopeInstance = new BudgetEnvelope(params)
        if (budgetEnvelopeInstance.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope'), budgetEnvelopeInstance.id])
            redirect(action: "show", id: budgetEnvelopeInstance.id)
        }
        else {
            render(view: "create", model: [budgetEnvelopeInstance: budgetEnvelopeInstance])
        }
    }

    def show = {
        def budgetEnvelopeInstance = BudgetEnvelope.get(params.id)
        if (!budgetEnvelopeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope'), params.id])
            redirect(action: "list")
        }
        else {
            [budgetEnvelopeInstance: budgetEnvelopeInstance]
        }
    }

    def edit = {
        def budgetEnvelopeInstance = BudgetEnvelope.get(params.id)
        if (!budgetEnvelopeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope'), params.id])
            redirect(action: "list")
        }
        else {
            return [budgetEnvelopeInstance: budgetEnvelopeInstance]
        }
    }

    def update = {
        def budgetEnvelopeInstance = BudgetEnvelope.get(params.id)
        if (budgetEnvelopeInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (budgetEnvelopeInstance.version > version) {
                    
                    budgetEnvelopeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope')] as Object[], "Another user has updated this BudgetEnvelope while you were editing")
                    render(view: "edit", model: [budgetEnvelopeInstance: budgetEnvelopeInstance])
                    return
                }
            }
            budgetEnvelopeInstance.properties = params
            if (!budgetEnvelopeInstance.hasErrors() && budgetEnvelopeInstance.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope'), budgetEnvelopeInstance.id])
                redirect(action: "show", id: budgetEnvelopeInstance.id)
            }
            else {
                render(view: "edit", model: [budgetEnvelopeInstance: budgetEnvelopeInstance])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope'), params.id])
            redirect(action: "list")
        }
    }

    def delete = {
        def budgetEnvelopeInstance = BudgetEnvelope.get(params.id)
        if (budgetEnvelopeInstance) {
            try {
                budgetEnvelopeInstance.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope'), params.id])
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope'), params.id])
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope'), params.id])
            redirect(action: "list")
        }
    }
}
