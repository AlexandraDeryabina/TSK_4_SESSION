<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="label.title"/></title>
</head>
<body>
<form>
    <p><strong><fmt:message key="label.surname"/></strong></p>
</form>
<form method="post" action="surname">
    <input name="surname" required="required"/>
    <button><fmt:message key="label.send"/></button>
</form>
</body>
