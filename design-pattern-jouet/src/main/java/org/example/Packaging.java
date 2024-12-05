package org.example;

// Décorateur (Emballage pour décorer le jouet)

public class Packaging extends ToyDecorator {

    public Packaging(Toy toy) {
        super(toy);
    }

    public String complet() {
        return "Ajout d'emballage";
    }
}
