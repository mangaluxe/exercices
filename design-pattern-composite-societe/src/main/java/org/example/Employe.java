package org.example;

public class Employe implements Employee {

    // ----- Propriétés -----

    private String name;

    // ----- Constructeur -----

    public Employe(String name) {
        this.name = name;
    }

    // ----- Méthodes -----

    @Override
    public void showDetails() {
        System.out.println("Nom de l'employé : " + name);
    }

}
