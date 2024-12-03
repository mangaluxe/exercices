package org.example;

public class Book extends LibraryItem { // Sous-class (Héritée de LibraryItem)

    // ----- Propriétés -----

    private String author;
    private String genre;

    // ----- Constructeur -----

//    public Book(int id, String title, int publicationYear) {
//        super(id, title, publicationYear);
//    }

    public Book(int id, String title, int publicationYear, String author, String genre) {
        super(id, title, publicationYear);
        this.author = author;
        this.genre = genre;
    }

    // ----- Getters -----

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    // ----- Méthodes -----

    @Override
    public String getDetails() {
        return "Livre: [Titre : " + getTitle() + ", Author: " + author + ", Genre: " + genre + ", Year: " + getPublicationYear() + "]";
    }

}

