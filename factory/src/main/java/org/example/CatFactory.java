package org.example;

public class CatFactory {

    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
