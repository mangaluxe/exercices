package org.example.booksansbdd.controller;

import org.example.booksansbdd.entity.Book;
import org.example.booksansbdd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/books")
public class BookController {

    // ========== Propriétés/Constructeur ==========

    @Autowired
    private BookService bookService;


    // ========== Méthodes ==========

    // ----- Read -----

    /**
     * Récupérer tous les livres
     */
    @GetMapping
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Récupérer un livre par ID
     */
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    // ----- Create -----

    @PostMapping
    public void addBook(@RequestBody Book book) {
        System.out.println("Livre ajouté : " + book);

        bookService.addBook(book);
    }

    // ----- Update -----

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
    }

    // ----- Delete -----

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

}
