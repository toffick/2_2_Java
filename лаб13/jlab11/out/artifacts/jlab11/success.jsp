<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.DateFormatSymbols" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: kleap
  Date: 18.05.2017
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="static/header.jsp"></jsp:include>
<a href="index.jsp">Начало</a>
<center><h2 style="color: limegreen">Успех!!!!!!!!!!</h2></center>
<div style="border: 2px solid grey; padding: 20px; margin: 20px">
    <h3><%
        if (new Date().getHours() < 18 && new Date().getHours() > 6) {
                out.println("Добрый день!");
        } else {
                out.println("Добрый вечер");
        }
    %></h3>
    <p>Текущий день недели: <%!
        Locale usersLocale = Locale.getDefault();
        DateFormatSymbols dfs = new DateFormatSymbols(usersLocale);
        String weekdays[] = dfs.getWeekdays();
        Date date = new Date();
    %> <%
        out.print(weekdays[date.getDay()]);%></p>
</div>
<p> ${name}, вы успешно авторизировались в <%out.print(date.toString());%></p>
<p> Ваша роль - ${role}</p>
<p> Количество подключений : ${cookie["count"].value}</p>
<p> Время последнего входа : ${cookie["date"].value}</p>
<h4><a href="${pageContext.request.contextPath}/redefinition?first=First task">Задание 2.1</a></h4>
<form action="/jlab11/redefinition" method="post">
    <input type="text" name="second">
    <input type="submit" value="Задание 2.2">
    <br>
</form>
<form action="/jlab11/redefinition" method="get">
    <input type="text" name="third">
    <input type="submit" value="Задание 2.3">
    <br>
</form>
<form action="/jlab11/redefinition" method="get">
    <input type="text" name="fourth">
    <input type="submit" value="Задание 2.4">
    <br>
</form>
<form action="/jlab11/redefinition" method="get">
    <input type="text" name="five">
    <input type="submit" value="Задание 2.5">
    <br>
</form>
<p><a href="/jlab11/login?logout=true">Выйти</a></p>
<a href="asdasd" > Генерация ошибки</a>
<a href="forms/form1.jsp">Начать опрос</a>
<jsp:include page="static/footer.jsp"></jsp:include>
