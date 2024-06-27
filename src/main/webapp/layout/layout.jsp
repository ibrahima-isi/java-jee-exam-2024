<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${title}" /></title>
    <%@include file="shared/head.jsp"%>
</head>
<body>
<%@include file="shared/topbar.jsp"%>
<%
System.out.println(request.getAttribute("content"));
%>
<div>
    <!-- Contenu de la page -->
    <jsp:include page="${content}" />
    <c:out value="${content}" />
</div>
<%@include file="shared/footer.jsp"%>
</body>
</html>
