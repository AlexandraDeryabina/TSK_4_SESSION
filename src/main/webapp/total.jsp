<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="label.title"/></title>
</head>
<body>
    <h1><fmt:message key="label.hello"/>${surname} ${name} ${patronymic}</h1>
</body>
</html>
