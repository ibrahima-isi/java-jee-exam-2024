<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>Formulaire de modification utilisateur</h1>
<form action="/user/update" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <div class="form-group mt-3">
        <label for="id" class="form-label" >ID</label>
        <input type="text"  id="id" name="id" class="form-control" readonly value="${user.userID}">
    </div>
    <div class="form-group mt-3">
        <label for="name" class="form-label">Nom</label>
        <input type="text"  id="name" name="name" class="form-control" value="${user.userName}">
    </div>
    <div class="form-group mt-3">
        <label for="usermail" class="form-label">Email</label>
        <input type="text"  id="usermail" name="email" class="form-control" value="${user.userEmail}">
    </div>
    <div class="form-group mt-3">
        <label for="password" class="form-label">Mot de passe</label>
        <input type="text"  id="password" name="password" class="form-control">
    </div>
    <div class="form-group mt-3">
        <label for="profile" class="form-label">Profil</label>
        <select name="role_id" class="form-select" id="profile">
            <option value="" class="form-control">Selection un profile pour l'utilisateur</option>
            <c:forEach items="${roles}" var="r">
                <option value="${r.id}" class="form-control">${r.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group mt-3">
        <label for="status" class="form-label">Status</label>
        <select name="status" id="status" CLASS="form-select">
            <option value="" class="form-control">Selection un status pour l'utilisateur</option>
            <option value="true" class="form-control">ACTIF</option>
            <option value="false" class="form-control">INACTIF</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
</body>
</html>
