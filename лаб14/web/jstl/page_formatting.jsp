<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04.06.2017
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Page formatting</title>
</head>
<body>



<jsp:useBean id="now" class="java.util.Date"/>
<f:setLocale value="en-EN"/>
Вывод даты в формате Eng<br>
Сегодня: <f:formatDate value="${now}"/> <br/>
<f:setLocale value="ru-RU"/>
    Вывод даты в формате Rus<br>
    Сегодня: <f:formatDate value="${now}"/> <br/>


<br/><br/>

<c:set var="number" value="100500"/>
    Вывод числа ${number} в разных форматах:<br/>
    По умолчанию: <f:formatNumber value="${number}"/><br/>
    В процентах : <f:formatNumber value="${number}" type="percent"/><br/>
    Российский рубль :
    <f:setLocale value="ru-RU"/>
    <f:formatNumber value="${number}" type="currency"/><br/>


<br/>
<br/>
<a href="jstl_index.jsp">Назад </a>
</body>
</html>
