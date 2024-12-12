package org.example.booksansbdd.entity;

/*
Ordre pour créer et structurer un projet Spring Boot :

- Configurer pom.xml
- Créer les fichiers :
1. entity
2. service
3. controller (API REST)

- Tester l'application avec Endpoints
*/

public class Book {

    // ========== Propriétés ==========

    private int id;
    private String title;
    private String author;

    // ========== Constructeur ==========

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // ========== Getters/Setters ==========

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // ========== Méthodes ==========

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "'}";
    }

}
