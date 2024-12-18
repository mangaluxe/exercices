package org.example.ex16;

/* Exercice Java : Calcul parallèle avec une action de barrière

Implémente un programme où quatre threads calculent des parties d'un tableau de nombres (somme partielle).
Une fois tous les threads synchronisés à la barrière, calcule la somme totale dans une action de barrière.

Résultat possible  :

Thread-2 a calculé une somme partielle de (indice : 2 à indice : 3) : 7
Thread-4 a calculé une somme partielle de (indice : 6 à indice : 7) : 15
Thread-1 a calculé une somme partielle de (indice : 0 à indice : 1) : 3
Thread-3 a calculé une somme partielle de (indice : 4 à indice : 5) : 11
Somme totale : 36a
*/

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {

        int[] tableau = {1, 2, 3, 4, 5, 6};

        CyclicBarrier barrier = new CyclicBarrier(tableau.length, () -> {
            int total = 0;
            for (int i = 0; i < tableau.length; i++) {
                total += tableau[i];
            }
            System.out.println("Somme totale : " + total);
        });

        for (int i = 0; i < 4; i++) {
            final int j = i;
            Runnable task = () -> {
                try {
                    int somme = tableau[j] + tableau[j + 1];

                    System.out.println(Thread.currentThread().getName() + " a calculé une somme partielle de (indice : " + tableau[j] + " à indice " + tableau[j + 1] + ") : " + somme);

                    barrier.await();
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }

            };

            for (int k = 1; k <= 3; k++) {
                new Thread(task, ("Thread-" + k)).start();
            }
        }


    }
}
