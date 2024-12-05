package org.example;

public class Doll extends ToyDecorator implements Toy {

    public Doll(Toy toy) {
        super(toy);
    }

    @Override
    public void enjoy() {
        System.out.println("Poupée pour jouer.");
    }

    @Override
    public String complet() {
        return "";
    }
}
