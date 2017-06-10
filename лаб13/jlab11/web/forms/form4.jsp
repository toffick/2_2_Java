<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/header.jsp" %>
<form>
    <input type="hidden" name="myname" value="${param.myname}">
    <input type="hidden" name="age" value="${param.age}">
    <input type="hidden" name="city" value="${param.city}">

    <p> ваше имя : ${param.myname}</p>
    <p> ваш возраст : ${param.age}</p>
    <p> родной город : ${param.city}</p>
    <label>Ваша дата рожления</label>
    <input type="date" name="bday" value="${param.bday}">
    <br>
    <button type="submit" formaction="form3.jsp">Назад</button>
    <button type="submit" disabled formaction="form4.jsp">Вперед</button>
    <button type="submit" formaction="form1.jsp">В начало</button>
    <button type="submit" formaction="results.jsp">Результаты</button>

</form>
<%@include file="/static/footer.jsp" %>