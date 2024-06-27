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
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
</head>
<body>
    <h1>Formulaire d'ajout utilisateur</h1>
    <form action="${pageContext.request.contextPath}/user/store" method="post" >
        <div class="form-group mt-3">
            <label for="name" class="form-label">Nom</label>
            <input type="text"  id="name" name="name" class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="usermail" class="form-label">Email</label>
            <input type="text"  id="usermail" name="email" class="form-control">
        </div>
        <div class="form-group mt-3">
            <label for="password" class="form-label">Mot de passe</label>
            <input type="text"  id="password" name="password" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</body>
</html>
