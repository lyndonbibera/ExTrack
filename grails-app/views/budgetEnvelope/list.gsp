
<%@ page import="com.onb.extrack.BudgetEnvelope" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'budgetEnvelope.label', default: 'BudgetEnvelope')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-budgetEnvelope" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-budgetEnvelope" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="budgetEnvelope.user.label" default="User" /></th>
					
						<g:sortableColumn property="name" title="${message(code: 'budgetEnvelope.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="allocatedBudget" title="${message(code: 'budgetEnvelope.allocatedBudget.label', default: 'Allocated Budget')}" />
					
						<g:sortableColumn property="runningBalance" title="${message(code: 'budgetEnvelope.runningBalance.label', default: 'Running Balance')}" />
					
						<g:sortableColumn property="active" title="${message(code: 'budgetEnvelope.active.label', default: 'Active')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${budgetEnvelopeInstanceList}" status="i" var="budgetEnvelopeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${budgetEnvelopeInstance.id}">${fieldValue(bean: budgetEnvelopeInstance, field: "user")}</g:link></td>
					
						<td>${fieldValue(bean: budgetEnvelopeInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: budgetEnvelopeInstance, field: "allocatedBudget")}</td>
					
						<td>${fieldValue(bean: budgetEnvelopeInstance, field: "runningBalance")}</td>
					
						<td><g:formatBoolean boolean="${budgetEnvelopeInstance.active}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${budgetEnvelopeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
