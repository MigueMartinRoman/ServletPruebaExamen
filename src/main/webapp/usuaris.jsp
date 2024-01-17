<%--
  Created by IntelliJ IDEA.
  User: Migue
  Date: 17/01/2024
  Time: 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Usuaris</title>
<h1>Lista de usuarios</h1>
    <c:forEach items="${relacionusuarios}" var="f">

        <p>${f.username}</p>
        <p>${f.nom}</p>

    </c:forEach>
</head>
<body>

</body>
</html>
