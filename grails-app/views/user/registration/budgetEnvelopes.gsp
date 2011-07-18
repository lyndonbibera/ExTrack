<%@ page import="com.onb.extrack.BudgetEnvelope" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    %{-- Maps the Layout to views/layout/_main.gsp --}%
    <meta name="layout" content="main">
    <title>User Details</title>
</head>

<body>
%{-- Top Navigation --}%
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>

<div id="create-budgetEnvelope" class="content scaffold-create" role="main">
    <h1>Registration: Add Budget Envelopes</h1>

    <g:if test="${message}">%{-- Message --}%
        <div class="message" role="status">${message}</div>
    </g:if>

    <g:hasErrors bean="${budgetEnvelope}">%{-- Errors --}%
        <ul class="errors" role="alert">
            <g:eachError bean="${budgetEnvelope}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                    <g:message error="${error}"/>
                </li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <g:form action="registration">
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: budgetEnvelope, field: 'name', 'error')} ">
                <label for="name">Budget Envelope</label>
                <g:textField name="name" value="${budgetEnvelope?.name}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: budgetEnvelope, field: 'allocatedBudget', 'error')} ">
                <label for="name">Initial Amount</label>
                <g:textField name="allocatedBudget" value="${budgetEnvelope?.allocatedBudget}"/>
            </div>
        </fieldset>

        <fieldset class="buttons">
            <g:submitButton name="addBudgetEnvelope" class="add" value="Add Budget Envelope"/>
            <g:submitButton name="cancel" class="cancel" value="Cancel Registration"/>
            <g:submitButton name="submit" class="save" value="Finish Registration"/>
        </fieldset>
    </g:form>
</div>

<g:if test="${user.budgetEnvelopes?.size() > 0}">
    <table>
        <thead>
        <tr>
            <th width="30%">Budget Envelope</th>
            <th>Initial Amount</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${user.budgetEnvelopes}" var="budgetEnvelope">
            <tr>
                <td>${budgetEnvelope.name}</td>
                <td>${budgetEnvelope.allocatedBudget}</td>
            </tr>
        </g:each>
        </tbody>
    </table>

</g:if>
<g:else>
    <div class="message" role="status">
        <b>No Budget Envelopes added Yet.</b>
    </div>
</g:else>

</body>
</html>