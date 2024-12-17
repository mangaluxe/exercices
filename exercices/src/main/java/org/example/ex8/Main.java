package org.example.ex8;

/* Exercice Java : Compteur sécurisé avec `AtomicInteger`

Crée une application qui utilise un `AtomicInteger` pour implémenter un compteur partagé entre plusieurs threads.
Chaque thread doit incrémenter le compteur 1 000 fois. Une fois tous les threads terminés, affiche la valeur finale du compteur.

Résultat possible :

Valeur finale du compteur : 10000
*/


import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    private static AtomicInteger compteur = new AtomicInteger(0);


    private static Thread[] createAtomicThreads() {

        Thread[] threads = new Thread[10];

        // System.out.println(threads.length); // 10

        for (int i = 0; i < threads.length; i++) {

            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    compteur.incrementAndGet();
                }
            });
        }
        return threads;
    }


    public static void main(String[] args) throws InterruptedException {

        Thread[] atomicThreads = createAtomicThreads();
        for (Thread t : atomicThreads) {
            t.start();
        }
        for (Thread t : atomicThreads) {
            t.join();
        }
        System.out.println("Valeur finale du compteur : " + compteur.get()); // Affiche: Valeur finale du compteur : 10000

    }

}
