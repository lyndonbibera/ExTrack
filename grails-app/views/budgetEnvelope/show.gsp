
<%@ page import="com.onb.extrack.BudgetEnvelope" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-budgetEnvelope" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-budgetEnvelope" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list budgetEnvelope">
			
				<g:if test="${budgetEnvelopeInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="budgetEnvelope.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${budgetEnvelopeInstance?.user?.id}">${budgetEnvelopeInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${budgetEnvelopeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="budgetEnvelope.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${budgetEnvelopeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${budgetEnvelopeInstance?.allocatedBudget}">
				<li class="fieldcontain">
					<span id="allocatedBudget-label" class="property-label"><g:message code="budgetEnvelope.allocatedBudget.label" default="Allocated Budget" /></span>
					
						<span class="property-value" aria-labelledby="allocatedBudget-label"><g:fieldValue bean="${budgetEnvelopeInstance}" field="allocatedBudget"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${budgetEnvelopeInstance?.runningBalance}">
				<li class="fieldcontain">
					<span id="runningBalance-label" class="property-label"><g:message code="budgetEnvelope.runningBalance.label" default="Running Balance" /></span>
					
						<span class="property-value" aria-labelledby="runningBalance-label"><g:fieldValue bean="${budgetEnvelopeInstance}" field="runningBalance"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${budgetEnvelopeInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="budgetEnvelope.active.label" default="Active" /></span>
					
						<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${budgetEnvelopeInstance?.active}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${budgetEnvelopeInstance?.allocations}">
				<li class="fieldcontain">
					<span id="allocations-label" class="property-label"><g:message code="budgetEnvelope.allocations.label" default="Allocations" /></span>
					
						<g:each in="${budgetEnvelopeInstance.allocations}" var="a">
						<span class="property-value" aria-labelledby="allocations-label"><g:link controller="allocation" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${budgetEnvelopeInstance?.id}" />
					<g:link class="edit" action="edit" id="${budgetEnvelopeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
