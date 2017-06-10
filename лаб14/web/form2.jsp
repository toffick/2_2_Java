<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="static/header.jsp"/>


<br>
<div width="100">Имя ${param.Name} </div>
<div width="100">Фамилия  ${param.SecondName} </div>
<br>



<br>
Введите возраст<br/>
<form action="form3.jsp">
    <input type="hidden"  name="Name" value="${param.Name}" >
    <input type="hidden"  name="SecondName" value="${param.SecondName}" >

    <div width="100"> Возраст:</div> <input type="text" name="yearold" value="${param.yearold}">
    <br/>
    <input type="submit" value="Вперед"/>
</form>
<br/>
<form action="form1.jsp">
    <input type="hidden"  name="Name" value="${param.Name}" >
    <input type="hidden"  name="SecondName" value="${param.SecondName}" >
    <input type="submit" value="Назад">
</form>


<jsp:include page="static/footer.jsp"/>


</body>
</html>
