<%@ page import="br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.User" %><%--
  Created by IntelliJ IDEA.
  User: jackson
  Date: 18/06/2023
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>Editar</title>
</head>
<body>
<form method="post" action="usereditar">

    <input type="text" name="id" value="<%= user.getId() %>"/>
    <input type="text" name="name" value="<%= user.getName() %>"/>
    <input type="text" name="email" value="<%= user.getEmail() %>"/>
    <button> Salvar </button>
</form>

</body>
</html>
