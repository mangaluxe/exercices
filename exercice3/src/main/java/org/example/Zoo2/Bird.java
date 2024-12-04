package org.example.Zoo2;

public class Bird extends Animal {

    // ----- Propriétés -----

    // ----- Constructeur -----

    public Bird(int id, String name, String species) {
        super(id, name, species);
    }

    // ----- Méthodes -----

    @Override
    public String getDetails() {
        return "";
    }

    @Override
    public void eat() {
        System.out.println(getName() + " mange des graines.");
    }

}