package org.example.ex2;

public class Produit {

    // ----- Propriétés -----

    private String nom;
    private float prix;
    private int quantite;

    // ----- Constructeur -----

    public Produit(String nom, float prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    // ----- Méthodes -----

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
