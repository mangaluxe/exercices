package org.example;

/*
Exercice Java Design Pattern "Builder" - Construction de Maison

Utilisez le pattern Builder pour construire des maisons avec différentes caractéristiques (nombre d'étages, type de toit, piscine...).

Tâches :
1. Implémentez une classe `House` représentant la maison.
2. Créez une interface `HouseBuilder` pour définir les étapes de construction.
3. Implémentez des builders spécifiques pour des maisons modernes et traditionnelles.
4. Testez dans une classe principale en construisant les deux types de maisons.
 */

public class Main {
    public static void main(String[] args) {

        HouseBuilder builder = new HouseBaseBuilder();

        // ----- Maison moderne -----

//        ModernHouse modernHouse = new ModernHouse(builder);

        HouseBuilder modernBuilder = new ModernHouseBuilder();
        modernBuilder.setWall(5);
        modernBuilder.setRoof("Toit moderne");
        modernBuilder.setFloor("Sol moderne");
        modernBuilder.setDoor(2);
        House modernHouse = modernBuilder.build();
        modernHouse.showDetails();


        // ----- Maison traditionnelle -----

        HouseBuilder traditionalBuilder = new TraditionalHouseBuilder();
        traditionalBuilder.setWall(6);
        traditionalBuilder.setRoof("Toit ancien");
        traditionalBuilder.setFloor("Pierre");
        traditionalBuilder.setDoor(3);
        House traditionalHouse = traditionalBuilder.build();
//        ((TraditionalHouse) traditionalHouse).addChimney();  // Ajouter une cheminée
        traditionalHouse.showDetails();
    }
}