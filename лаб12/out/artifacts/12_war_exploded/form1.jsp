<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form1</title>
</head>
<body>
<jsp:include page="static/header.jsp"/>
<br>
Введите имя и фамилию<br/>
    <form action="form2.jsp">
        <div width="100"> Имя:</div> <input type="text" name="Name" value="${param.Name}">
        <br/>
        <div width="100"> Фамилия:</div> <input type="text" name="SecondName" value="${param.SecondName}">
        <br/>
        <input type="submit" value="Вперед"/>
    </form>
<br/>
<form action="jsp/login.jsp">
    <input type="submit" value="Назад">
</form>
<br/>
<jsp:include page="static/footer.jsp"/>
</body>
</html>
