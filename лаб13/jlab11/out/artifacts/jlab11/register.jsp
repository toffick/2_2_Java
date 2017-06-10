<%--
  Created by IntelliJ IDEA.
  User: kleap
  Date: 20.05.2017
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="static/header.jsp"></jsp:include>

<form action="/registration" method="post">
    <label>Login</label>
    <input type="text" name="login">
    <br>
    <label>Password</label>
    <input type="password" name="pass">
    <br>
    <label>Admin</label>
    <input type="checkbox">
    <br>
    <input type="submit" value="Регистрация">
</form>
<jsp:include page="static/footer.jsp"></jsp:include>

