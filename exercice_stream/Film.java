package org.example;

import java.time.LocalDate;

class Film {

    // ----- Propriétés -----

    private String titre;
    private LocalDate dateSortie;
    private String realisateur;
    private String genre;
    private long nombreEntrees;

    // ----- Constructeur -----

    public Film(String titre, LocalDate dateSortie, String realisateur, String genre, long nombreEntrees) {
        this.titre = titre;
        this.dateSortie = dateSortie;
        this.realisateur = realisateur;
        this.genre = genre;
        this.nombreEntrees = nombreEntrees;
    }

    // ----- Getters -----

    public String getTitre() {
        return titre;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public String getGenre() {
        return genre;
    }

    public long getNombreEntrees() {
        return nombreEntrees;
    }

    // ----- Méthodes -----

    @Override
    public String toString() {
        return "Film [Titre : " + titre + ", Date : " + dateSortie + ", Réalisateur : " + realisateur + ", Genre : " + genre + ", Nb entrées : " + nombreEntrees + "]";
    }
}