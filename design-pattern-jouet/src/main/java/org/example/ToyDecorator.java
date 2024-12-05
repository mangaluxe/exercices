package org.example;

// Décorateur

public abstract class ToyDecorator implements Toy {

    // ----- Propriétés ----

    protected Toy toy;

    // ----- Constructeur -----

    public ToyDecorator(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void enjoy() {
        toy.enjoy();
    }

    @Override
    public String complet() {
        return toy.complet();
    }

}

