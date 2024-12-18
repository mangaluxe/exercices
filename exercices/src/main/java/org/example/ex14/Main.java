package org.example.ex14;

/*
Synchronisation de tâches avec `CyclicBarrier`

Crée un programme où trois threads simulent le chargement de données depuis des fichiers différents.
Chaque thread attend les autres à une barrière avant de fusionner les données pour poursuivre.

Résultat possible  :

Thread-3 commence à charger les données.
Thread-1 commence à charger les données.
Thread-2 commence à charger les données.
Thread-2 a terminé le chargement des données.
Thread-1 a terminé le chargement des données.
Thread-3 a terminé le chargement des données.
Fusion des données terminée. Tous les threads peuvent continuer.

Résultat possible 2 :

Thread-2 commence à charger les données.
Thread-3 commence à charger les données.
Thread-1 commence à charger les données.
Thread-3 a terminé le chargement des données.
Thread-2 a terminé le chargement des données.
Thread-1 a terminé le chargement des données.
Fusion des données terminée. Tous les threads peuvent continuer.
*/

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("Fusion des données terminée. Tous les threads peuvent continuer.");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " commence à charger les données.");
                barrier.await(); // Attendre les autres tâches devant la barrière

                System.out.println(Thread.currentThread().getName() + " a terminé le chargement des données");
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        };  

        for (int i = 0; i < 3; i++) {
            new Thread(task, "Thread-" + (i + 1)).start();
        }

    }
}
