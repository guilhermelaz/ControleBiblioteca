package br.edu.ifpr.biblioteca.controledebiblioteca.services;

import br.edu.ifpr.biblioteca.controledebiblioteca.domain.enums.UserType;
import br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.User;
import br.edu.ifpr.biblioteca.controledebiblioteca.repositories.UserRepository;

import java.util.List;


public class UserService {
    private final UserRepository userRepository;
    public UserService() {
        userRepository = new UserRepository();
    }

    public User create(String name, String email, String password) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if(email.isEmpty()){
            throw new IllegalArgumentException("Email não pode ser vazio");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        //user.setType(UserType.Usuario);
        user.setPassword(password);

        userRepository.create(user);

        return user;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int id) {return userRepository.findById(id);}

    public User remove(int id){
        User user = userRepository.findById(id);

        if (user == null) {
            throw new IllegalArgumentException("Usuário inválido");
        }

        userRepository.remove(user);

        return user;
    }

    public void update(User updatedUser) {
        String id = String.valueOf(updatedUser.getId());
        String name = updatedUser.getName();
        String email = updatedUser.getEmail();

        if (id.isEmpty()) {
            throw new IllegalArgumentException("ID não pode ser vazio");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }

        User user = userRepository.findById(Integer.parseInt(id));
        if (user == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        user.setName(name);
        user.setEmail(email);
        userRepository.update(user);
    }

}
