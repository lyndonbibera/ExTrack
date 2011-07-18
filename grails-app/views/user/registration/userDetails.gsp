<%@ page contentType="text/html;charset=UTF-8" %>
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
    <h1>Registration: User Details</h1>

    <g:if test="${message}"> %{-- Message --}%
        <div class="message" role="status">${message}</div>
    </g:if>

    <g:hasErrors bean="${user}"> %{-- Errors --}%
        <ul class="errors" role="alert">
            <g:eachError bean="${user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
                    <g:message error="${error}"/>
                </li>
            </g:eachError>
        </ul>
    </g:hasErrors>

    <g:form action="registration">
        <fieldset class="form">

            <div class="fieldcontain ${hasErrors(bean: user, field: 'username', 'error')} ">%{-- Field Error --}%
                <label for="username">Username</label> %{-- Field Label --}%
            <g:textField name="username" value="${user?.username}"/> %{-- Field --}%
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'password', 'error')} ">
                <label for="password">Password</label>
                <g:passwordField name="password"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'passwordConfirm', 'error')} ">
                <label for="passwordConfirm">Confirm Password</label>
                <g:passwordField name="passwordConfirm"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'firstName', 'error')} ">
                <label for="firstName">First Name</label>
                <g:textField name="firstName" value="${user?.firstName}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'lastName', 'error')} ">
                <label for="lastName">Last Name</label>
                <g:textField name="lastName" value="${user?.lastName}"/>
            </div>

        </fieldset>

        <fieldset class="buttons">
            <g:submitButton name="submitUserDetails" class="accept" value="Continue"/>
            <g:submitButton name="cancel" class="cancel" value="Cancel"/>
        </fieldset>
    </g:form>

</div>
</body>
</html>