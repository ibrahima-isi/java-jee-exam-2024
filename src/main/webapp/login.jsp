<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h2>Login</h2>
<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>
<form action="login" method="post">
  <div class="form-group">
    <label for="email" class="form-label">Username:</label>
    <input type="text" name="username" id="email" required class="form-control">
  </div>
  <div class="form-group">
    <label for="password" class="form-label">Password:</label>
    <input id="password" type="password" class="form-control" name="password" required><br>
  </div>
  <input type="submit" value="Login" class="btn-primary btn">
</form>
</body>
</html>