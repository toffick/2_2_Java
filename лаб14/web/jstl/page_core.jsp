<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04.06.2017
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Core jstl page</title>
</head>
<body>

<c:out value="Пример вывода текста"/>
<br/>

<c:set var="user" value="Nick user" scope="page"/>
<c:set var="emptyv" value="" scope="page"/>
<c:if test="${empty emptyv}">
    <c:out value="${user}"/>
</c:if>

<br/>
<br/>

<c:remove var="emptyv"/>



<c:set var="val" value="10"/>
<c:out value="Вввели число ${val}"/>
    <br/>
<c:choose>
    <c:when test="${val < 5}">
        ${val} меньше 5
    </c:when>
    <c:when test="${val > 5}">
        ${val} больше 5
    </c:when>
    <c:otherwise>
        Мда
    </c:otherwise>
</c:choose>
<br/>
<br/>
<c:out value="Демонстрация обработки ошибок"/>
<c:set var="numbd" value="11.11"/>
    <c:catch var="exception">
        <c:if test="${numbd <3}">
                ${numbd} меньше 3
        </c:if>
    </c:catch>
<c:if test="${not empty exception}">
    <c:out value=" Неверный тип ${numbd}"/>
    <br/>
    Ошибка ${exception}
</c:if>
<br/>
<br/>

<c:forEach var="clip" items="${headerValues}" varStatus="сounter" >
    <tr><td>${сounter.count}></td> <td>${clip.key.toString()}</td></tr><br/>
</c:forEach>
<br/>
    <br/>
    <a href="jstl_index.jsp">Назад </a>
    </body>
</html>
