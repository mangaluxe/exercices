package org.example;

public class GameFactory extends ToyFactory {

    @Override
    public Toy createToy() {
        return new Game();
    }

}
