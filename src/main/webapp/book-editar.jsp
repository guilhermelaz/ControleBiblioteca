<%@ page import="br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.Book" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: jackson
  Date: 11/06/2023
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Book book = (Book) request.getAttribute("book");
%>
<html>
<head>
    <title>Editar</title>
</head>
<body>
<form method="post" action="editar">

    <input type="text" name="id" value="<%= book.getId() %>"/>
    <input type="text" name="nome" value="<%= book.getNome() %>"/>
    <input type="text" name="autor" value="<%= book.getAutor() %>"/>
    <input type="text" name="date" value="<%= book.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %>"/>
    <button> Salvar </button>
</form>

</body>
</html>

