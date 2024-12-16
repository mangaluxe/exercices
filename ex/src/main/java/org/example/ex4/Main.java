package org.example.ex4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* Exercice Java : Exécuter des tâches avec un `ExecutorService`

Crée une application qui utilise un `ExecutorService` pour exécuter 10 tâches.
Chaque tâche doit afficher un message contenant son identifiant unique (par exemple, "Tâche 1 exécutée").
Le programme doit utiliser un pool fixe de 3 threads.

Résultat possible :

Tâche 2 exécutée par pool-1-thread-2
Tâche 1 exécutée par pool-1-thread-1
Tâche 3 exécutée par pool-1-thread-3
Tâche 4 exécutée par pool-1-thread-2
Tâche 5 exécutée par pool-1-thread-3
Tâche 6 exécutée par pool-1-thread-1
Tâche 7 exécutée par pool-1-thread-2
Tâche 8 exécutée par pool-1-thread-3
Tâche 9 exécutée par pool-1-thread-1
Tâche 10 exécutée par pool-1-thread-2
*/


public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executor.execute(() -> System.out.println("Tâche " + finalI + " exécutée par " + Thread.currentThread().getName()));
        }
        executor.shutdown();

    }
}
