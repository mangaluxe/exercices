package org.example.Zoo2;

public class Mammal extends Animal {

    // ----- Propriétés -----

    // ----- Constructeur -----

    public Mammal(int id, String name, String species) {
        super(id, name, species);
    }

    // ----- Méthodes -----

    @Override
    public String getDetails() {
        return "ID: " + getId() + ", Nom: " + getName() + ", Espèce: " + getSpecies();
    }

    @Override
    public void eat() {
        System.out.println(getName() + " prend son repas.");
    }

}
