<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24.05.2017
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
Авторизоваться:<br/>
<body>
    <form method="post" action="${pageContext.request.contextPath}/Login">
        <div width="100"> Login:</div> <input type="text" name="login">
        <br/>
        <div width="100"> Password:</div> <input type="password" name="password">
        <br/>
        <input type="submit"/>
    </form>
    <br/>
 <a href="egistration.jsp">Зарегистрироваться</a>
</body>
</html>
