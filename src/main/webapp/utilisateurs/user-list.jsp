<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Définition des attributs pour le template --%>
<c:set var="title" value="Utilisateur | List" scope="request"/>
<c:set var="content" value="/utilisateurs/list.jsp" scope="request"/>

<%-- Inclusion du template principal --%>
<jsp:include page="/layout/layout.jsp" />