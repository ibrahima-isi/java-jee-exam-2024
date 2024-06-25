<%--
  Created by IntelliJ IDEA.
  User: ibrab
  Date: 24/06/2024
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apartment-list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <%@include file="/layout/shared/topbar.jsp"%>
    <h1>Hello Apartments</h1>
    <p>${pageContext.request.contextPath}</p>
</body>
</html>
