<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24.05.2017
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:include page="static/header.jsp"/>
  <br/>
  <a href="jsp/login.jsp">Авторизация</a>
  <br/>
  <a href="task_2/2task.jsp">Второе задание</a>
<br/>




  <form action="error.jsp">
    <input type="submit" value="CallError">
  </form>
  <br/>
  <br/>

  <jsp:include page="static/footer.jsp"/>

  </body>
</html>
