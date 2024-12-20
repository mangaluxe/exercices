package org.example.ex23;

import java.time.LocalDateTime;

public class Commande {

    // ----- Propriétés -----

    private String id;
    private Utilisateur utilisateur;
    private Panier panier;
    private double total;
    private LocalDateTime date;
    private String status;

    // ----- Constructeur -----

    public Commande(String id, Utilisateur utilisateur, Panier panier, double total, LocalDateTime date, String status) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.panier = panier;
        this.total = total;
        this.date = date;
        this.status = status;
    }

    // ----- Getters/Setters -----

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ----- Méthodes -----

    @Override
    public String toString() {
        return "Commande [id : " + id + ", utilisateur : " + utilisateur + ", panier : " + panier + ", total=" + total + ", date=" + date + ", status : " + status + ']';
    }

}
