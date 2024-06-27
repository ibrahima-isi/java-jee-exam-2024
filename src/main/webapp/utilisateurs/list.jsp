<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Définition des attributs pour le template --%>
<%
    request.setAttribute("title", "Utilisateur | List");
    request.setAttribute("content", "/utilisateurs/form.jsp");
%>

<%-- Inclusion du template principal --%>
<jsp:include page="/layout/layout.jsp" />
