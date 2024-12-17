package org.example.ex7;

/* Exercice Java : Planification périodique avec `ScheduledExecutorService` et `AtomicInteger`

Crée une application qui utilise un `ScheduledExecutorService` pour afficher un message toutes les 2 secondes,
avec un délai initial de 1 seconde. Le programme doit s’arrêter après avoir affiché le message 5 fois.

Résultat possible :

Message périodique 1
Message périodique 2
Message périodique 3
Message périodique 4
Message périodique 5
Programme terminé.
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        AtomicInteger atomicInteger = new AtomicInteger(0); // Variable atomique

        for (int i = 1; i <= 5; i++) {
            final int j = i;

            executor.scheduleAtFixedRate(() -> {
                System.out.println("Message périodique " + j);

                if (atomicInteger.incrementAndGet() == 5) {
                    System.out.println("Programme terminé.");
                    executor.shutdown();
                }

            }, 1, 2, TimeUnit.SECONDS);
        }

    
    }

}

