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
        LoginService service = new LoginService();
        System.out.println("TESTANDO LOGINCONTROLLER" + user + password);

        try {

            service.validateLogin(user, password, req);
            User usuario = (User) req.getSession().getAttribute("user");
            usuario.getName();
            System.out.println(usuario.getName());


        } catch (Exception e) {
            req.getRequestDispatcher("/index.jsp");
            System.out.println("TESTANDO CATCH LINHA 33" + user + password);
        }

        if(req.getSession().getAttribute("user") != null){
            resp.sendRedirect("/biblioteca");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession(false);


        session.setAttribute("is_logged_in", false);
        session.invalidate();


        resp.sendRedirect("/login");

    }
}
