<%--
  Created by IntelliJ IDEA.
  User: kleap
  Date: 20.05.2017
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/header.jsp" %>
<form>
    <input type="hidden" name="myname" value="${param.myname}">
    <input type="hidden" name="age" value="${param.age}">

    <p> ваше имя : ${param.myname}</p>
    <p> ваш возраст : ${param.age}</p>
    <label>Ваш родной город</label>
    <input type="text" name="city" value="${param.city}">
    <br>
    <button type="submit" formaction="form2.jsp">Назад</button>
    <button type="submit" formaction="form4.jsp">Вперед</button>
    <button type="submit" formaction="form1.jsp">В начало</button>
</form>
<%@include file="/static/footer.jsp" %>
