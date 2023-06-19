<%@ page import="br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Book> books = (List<Book>) request.getAttribute("attr_books");
%>

<html>
<head>
    <title></title>
</head>
<body>


<button>
    <a href="/biblioteca/cadastrar" >Novo</a>
</button>

<button>
    <a href="/biblioteca/usuarios" >Usuários</a>
</button>

    <table>
        <tr>
            <td>#Id</td>
            <td>Nome</td>
            <td>Autor</td>
            <td>Data</td>
            <td>Status</td>
            <td>Opções</td>
        </tr>
        <% for(Book b: books){ %>

            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getNome() %></td>
                <td><%= b.getAutor() %></td>
                <td><%= b.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %></td>
                <td><%= b.getStatus() %></td>

                <td>
                    <a href="/biblioteca/editar?id=<%= b.getId() %>" method="get" >Editar</a>
                </td>

                <td>
                    <a href="/biblioteca/excluir?id=<%= b.getId()%>" >Excluir</a>
                </td>
            </tr>

        <% } %>

    </table>

</body>
</html>
