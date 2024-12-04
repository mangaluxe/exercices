package org.example.Zoo2;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {

    // ----- Propriétés -----

    private int id;
    private String name;

//    List<Animal> animals = new ArrayList<>();
    private List<Animal> animals;


    // ----- Constructeur -----

    public Enclosure(int id, String name, List<Animal> animals) {
        this.id = id;
        this.name = name;
        this.animals = animals;
    }


    // ----- Méthodes -----

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void deleteAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void showAnimals() {
        System.out.println("Animaux dans l'enclos " + name + ":");
        for (Animal animal : animals) {
            System.out.println(animal.getDetails());
        }
    }

}
