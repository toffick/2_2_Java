<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24.05.2017
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
Регистрация:<br/>
<form method="post" action="${pageContext.request.contextPath}/Registration"  >
    <div width="100">Имя пользователя:</div> <input type="text" name="login"/><br/>
    <div width="100">Пароль:</div> <input type="password" name="password"/><br/>
<input type="submit" name="submit" value="Регистрация"/>
</form>

</body>
</html>
