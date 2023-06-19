package br.edu.ifpr.biblioteca.controledebiblioteca.services;

import br.edu.ifpr.biblioteca.controledebiblioteca.domain.enums.BookStatus;
import br.edu.ifpr.biblioteca.controledebiblioteca.domain.models.Book;
import br.edu.ifpr.biblioteca.controledebiblioteca.repositories.BookRepository;
import jakarta.servlet.ServletException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;
    public BookService(){
        bookRepository = new BookRepository();
    }

    public Book create(String nome, String autor, String data){


        if(nome.isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if(autor.isEmpty()){
            throw new IllegalArgumentException("Autor não pode ser vazio");
        }

        Book book = new Book();
        book.setNome(nome);
        book.setAutor(autor);
        book.setStatus(BookStatus.DISPONIVEL);
        book.setDate(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        bookRepository.create(book);

        return book;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(int id) {return bookRepository.findById(id);}

    public Book remove(int id){
        Book book = bookRepository.findById(id);

        if (book == null) {
            throw new IllegalArgumentException("Livro inválido");
        }

        bookRepository.remove(book);

        return book;
    }

    public void update(Book updatedBook) {
        String id = String.valueOf(updatedBook.getId());
        String nome = updatedBook.getNome();
        String autor = updatedBook.getAutor();
        String date = updatedBook.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        if (id.isEmpty()) {
            throw new IllegalArgumentException("ID não pode ser vazio");
        }

        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (autor.isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser vazio");
        }

        Book book = bookRepository.findById(Integer.parseInt(id));
        if (book == null) {
            throw new IllegalArgumentException("Livro não encontrado");
        }

        book.setNome(nome);
        book.setAutor(autor);
        book.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        bookRepository.update(book);
    }

}
