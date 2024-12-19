package org.example.ex19;

/* Exercice Java : File d'attente concurrente avec `ConcurrentLinkedQueue`

Crée un programme où plusieurs threads ajoutent et suppriment des éléments d'une file d'attente concurrente (`ConcurrentLinkedQueue`).
Affiche les éléments ajoutés et retirés, en vérifiant que la file reste cohérente.

Résultat possible  :

Producer a ajouté : Producer-Element-0
Producer a ajouté : Producer-Element-1
Producer a ajouté : Producer-Element-2
Producer a ajouté : Producer-Element-3
Producer a ajouté : Producer-Element-4
Producer a ajouté : Producer-Element-5
Producer a ajouté : Producer-Element-6
Producer a ajouté : Producer-Element-7
Producer a ajouté : Producer-Element-8
Producer a ajouté : Producer-Element-9
Consumer a retiré : Producer-Element-0
Consumer a retiré : Producer-Element-1
Consumer a retiré : Producer-Element-2
Consumer a retiré : Producer-Element-3
Consumer a retiré : Producer-Element-4
Consumer a retiré : Producer-Element-5
Consumer a retiré : Producer-Element-6
Consumer a retiré : Producer-Element-7
Consumer a retiré : Producer-Element-8
Consumer a retiré : Producer-Element-9
État final de la file : []

Résultat possible 2 :

Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Consumer n'a trouvé aucun élément à retirer.
Producer a ajouté : Producer-Element-0
Producer a ajouté : Producer-Element-1
Producer a ajouté : Producer-Element-2
Producer a ajouté : Producer-Element-3
Producer a ajouté : Producer-Element-4
Producer a ajouté : Producer-Element-5
Producer a ajouté : Producer-Element-6
Producer a ajouté : Producer-Element-7
Producer a ajouté : Producer-Element-8
Producer a ajouté : Producer-Element-9
État final de la file : [Producer-Element-0, Producer-Element-1, Producer-Element-2, Producer-Element-3, Producer-Element-4, Producer-Element-5, Producer-Element-6, Producer-Element-7, Producer-Element-8, Producer-Element-9]
*/

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        // Producteur
        Runnable producer = () -> {
            for (int i = 0; i < 10; i++) {
//                String element = Thread.currentThread().getName() + "-Element-" + i;
                String element = "Producer-Element-" + i;
                queue.add(element);
//                System.out.println(Thread.currentThread().getName() + " a ajouté " + element);
                System.out.println("Producer a ajouté : " + element);
//                try {
//                    Thread.sleep(100);
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }
        };

        // Consommateur
        Runnable consumer = () -> {
            for (int i = 0; i < 10; i++) {
                String element = queue.poll(); // Retire et retourne le premier élément ou null si la file est vide
                if (element != null) {
                    // System.out.println(Thread.currentThread().getName() + " a retiré " + element);
                    System.out.println("Consumer a retiré : " + element);
                }
                else {
                     System.out.println(Thread.currentThread().getName() + " n'a trouvé aucun élément à retirer");
                }
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        executor.submit(producer);
//        executor.submit(consumer);
//
//        executor.shutdown();
//
//        while (!executor.isTerminated()) {
//            Thread.sleep(100);
//        }
//
//        System.out.println("État final de la file : " + queue);

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();

        System.out.println("Etat final de la liste : " + queue);

    }
}
