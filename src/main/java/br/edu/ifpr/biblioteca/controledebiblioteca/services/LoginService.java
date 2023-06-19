package br.edu.ifpr.biblioteca.controledebiblioteca.services;

import br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.User;
import br.edu.ifpr.biblioteca.controledebiblioteca.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    public void validateLogin(String user, String password, HttpServletRequest request) throws Exception {

        if(user == null || user.isEmpty()){
            throw new Exception("Usuário inválido");
        }

        if(password == null || password.isEmpty()){
            throw new Exception("Senha inválida");
        }

        UserRepository userRepository = new UserRepository();
        User u = userRepository.findByUser(user);
        System.out.println("TESTANDO lOGINsERVICE ANTES DO IF" + user + password );
        System.out.println(u.getName() + u.getId());


        if (user.equals("admin") && password.equals("admin")){
            System.out.println("TESTANDO lOGINsERVICE" + user);
            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("user", user);

        } else {
            throw new Exception("usuário ou senha incorreto");
        }


    }

}
