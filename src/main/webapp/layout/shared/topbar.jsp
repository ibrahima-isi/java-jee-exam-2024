<nav class="navbar navbar-expand-lg navbar-dark bg-success p-3">
    <a href="#" class="navbar-brand">PRODUCT APP</a>
    <div class="navbar-nav me-auto">
        <a class="nav-item nav-link" href="#">Ajouter un produit</a>
        <a class="nav-item nav-link" href="#">Liste des produits</a>
    </div>
    <div class="navbar-nav ms-auto">
<%--        <span class="nav-item navbar-dark"><%= if(session.getAttribute("user") != null) %>!</span>--%>
<%--        <span class="nav-item nav-link"><a href="logout">Se deconnecter</a></span>--%>
        <%
            Object user = session.getAttribute("user");
            if (user != null) {
        %>
        <div class="nav-item nav-link"><%= user %></div>
        <a class="nav-item nav-link" href="logout">Se déconnecter</a>
        <%
        } else {
        %>
        <a class="nav-item nav-link" href="login">Se connecter</a>
        <%
            }
        %>
    </div>
</nav>
