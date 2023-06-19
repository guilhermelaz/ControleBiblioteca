package br.edu.ifpr.biblioteca.controledebiblioteca.repositories;

import br.edu.ifpr.biblioteca.controledebiblioteca.connection.ConnectionFactory;
import br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UserRepository {
    EntityManager entityManager;
    EntityTransaction transaction;
    private UserRepository userRepository;
    public UserRepository(){
        entityManager = ConnectionFactory.getConnection();
        transaction = entityManager.getTransaction();
    }

    public User create(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        return user;
    }

    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User update(User user) {
        entityManager.getTransaction().begin();
        user = entityManager.merge(user);
        entityManager.getTransaction().commit();

        return user;
    }

    public User findById(int id) {
        User user =  entityManager.find(User.class, id);
        return user;

    }

    public void remove(User user) {

        if (user == null) {
            throw new RuntimeException("Usuário não pode ser nulo");
        }

        transaction.begin();

        user = entityManager.find(User.class, user.getId());

        entityManager.remove(user);

        transaction.commit();
    }

    public void removeById(Integer id){

        transaction.begin();

        User user = entityManager.find(User.class, id);

        if (user == null) {
            throw new IllegalArgumentException("Não foi possível encontrar o usuário com o ID: " + id);
        }

        entityManager.remove(user);

        transaction.commit();
    }

    public User findByUser(String name){
        return entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
