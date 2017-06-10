<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24.05.2017
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
 Время входа   ${time}
<br/>
 Время работы сессии ${pageContext.session.maxInactiveInterval}
 <br/>
 <br/>
 //cookie
 <br/>
Последнее обращение обращения ${cookie.time.value}
<br/>
Кол-во обращений ${cookie.count.value}
<br/>
Тип пользователя ${cookie.type.value}
<br/>
<br/>

 <form action="../form1.jsp">
  <input type="submit" value="Добавить информацию">
 </form>

 <a href="login.jsp">Вернуться на страницу входа</a>

</body>
</html>
