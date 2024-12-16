package org.example.ex3;


/* Exercice Java : Gestion des résultats avec `Callable` et `ExecutorService`

Crée une classe `CalculateurCallable` qui implémente l’interface `Callable`. Cette classe doit retourner le cube d’un nombre entier donné.
Dans la méthode `main`, utilise un `ExecutorService` simple (créé avec `Executors.newSingleThreadExecutor()`) pour soumettre des tâches avec des nombres de 1 à 5, récupère les résultats à l’aide de `Future` et affiche-les.

Résultat possible :

Le cube de 1 est 1
Le cube de 2 est 8
Le cube de 3 est 27
Le cube de 4 est 64
Le cube de 5 est 125
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            for (int i = 1; i <= 5; i++) {

                CalculateurCallable calc = new CalculateurCallable(i);

                Future<Integer> resultFuture = executor.submit(calc);

                Integer cube = resultFuture.get();
                System.out.println("Le cube de " + i + " est " + cube);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }

}
