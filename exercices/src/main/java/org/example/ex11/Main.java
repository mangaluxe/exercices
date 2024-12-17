package org.example.ex11;

/* Exercice java : Méthode synchronisée

Implémente une classe `BankAccount` avec deux méthodes synchronisées : `deposit()` et `withdraw()`.
Simule plusieurs threads effectuant des dépôts et des retraits.
Assure-toi que le solde du compte reste correct après toutes les opérations.

Résultat possible 1 :

Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-2 n'a pas pu retirer 10 (solde insuffisant). Solde actuel : 0
Thread-3 a déposé 10, solde actuel : 10
Thread-3 a déposé 10, solde actuel : 20
Thread-3 a déposé 10, solde actuel : 30
Thread-3 a déposé 10, solde actuel : 40
Thread-3 a déposé 10, solde actuel : 50
Thread-1 a déposé 10, solde actuel : 60
Thread-1 a déposé 10, solde actuel : 70
Thread-1 a déposé 10, solde actuel : 80
Thread-1 a déposé 10, solde actuel : 90
Thread-1 a déposé 10, solde actuel : 100
Solde final : 100


Résultat possible 2 :

Thread-1 a déposé 10, solde actuel : 10
Thread-1 a déposé 10, solde actuel : 20
Thread-1 a déposé 10, solde actuel : 30
Thread-1 a déposé 10, solde actuel : 40
Thread-1 a déposé 10, solde actuel : 50
Thread-3 a déposé 10, solde actuel : 60
Thread-3 a déposé 10, solde actuel : 70
Thread-3 a déposé 10, solde actuel : 80
Thread-3 a déposé 10, solde actuel : 90
Thread-3 a déposé 10, solde actuel : 100
Thread-2 a retiré 10, solde actuel : 90
Thread-2 a retiré 10, solde actuel : 80
Thread-2 a retiré 10, solde actuel : 70
Thread-2 a retiré 10, solde actuel : 60
Thread-2 a retiré 10, solde actuel : 50
Solde final : 50
*/

public class Main {

//    private static final Object lock = new Object();

//    /**
//     * Générer des IDs uniques
//     */
//    static class IdGenerator {
//        private static int id = 0;
//
//        public static int generatedId() {
//            return id++;
//        }
//    }
//
//    /**
//     * Méthode pour créer des threads
//     */
//    private static Thread[] createThreads(Runnable task) {
//        Thread[] threads = new Thread[5];
//        for (int i = 0; i < threads.length; i++) {
//            threads[i] = new Thread(task);
//        }
//        return threads;
//    }
//
//    /**
//     * Méthode pour démarrer et attendre la fin de mes threads
//     */
//    private static void runThreads(Thread[] threads) throws InterruptedException {
//        for (Thread thread : threads) {
//            thread.start();
//        }
//        for (Thread thread : threads) {
//            thread.join();
//        }
//    }


    public static void main(String[] args) {

        BankAccount account = new BankAccount(0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.retirer(10);
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposer(10);
            }
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposer(10);
            }
        }, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Solde final : " + account.getBalance());

    }

}
