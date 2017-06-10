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
<div width="100">Возраст  ${param.yearold} </div>

<br>



<br>
Введите цвет кожи<br/>
<form action="AddInfoj">
    <input type="hidden"  name="yearold" value="${param.yearold}" >
    <input type="hidden"  name="Name" value="${param.Name}" >
    <input type="hidden"  name="SecondName" value="${param.SecondName}" >
    <div width="100"> Цвет кожи:</div> <input type="text" name="skincolor" value="${param.skincolor}">
    <br/>
    <input type="submit" value="Вперед"/>
</form>
<br/>
<form action="form2.jsp">
    <input type="hidden"  name="yearold" value="${param.yearold}" >
    <input type="hidden"  name="Name" value="${param.Name}" >
    <input type="hidden"  name="SecondName" value="${param.SecondName}" >
    <input type="submit" value="Назад">
</form>


<jsp:include page="static/footer.jsp"/>


</body>
</html>


