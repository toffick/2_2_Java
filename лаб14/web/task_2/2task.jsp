<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 25.05.2017
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/OneServlet" method="get">
<input type="submit" value="Первый сервлет get"/>
</form>
<br/>
<form action="${pageContext.request.contextPath}/OneServlet" method="post">
    <input type="submit" value="Первый сервлет post"/>
<br/>
</form>

<form action="${pageContext.request.contextPath}/First" method="get">
        <input type="text" name="name">
        <input type="submit" value="Отправить">
    </form>
    <a href="index.jsp">Вернуться на страницу входа</a>
</body>
</html>
