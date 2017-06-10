<%--
  Created by IntelliJ IDEA.
  User: kleap
  Date: 20.05.2017
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/static/header.jsp" %>
<label>Имя</label>
<form>
    <input type="text" name="myname" value="${param.myname}">
    <br>
    <button type="submit" formaction="success.jsp">Назад</button>
    <button type="submit" formaction="form2.jsp">Вперед</button>
    <button type="submit" formaction="form1.jsp">В начало</button>
</form>

<%@include file="/static/footer.jsp" %>
