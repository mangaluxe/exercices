package org.example.ex15;

/* Exercice Java : Crée un programme où trois threads passent par plusieurs étapes synchronisées.
À chaque étape, affiche un message indiquant quelle étape a été complétée et quel thread l'a atteinte.

Résultat possible  :

Thread-3 atteint l'étape 1
Thread-2 atteint l'étape 1
Thread-1 atteint l'étape 1
Thread-1 atteint l'étape 2
Thread-3 atteint l'étape 2
Thread-2 atteint l'étape 2
Thread-2 atteint l'étape 3
Thread-1 atteint l'étape 3
Thread-3 atteint l'étape 3
*/

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Main {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable task = () -> {
            try {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(Thread.currentThread().getName() + " atteint l'étape " + i);
                    barrier.await();
                }
            }
            catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task, "Thread-" + (i + 1)).start();
        }

        




    }
}
