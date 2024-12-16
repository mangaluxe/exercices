package org.example.ex5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.example.ex3.CalculateurCallable;

/* Exercice Java : Gestion des résultats avec `Callable` et `Future`

Crée un programme où chaque tâche retourne le carré de son identifiant (par exemple, la tâche 3 retourne 9).
Utilise un `ExecutorService` pour exécuter ces tâches et récupère les résultats en utilisant `Future`.

Résultat possible :

Résultat de la tâche 1 : 1
Résultat de la tâche 2 : 4
Résultat de la tâche 3 : 9
Résultat de la tâche 4 : 16
Résultat de la tâche 5 : 25
Résultat de la tâche 6 : 36
Résultat de la tâche 7 : 49
Résultat de la tâche 8 : 64
Résultat de la tâche 9 : 81
Résultat de la tâche 10 : 100
*/

public class Main {
    public static void main(String[] args) {

        //        ExecutorService executor = Executors.newFixedThreadPool(3);
//        for (int i = 1; i <= 10; i++) {
//            int finalI = i;
//            executor.submit(() -> System.out.println("Résultat de la tâche " + finalI + " : " + finalI * finalI));
//        }
//        executor.shutdown();


        // Utilisation de `Callable` et `Future` pour mettre dans l'ordre :

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer>[] futures = new Future[10];

        for (int i = 1; i <= 10; i++) {
            final int j = i;
            futures[i-1] = executor.submit(() -> j * j);
        }

        for (int i = 0; i < futures.length; i++) {
            try {
                int resultat = futures[i].get();
                System.out.println("Résultat de la tâche " + (i+1) + " : " + resultat);
            }
            catch (InterruptedException | ExecutionException e) {
                System.out.println("Erreur lors de la récupération pour " + (i+1));
            }
        }

        executor.shutdown();

    }

}
