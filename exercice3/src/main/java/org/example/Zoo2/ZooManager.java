package org.example.Zoo2;

import java.util.ArrayList;
import java.util.List;

public class ZooManager { // Gère les enclos et les interactions avec le zoo
    public static void main(String[] args) {

        ConsoleMenu menu = new ConsoleMenu();

        // ----- On crée d'abord nos enclos -----

        List<Enclosure> enclosures = new ArrayList<>();

        Enclosure enclosure1 = new Enclosure(1, "Espace Sauvage", new ArrayList<>());
        Enclosure enclosure2 = new Enclosure(2, "Pavillon", new ArrayList<>());

        menu.addEnclosure(enclosure1);
        menu.addEnclosure(enclosure2);

        // ----- Ajouter des animaux de test -----

        enclosure1.addAnimal(new Mammal(1, "Pierrot", "Dauphin"));
        enclosure2.addAnimal(new Bird(2, "Tom", "Perroquet"));

        // ----- Lancer le menu IHM -----

        menu.start();

    }
}
