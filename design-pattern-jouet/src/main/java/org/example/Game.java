package org.example;

public class Game implements Toy {
    @Override
    public void enjoy() {
        System.out.println("Jeu pour jouer.");
    }

    @Override
    public String complet() {
        return "";
    }
}
