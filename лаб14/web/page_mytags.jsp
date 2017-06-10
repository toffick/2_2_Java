<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04.06.2017
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="m" uri="MyTags.tld" %>

<html>
<head>
    <title>My tags page</title>
</head>
<body>


<form action="result.jsp" method="post">
    <m:BNILabledTextField label="Firstname" name="First"/><br/>
    <m:BNILabledTextField label="Secondname" name="Second"/><br/>
    <m:BNILabledTextField label="Thirdname" name="Third"/><br/>
    <m:BNILabledTextField label="City" name="city"/><br/>
    <m:BNILabledTextField label="Street" name="street"/><br/>
    <m:BNIsubmit></m:BNIsubmit>
</form>



<br/>
<br/>
<a href="jstl/jstl_index.jsp">Назад </a>

</body>
</html>
