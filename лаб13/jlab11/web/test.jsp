<%--
  Created by IntelliJ IDEA.
  User: kleap
  Date: 17.05.2017
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="static/header.jsp"></jsp:include>

<div>
    <a href="${pageContext.request.contextPath}/">Назад</a>
    <p> Текущее время :<b>${date}</b></p>
    <p> Протокола : <b>${protocol}</b> </p>
    <p> IP клиента : <b>${ip}</b></p>
    <p> Имя клиента : <b>${name}</b></p>
    <p> Имя метода : <b>${method}</b></p>
    <p> Url : <b>${url}</b></p>
</div>
<div>
    <h4>Заголовки запроса</h4>
    <div>
        ${headers}
    </div>
</div>
<jsp:include page="static/footer.jsp"></jsp:include>

