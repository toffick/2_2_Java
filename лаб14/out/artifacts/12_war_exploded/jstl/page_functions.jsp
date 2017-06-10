<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04.06.2017
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Functions page</title>
</head>
<body>


<c:set var = "theString" value = "I am a test String 123"/>

<c:if test = "${fn:contains(theString, 'test')}">
    Found test string<br/>
</c:if>
<c:if test = "${fn:contains(theString, 'TEST')}">
    Found TEST string<br/>
</c:if>
<c:if test = "${fn:containsIgnoreCase(theString, 'TEST')}">
    Found TEST string<br/>
</c:if>
<c:if test = "${fn:endsWith(theString, '123')}">
    String ends with 123<br/>
</c:if>
<c:if test = "${fn:endsWith(theString, 'TEST')}">
    String ends with TEST<br/>
</c:if>

<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "This is ololo second String."/>
Index (first) "This is first String." : ${fn:indexOf(string1, "first")}<br/>
Index (second)  "This is ololo second String.": ${fn:indexOf(string2, "second")}<br/>

<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:split(string1, ' ')}" />
<c:set var = "string3" value = "${fn:join(string2, '-')}" />
Final String : ${string3}<br/>

<c:set var = "string1" value = "This is first String."/>
Length of String (1) : ${fn:length(string1)}<br/>

<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:replace(string1, 'first', 'second')}" />
Final String : ${string2}<br/>


<br/>
<br/>
<a href="jstl_index.jsp">Назад </a>
</body>
</html>
