package org.example.ex20;

/* Exercice Java : Comparaison de performance entre threads natifs et virtuels

Crée une application qui compare le temps nécessaire pour exécuter une tâche simple avec des threads natifs et des threads virtuels. Analyse les différences de performance et de consommation mémoire.

**Astuce pour mesurer les temps d'exécution :**
Utilisez `System.currentTimeMillis()` pour capturer le temps avant et après l'exécution de votre tâche. Vous pouvez ensuite calculer la durée en soustrayant le temps de début au temps de fin.
*/

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // ----- Threads virtuels -----

        int threadCount = 100;
        long startTime = System.currentTimeMillis();

        long endTime;
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < threadCount; i++) {
                executor.execute(() -> {
                    try {
                        Thread.sleep(1000); // Simule une tache
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

            endTime = System.currentTimeMillis();
            System.out.println("Threads virtuels. Total execution time : " + (endTime - startTime) + " ms");
        }

        // ----- Threads natifs -----

        int threadCount2 = 100;
        long startTime2 = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < threadCount2; i++) {
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                thread.start();
            }
        } catch (OutOfMemoryError | Exception e) {
            System.out.println("Erreur avec les threads natif");
        }

        long endTime2 = System.currentTimeMillis();
        System.out.println("Threads natifs. Total execution time: " + (endTime2 - startTime2) + " ms");

        // ----- Comparaison -----

        System.out.println("Threads virtuels sont " + (endTime - startTime) / (endTime2 - startTime2) + " fois plus rapides que les threads natifs");


    }
}
