package br.edu.ifpr.biblioteca.controledebiblioteca.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name = "BookListarController", value = {"/BookListarController"})
public class BookListarController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("LOGOU E CHEGOU NA BOOKLISTARCONTROLLER");

    }

}