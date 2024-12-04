package org.example.Zoo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu { // Fournit une interface console pour interagir avec le système

    private List<Enclosure> enclosures = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("""
                    === Menu Principal ===
                    1. Ajouter un animal
                    2. Lister les animaux
                    3. Déplacer un animal
                    4. Nourrir les animaux
                    5. Quitter
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Vider le buffer après un nextInt

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    listAnimals();
                    break;
                case 3:
                    moveAnimal();
                    break;
                case 4:
                    feedAnimals();
                    break;
                default:
                    System.out.println("Au revoir !");
                    return;
            }
        }
    }

    /**
     * Ajouter un animal
     */
    private void addAnimal() {
        System.out.print("Nom de l'animal : ");
        String name = scanner.nextLine();
        System.out.print("Espèce de l'animal : ");
        String species = scanner.nextLine();
        System.out.print("ID de l'enclos : ");
        int enclosureId = scanner.nextInt();


        // ... pas fini
    }

    /**
     * Lister animaux
     */
    private void listAnimals() {
        for (Enclosure enclosure : enclosures) {
            System.out.println(enclosure);
        }

    }

    /**
     * Déplacer un animal
     */
    private void moveAnimal() {
        System.out.print("ID de l'animal à déplacer : ");
        int animalId = scanner.nextInt();
        System.out.print("ID de l'enclos source : ");
        int fromId = scanner.nextInt();
        System.out.print("ID de l'enclos destination : ");
        int toId = scanner.nextInt();

        // ... pas fini

    }

    /**
     * Nourrir les animaux
     */
    private void feedAnimals() {

    }

    /**
     * Ajouter un enclos
     */
    public void addEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }


}
