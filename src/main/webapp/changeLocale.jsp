<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ru.lanit.filter.SessionLocaleFilter" %>
<%@ page import="ru.lanit.service.Locale" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${param.lang}">
<body>
<h2>
    <fmt:message key="label.chooseSessionLocale" />
</h2>

<ul>
    <li><a href="?<%=SessionLocaleFilter.SESSION_LOCALE%>=<%=Locale.en.name()%>"><fmt:message key="label.lang.en" /></a></li>
    <li><a href="?<%=SessionLocaleFilter.SESSION_LOCALE%>=<%=Locale.ru.name()%>"><fmt:message key="label.lang.ru" /></a></li>
</ul>
</body>
</html>