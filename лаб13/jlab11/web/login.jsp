<%--
  Created by IntelliJ IDEA.
  User: kleap
  Date: 18.05.2017
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="static/header.jsp"></jsp:include>

<div>
    <form action="/jlab11/login" method="post">
        <div>
            <label>Логин </label>
            <input type="text" name="loginbox"/>
        </div>
        <br>
        <div>
            <label>Пароль </label>
            <input type="password" name="passbox"/>
        </div>
        <hr>
        <input type="submit" value="войти">
    </form>
<p>Время предыдущего сеанса : ${worktime}</p>
</div>
<jsp:include page="static/footer.jsp"></jsp:include>

