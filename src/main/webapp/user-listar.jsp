<%@ page import="br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<User> users = (List<User>) request.getAttribute("attr_users");
%>

<html>
<head>
    <title>Usuários</title>
</head>
<body>


<button>
    <a href="/biblioteca/usercadastrar" >Novo</a>
</button>

<table>
    <tr>
        <td>#Id</td>
        <td>Nome</td>
        <td>Email</td>
        <td>Tipo</td>
        <td>Opções</td>
    </tr>
    <% for(User u: users){ %>

    <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getName() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getType() %></td>

        <td>
            <a href="/biblioteca/usereditar?id=<%= u.getId() %>" method="get" >Editar</a>
        </td>

        <td>
            <a href="/biblioteca/userexcluir?id=<%= u.getId()%>" >Excluir</a>
        </td>
    </tr>

    <% } %>

</table>

</body>

</html>