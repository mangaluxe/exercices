package org.example;

/*
Exercice : Factory Method - Animaux

Objectif :
Utilisez le pattern Factory Method pour créer des classes représentant des animaux qui ont des comportements spécifiques (par exemple, un chat qui miaule et un chien qui aboie).

Tâches :
1. Créez une classe abstraite `AnimalFactory` qui contient une méthode `createAnimal()`.
2. Implémentez des sous-classes pour produire des animaux spécifiques (`CatFactory`, `DogFactory`, etc.).
3. Ajoutez des comportements spécifiques dans les animaux (par exemple, `makeSound()`).
4. Testez dans une classe principale.
*/

public class Main {
    public static void main(String[] args) {

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.makeSound();

        AnimalFactory dogFactory = new DogFactory();
        Animal dog = catFactory.createAnimal();
        dog.makeSound();











    }
}