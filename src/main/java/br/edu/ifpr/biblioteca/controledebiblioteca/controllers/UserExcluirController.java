package br.edu.ifpr.biblioteca.controledebiblioteca.controllers;

import br.edu.ifpr.biblioteca.controledebiblioteca.repositories.UserRepository;
import br.edu.ifpr.biblioteca.controledebiblioteca.services.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserExcluirController", value = {"/userexcluir"})
public class UserExcluirController extends HttpServlet {

    UserService userService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    UserRepository userRepository = new UserRepository();

    String id = request.getParameter("id");

    userRepository.removeById(Integer.parseInt(id));
    response.sendRedirect("http://localhost:8080/biblioteca");
    }
}
