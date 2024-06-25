<%--
  Created by IntelliJ IDEA.
  User: ibrab
  Date: 25/06/2024
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404 Not Found</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>404 Not Found</h1>
    <p>La ressource demandée n'a pas été trouvée sur ce serveur.</p>
    <p>Chemin : ${requestScope.path}</p>
    <a href="${pageContext.request.contextPath}/">Retour à la liste des appartements</a>
</div>
</body>
</html>

