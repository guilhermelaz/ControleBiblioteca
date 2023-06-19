package br.edu.ifpr.biblioteca.controledebiblioteca.controllers;

import br.edu.ifpr.biblioteca.controledebiblioteca.repositories.BookRepository;
import br.edu.ifpr.biblioteca.controledebiblioteca.services.BookService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookExcluirController", value = {"/excluir"})
public class BookExcluirController extends HttpServlet {

    BookService bookService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        BookRepository bookRepository = new BookRepository();

        String id = request.getParameter("id");

        bookRepository.removeById(Integer.parseInt(id));

        response.sendRedirect("http://localhost:8080/biblioteca/");

    }
}
