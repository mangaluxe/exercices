package org.example;

import java.time.LocalDate;

class Livre {

    // ----- Propriétés -----

    private String titre;
    private String auteur;
    private String genre;
    private LocalDate datePublication;
    private int nbPages;
    private boolean estDisponible;
    private double prix;

    // ----- Constructeur -----

    public Livre(String titre, String auteur, String genre, LocalDate datePublication, int nbPages, boolean estDisponible, double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.datePublication = datePublication;
        this.nbPages = nbPages;
        this.estDisponible = estDisponible;
        this.prix = prix;
    }

    // ------ Getters -----

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public int getNbPages() {
        return nbPages;
    }

    public boolean getEstDisponible() {
        return estDisponible;
    }

    public double getPrix() {
        return prix;
    }

    // ------ Méthodes -----

    @Override
    public String toString() {
        return "Livre [Titre : " + titre + ", Auteur : " + auteur + ", Genre : " + genre + ", Date publication : " + datePublication + ", Nb pages : " + nbPages + ", est disponible : " + estDisponible + ", Prix : " + prix + ']';
    }

}