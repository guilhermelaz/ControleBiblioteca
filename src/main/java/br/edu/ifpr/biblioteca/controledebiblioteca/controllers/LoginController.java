package br.edu.ifpr.biblioteca.controledebiblioteca.controllers;

import br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.User;
import br.edu.ifpr.biblioteca.controledebiblioteca.services.LoginService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", value = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String user = req.getParameter("field_user");
        String password = req.getParameter("field_password");
        LoginService loginService = new LoginService();
        System.out.println("Usuario: " + user + " senha: " + password);


        try{
            loginService.validateLogin(user, password, req);
            resp.sendRedirect("http://localhost:8080//ControleDeBiblioteca/BookListarController");

        } catch (Exception e) {
            String msg = e.getMessage();
            resp.sendRedirect("http://localhost:8080//ControleDeBiblioteca/index.jsp?msg=" + msg);
        }


    }


}
