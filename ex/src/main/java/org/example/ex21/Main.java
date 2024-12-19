package org.example.ex21;

/* Exercice Java : Serveur multi-connexion avec threads virtuels

Implémente un serveur simulé qui accepte 1 000 connexions simultanées, où chaque connexion est gérée par un thread virtuel.
Chaque connexion doit attendre 2 secondes avant de renvoyer une réponse simulée.
*/

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Début : Serveur multi-connexion avec threads virtuels");

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000; i++) {
                executor.execute(() -> {
                    try {
                        Thread.sleep(2000); // Simulation de tâche
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }

        System.out.println("Serveur multi-connexion avec threads virtuels : Terminé");

    }
}
