<%@ page import="com.onb.extrack.BudgetEnvelope" %>



<div class="fieldcontain ${hasErrors(bean: budgetEnvelopeInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="budgetEnvelope.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.onb.extrack.User.list()}" optionKey="id" required="" value="${budgetEnvelopeInstance?.user?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: budgetEnvelopeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="budgetEnvelope.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${budgetEnvelopeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: budgetEnvelopeInstance, field: 'allocatedBudget', 'error')} required">
	<label for="allocatedBudget">
		<g:message code="budgetEnvelope.allocatedBudget.label" default="Allocated Budget" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="allocatedBudget" min="0" required="" value="${fieldValue(bean: budgetEnvelopeInstance, field: 'allocatedBudget')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: budgetEnvelopeInstance, field: 'runningBalance', 'error')} required">
	<label for="runningBalance">
		<g:message code="budgetEnvelope.runningBalance.label" default="Running Balance" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="runningBalance" required="" value="${fieldValue(bean: budgetEnvelopeInstance, field: 'runningBalance')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: budgetEnvelopeInstance, field: 'active', 'error')} ">
	<label for="active">
		<g:message code="budgetEnvelope.active.label" default="Active" />
		
	</label>
	<g:checkBox name="active" value="${budgetEnvelopeInstance?.active}" />
</div>

<div class="fieldcontain ${hasErrors(bean: budgetEnvelopeInstance, field: 'allocations', 'error')} ">
	<label for="allocations">
		<g:message code="budgetEnvelope.allocations.label" default="Allocations" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${budgetEnvelopeInstance?.allocations?}" var="a">
    <li><g:link controller="allocation" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="allocation" action="create" params="['budgetEnvelope.id': budgetEnvelopeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'allocation.label', default: 'Allocation')])}</g:link>
</li>
</ul>

</div>

