package org.example;

public abstract class LibraryItem { // Classe Abstraite

    // ----- Propriétés -----

    private int id;
    private String title;
    private int publicationYear;

    // ----- Constructeur -----

    public LibraryItem(int id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // ----- Getters -----

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // ----- Méthodes -----

//    public String getDetails() {
//        return "ID : " + id + ", Titre : " + title + ", Année de publication : " + publicationYear;
//    }

    public abstract String getDetails();

}
