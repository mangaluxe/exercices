package org.example.ex23;


public class Article {

    // ----- Propriétés -----

    private String id;
    private String nom;
    private double price;

    // ----- Constructeur -----

    public Article(String id, String nom, double price) {
        this.id = id;
        this.nom = nom;
        this.price = price;
    }

    // ----- Getters/Setters -----

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // ----- Méthodes -----

    @Override
    public String toString() {
        return "Article [id : " + id + ", nom : " + nom + ", prix : " + price + "]";
    }

}

