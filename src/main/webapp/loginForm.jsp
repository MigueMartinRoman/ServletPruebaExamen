<%--
  Created by IntelliJ IDEA.
  User: Migue
  Date: 15/01/2024
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>LOGIN</h1>

${schools}
${hola}

<form method="post">
    <label>Username</label>
    <input type="text" name="user">

    <label>Password</label>
    <input type="password" name="passw">

    <label>Escola</label>
    <select name="escola">
        <c:forEach items="${schools}" var="esc">
            <option value="${esc.id}">${esc.nom}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Login">

</form>

</body>
</html>
