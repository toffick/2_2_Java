<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/static/header.jsp"></jsp:include>
<div>
    <h4>Задание 1</h4>
    <form action="TestServlet" method="get">
        <input type="submit" value="Выполнить"/>
    </form>
</div>
<div>
    <h4><a href="${pageContext.request.contextPath}/login">Войти</a></h4>

</div>
<jsp:include page="/static/footer.jsp"></jsp:include>

