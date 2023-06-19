package br.edu.ifpr.biblioteca.controledebiblioteca.domain.models;

import br.edu.ifpr.biblioteca.controledebiblioteca.domain.enums.BookStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Book {

    public Book() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String autor;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(nome, book.nome) && Objects.equals(autor, book.autor) && Objects.equals(date, book.date) && status == book.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, autor, date, status);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
