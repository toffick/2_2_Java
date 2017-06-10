<%--
  Created by IntelliJ IDEA.
  User: kleap
  Date: 21.05.2017
  Time: 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/static/header.jsp" %>
<form>
    <input type="hidden" name="myname" value="${param.myname}">
    <input type="hidden" name="age" value="${param.age}">
    <input type="hidden" name="city" value="${param.city}">
    <input type="hidden" name="bday" value="${param.bday}">
    <table>
        <tr>
            <td>Имя</td>
            <td>${param.myname}</td>
        </tr>

        <tr>
            <td>Возраст</td>
            <td>${param.age}</td>
        </tr>

        <tr>
            <td>Родной город</td>
            <td>${param.city}</td>
        </tr>

        <tr>
            <td>Дата рождения</td>
            <td>${param.bday}</td>
        </tr>
    </table>
    <button type="submit" formaction="form4.jsp"> назад</button>
    <button type="submit" formaction="success.jsp"> Домой</button>
</form>
<%@include file="/static/footer.jsp" %>
