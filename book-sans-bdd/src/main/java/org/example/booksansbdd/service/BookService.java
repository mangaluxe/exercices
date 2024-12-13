package org.example.booksansbdd.service;

import org.example.booksansbdd.annotation.ExceptionHandler;
import org.example.booksansbdd.annotation.Log;
import org.example.booksansbdd.annotation.Performance;
import org.example.booksansbdd.entity.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class BookService {

    // ========== Propriétés ==========

    // private final List<String> books = new ArrayList<>(); // Si on utilise uniquement le nom du livre (sans id, ni l'auteur)
    private final Map<Integer, Book> books = new HashMap<>();
    private int nextId = 1;


    // ========== Méthodes ==========

    // ----- Read -----

    /**
     * Récupérer un livre par ID
     */
    @ExceptionHandler
    @Log
    @Performance
    public Book getBook(int id) {
        if (!books.containsKey(id)) {
            throw new RuntimeException("Livre introuvable avec id : " + id);
        }
        return books.get(id);
    }

    /**
     * Récupérer tous les livres
     */
    @ExceptionHandler
    @Log
    @Performance
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    // ----- Create -----

    @ExceptionHandler
    @Log
    @Performance
    public void addBook(Book book) {
        if (book.getId() == 0) { // Vérifie si l'ID n'est pas défini
            book.setId(nextId++);
        }

        System.out.println("Livre ajouté : " + book);

        books.put(book.getId(), book);
    }

    // ----- Update -----

    @ExceptionHandler
    @Log
    @Performance
    public void updateBook(int id, Book updatedBook) {
        if (!books.containsKey(id)) {
            throw new RuntimeException("Livre introuvable avec id : " + id);
        }

        Book book = books.get(id);
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
    }


    // ----- Delete -----

    @ExceptionHandler
    @Log
    @Performance
    public void deleteBook(int id) {
        if (!books.containsKey(id)) {
            throw new RuntimeException("Livre introuvable avec id  : " + id);
        }
        books.remove(id);
    }

}
