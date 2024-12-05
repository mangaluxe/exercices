package org.example;

public class Writer implements Observer {

    // ----- Propriétés -----

    private String message;

    // ----- Constructeur -----

    public Writer(String message) {
        this.message = message;
    }

    // ----- Méthodes -----

    @Override
    public void update(String message) {
        System.out.println("Ecriture dans un fichier : " + message + ". Notification envoyée !");
    }
}
