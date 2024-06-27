<%--
  Created by IntelliJ IDEA.
  User: ibrab
  Date: 27/06/2024
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <%@include file="layout/shared/topbar.jsp"%>
    <div class="container mt-3">
        <%
            if (session.getAttribute("user") != null) {
        %>
        <h2 class="text-success">Welcome, <%= session.getAttribute("user") %>!</h2>
        <%
            } else{
        %>
        <h2 class="text-capitalize text-info">Welcome to the dashboard</h2>
        <%
            }
        %>
        <div class="card">
            <div class="card-head p-3">
                <h2>Overview</h2>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-6 m-3">
                        <%@include file="utilisateurs/list.jsp"%>
                    </div>
                </div>
<%--                <div class="row">--%>
<%--                    <div class="col-6 m-3">--%>
<%--                        <h3>Autres contenus a venir</h3>--%>
<%--                        <p class="col-md-6">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa deserunt est fugiat incidunt rem unde vero? Blanditiis delectus dicta dolor id ipsam nam nulla pariatur placeat ratione ullam, veniam voluptatem.--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
</body>
</html>
