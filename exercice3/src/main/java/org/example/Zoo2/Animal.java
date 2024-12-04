package org.example.Zoo2;

public abstract class Animal {

    // ----- Propriétés -----

    private int id;
    private String name;
    private String species;

    // ----- Constructeur -----

    public Animal(int id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    // ----- Getters -----

    public int getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    // ----- Méthodes -----

//    public String getDetails() {
//        return "ID: " + id + ", Nom: " + name + ", Espèce: " + species;
//    }
    public abstract String getDetails();

    public abstract void eat();


}