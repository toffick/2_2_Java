<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 31.05.2017
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL INFO</title>
</head>
<body>

<jsp:include page="static/header.jsp"/>
<br>
<div width="100">Имя ${aname} </div>
<div width="100">Фамилия  ${asecondname} </div>
<div width="100">Возраст  ${aold} </div>
<div width="100">Цвет кожи  ${askin} </div>
<div width="100">Приветствие:  ${hello} </div>

<br>

<form action="form3.jsp">
    <input type="hidden"  name="Name" value="${aname}" >
    <input type="hidden"  name="SecondName" value="${asecondname}" >
    <input type="hidden"  name="yearold" value="${aold}" >
    <input type="hidden"  name="skincolor" value="${askin}" >

    <input type="submit" value="Назад">
</form>

<form action="index.jsp">
    <input type="submit" value="В начало">
</form>

<jsp:include page="static/footer.jsp"/>

</body>
</html>
