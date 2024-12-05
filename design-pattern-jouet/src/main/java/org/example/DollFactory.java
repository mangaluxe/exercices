package org.example;

public class DollFactory extends ToyFactory {

    @Override
    public Toy createToy() {
        return new Doll(new Game());

    }

}