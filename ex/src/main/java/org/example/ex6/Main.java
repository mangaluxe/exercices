package org.example.ex6;

/* Exercice Java : Crée une application qui utilise un `ScheduledExecutorService` pour simuler un système de rappel.

L'application doit :
1. Planifier trois tâches différentes avec des délais initiaux différents (par exemple 1, 2, et 3 secondes).
2. Chaque tâche doit afficher un message spécifique lorsqu'elle est exécutée.
3. Le programme doit s'arrêter automatiquement après avoir exécuté toutes les tâches une fois.

Résultat possible :

Tâche 1 exécutée après 1 seconde.
Tâche 2 exécutée après 2 secondes.
Tâche 3 exécutée après 3 secondes.
Toutes les tâches ont été exécutées. Arrêt du programme.
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        Runnable task1 = () -> System.out.println("Tâche 1 exécutée après 1 seconde.");
        Runnable task2 = () -> System.out.println("Tâche 2 exécutée après 2 secondes.");
        Runnable task3 = () -> System.out.println("Tâche 3 exécutée après 3 secondes.");

        executor.schedule(task1, 1, TimeUnit.SECONDS);
        executor.schedule(task2, 2, TimeUnit.SECONDS);
        executor.schedule(task3, 3, TimeUnit.SECONDS);

        executor.schedule(() -> System.out.println("Toutes les tâches ont été exécutées. Arrêt du programme."), 4, TimeUnit.SECONDS);

        executor.shutdown();
    }
}
