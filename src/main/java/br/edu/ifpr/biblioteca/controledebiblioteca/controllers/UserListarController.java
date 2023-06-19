package br.edu.ifpr.biblioteca.controledebiblioteca.controllers;

import br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.User;
import br.edu.ifpr.biblioteca.controledebiblioteca.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListarController", value = {"/usuarios"})
public class UserListarController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UserService userService = new UserService();
        List<User> users = userService.findAll();

        request.setAttribute("attr_users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user-listar.jsp");

        dispatcher.forward(request, response);


    }

}