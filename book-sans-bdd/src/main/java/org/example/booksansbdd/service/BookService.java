package org.example.booksansbdd.service;

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
    public Book getBook(int id) {
        if (!books.containsKey(id)) {
            throw new RuntimeException("Livre introuvable avec id : " + id);
        }
        return books.get(id);
    }

    /**
     * Récupérer tous les livres
     */
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public void displayBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    // ----- Create -----

    public void addBook(Book book) {
        if (book.getId() == 0) { // Si l'ID n'est pas défini
            book.setId(nextId++);
        }

        System.out.println("Livre ajouté : " + book);

        books.put(book.getId(), book);
    }

    // ----- Update -----

    public void updateBook(int id, Book updatedBook) {
        if (!books.containsKey(id)) {
            throw new RuntimeException("Livre introuvable avec id : " + id);
        }

        Book book = books.get(id);
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
    }


    // ----- Delete -----

    public void deleteBook(int id) {
        if (!books.containsKey(id)) {
            throw new RuntimeException("Livre introuvable avec id  : " + id);
        }
        books.remove(id);
    }

}
