<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04.06.2017
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>XML Page</title>
</head>
<body>

<x:parse var = "output">
    <c:import url="../WEB-INF/books.xml"/>
</x:parse>
Название первой книги:<x:out select = "$output/books/book[1]/name" /><br>
Цена второй книги:<x:out select = "$output/books/book[2]/price" /><br>

<br/>
<x:forEach select = "$output/books/book/name" var = "item">
    Book Name: <x:out select = "$item" />
</x:forEach>



<br/>
<br/>
<a href="jstl_index.jsp">Назад </a>
</body>
</html>
