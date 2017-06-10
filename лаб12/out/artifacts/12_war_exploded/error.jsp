<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<label>Произошла ошибка</label><br/>
${pageContext.errorData.statusCode}
<br> Текст ошибки
<br>
${pageContext.exception}
<br>
<form action="index.jsp">
    <input type="submit" value="В начало">
</form>
</body>
</html>