package br.edu.ifpr.biblioteca.controledebiblioteca.controllers;

import br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.Book;
import br.edu.ifpr.biblioteca.controledebiblioteca.services.BookService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListarController", value = {"/biblioteca"})
public class BookListarController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        } else {
            BookService bookService = new BookService();

            List<Book> books = bookService.findAll();

            request.setAttribute("attr_books", books);

            RequestDispatcher dispatcher = request.getRequestDispatcher("book-listar.jsp");

            dispatcher.forward(request, response);

        }
    }

}