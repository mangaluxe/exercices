package org.example;

public class Messenger implements Observer {

    // ----- Propriétés -----

    private String message;

    // ----- Constructeur -----

    public Messenger(String message) {
        this.message = message;
    }

    // ----- Méthodes -----

    @Override
    public void update(String message) {
        System.out.println("Affichage message : " + message + ". Notification envoyée !");
    }
}
