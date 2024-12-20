package org.example.ex23;


public class Utilisateur {

    // ----- Propriétés -----

    private String id;
    private String nom;
    private Panier panier;

    // ----- Constructeur -----

    public Utilisateur(String id, String nom) {
        this.id = id;
        this.nom = nom;
        this.panier = new Panier();
    }

   // ----- Getters/Setters -----

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    // ----- Méthodes -----

    @Override
    public String toString() {
        return "Utilisateur [id : " + id + ", nom : " + nom + ", panier : " + panier + "]";
    }
}
