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
    <h1>Registration Cancelled</h1>
    <g:if test="${message}">%{-- Message --}%
        <div class="message" role="status">${message}</div>
    </g:if>
</div>
</body>
</html>