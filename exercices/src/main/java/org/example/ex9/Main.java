package org.example.ex9;

/* Exercice Java : Comparaison atomique avec `AtomicInteger`

Crée une application qui utilise un `AtomicInteger` pour simuler une condition basée sur une comparaison.
Chaque thread doit vérifier si la valeur actuelle du compteur est inférieure à 10, puis l’incrémenter uniquement si c’est le cas.
Une fois tous les threads terminés, affiche la valeur finale du compteur.

Résultat possible :

Thread-0 a incrémenté le compteur à 1
Thread-6 a incrémenté le compteur à 8
Thread-1 a incrémenté le compteur à 2
Thread-4 a incrémenté le compteur à 5
Thread-2 a incrémenté le compteur à 3
Thread-3 a incrémenté le compteur à 4
Thread-5 a incrémenté le compteur à 6
Thread-9 a incrémenté le compteur à 10
Thread-8 a incrémenté le compteur à 9
Thread-7 a incrémenté le compteur à 7
Valeur finale du compteur : 10
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger compteur = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            final int j = i;
            executor.submit(() -> {
                compteur.incrementAndGet();

                System.out.println("Thread-" + j + " a incrémenté le compteur à " + compteur.get());
                return compteur.get();
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Valeur finale du compteur : " + compteur.get());

    }
}
