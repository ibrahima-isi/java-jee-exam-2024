<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Liste des utilisateurs</h1>
<table class="center mb-3 table table-striped table-bordered">
<tr class="table-primary">
    <th>ID</th>
    <th>Nom</th>
    <th>Email</th>
    <th>Status</th>
    <th colspan="2">Action</th>
</tr>
<c:forEach items="${userModel.users}" var="u">
    <tr>
        <td>${u.userID}</td>
        <td>${u.userName}</td>
        <td>${u.userEmail}</td>
        <td>${u.status}</td>
        <td>
            <a href="/user/edit?id=${u.userID}" class="btn btn-outline-warning">Modifier</a>
            <a href="/user/details?id=${u.userID}" class="btn btn-outline-info">Voir</a>
            <a href="/user/delete?id=${u.userID}" class="btn btn-outline-danger">Supprimer</a>

        </td>
    </tr>
</c:forEach>