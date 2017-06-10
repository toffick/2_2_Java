<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04.06.2017
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
    <title>Page sql</title>
</head>
<body>


<s:setDataSource var = "snapshot" driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
                 url = "jdbc:sqlserver://DESKTOP-FFV5E68\SQLEXPRESS"
                 user = "toffi_java_14" password = "123456789"/>


<s:query dataSource = "${snapshot}" var = "result">
    use java_14
    select * from koko
</s:query>

До добавления
<table border = "1" width = "30%">
    <tr>
        <th width="30">Old</th>
        <th width="30">Name</th>
    </tr>

    <c:forEach var = "row" items = "${result.rows}">
        <tr>
            <td> <c:out value = "${row.old}"/></td>
            <td> <c:out value = "${row.name}"/></td>
        </tr>
    </c:forEach>
</table>


<s:update dataSource = "${snapshot}" var = "result">
    use java_14
    insert into koko values
    (333, 'kokonamenew')
</s:update>


<s:query dataSource = "${snapshot}" var = "result">
    use java_14
    select * from koko
</s:query>

Добавили
<table border = "1" width = "30%">
    <tr>
        <th width="30">Old</th>
        <th width="30">Name</th>
    </tr>

    <c:forEach var = "row" items = "${result.rows}">
        <tr>
            <td> <c:out value = "${row.old}"/></td>
            <td> <c:out value = "${row.name}"/></td>
        </tr>
    </c:forEach>
</table>



<c:set var = "age" value = "333"/>

<s:update dataSource = "${snapshot}" var = "count">
    use java_14
    DELETE FROM koko WHERE old = ?
    <s:param value = "${age}" />
</s:update>
После удаления
<s:query dataSource = "${snapshot}" var = "result">
    use java_14
    select * from koko
</s:query>

Удалили
<table border = "1" width = "30%">
    <tr>
        <th width="30">Old</th>
        <th width="30">Name</th>
    </tr>

    <c:forEach var = "row" items = "${result.rows}">
        <tr>
            <td> <c:out value = "${row.old}"/></td>
            <td> <c:out value = "${row.name}"/></td>
        </tr>
    </c:forEach>
</table>


<br/>
<br/>
<a href="jstl_index.jsp">Назад </a>
</body>
</html>
