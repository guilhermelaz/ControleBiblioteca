package br.edu.ifpr.biblioteca.controledebiblioteca.repositories;

import br.edu.ifpr.biblioteca.controledebiblioteca.connection.ConnectionFactory;
import br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class BookRepository {
    EntityManager entityManager;
    private EntityTransaction transaction;

    BookRepository bookRepository;
    public BookRepository(){
        entityManager = ConnectionFactory.getConnection();
        transaction = entityManager.getTransaction();
    }

    public Book create(Book book){
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        return book;
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public Book update(Book book) {
        entityManager.getTransaction().begin();
        book = entityManager.merge(book);
        entityManager.getTransaction().commit();

        return book;
    }

    public Book findById(int id) {
        Book book =  entityManager.find(Book.class, id);
        return book;

    }

    public void remove(Book book) {

        if (book == null) {
            throw new RuntimeException("Livro não pode ser nulo");
        }

        transaction.begin();

        book = entityManager.find(Book.class, book.getId());

        entityManager.remove(book);

        transaction.commit();
    }

    public void removeById(Integer id){

        transaction.begin();

        Book book = entityManager.find(Book.class, id);

        if (book == null) {
            throw new IllegalArgumentException("Não foi possível encontrar o livro com o ID: " + id);
        }

        entityManager.remove(book);

        transaction.commit();
    }

}
