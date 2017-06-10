<%--
  Created by IntelliJ IDEA.
  User: kleap
  Date: 20.05.2017
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form>
    <%@include file="/static/header.jsp" %>
    <input type="hidden" name="myname" value="${param.myname}">
    <p> ваше имя : ${param.myname}</p>
    <label>Возраст</label>
    <input type="text" name="age" value="${param.age}">
    <br>
    <button type="submit" formaction="form1.jsp">Назад</button>
    <button type="submit" formaction="form3.jsp">Вперед</button>
    <button type="submit" formaction="form1.jsp">В начало</button>
</form>
<%@include file="/static/footer.jsp" %>