package org.example.ex18;

/* Exercice Java : Liste partagée avec `CopyOnWriteArrayList`

Implémente une application où plusieurs threads ajoutent des éléments à une liste partagée (par exemple, des noms de produits)
en utilisant `CopyOnWriteArrayList`. Vérifie que la liste finale contient tous les éléments sans duplications.

Résultat possible  :

Liste finale des produits : [Thread-1-Produit-0, Thread-2-Produit-0, Thread-1-Produit-1, Thread-1-Produit-2, Thread-2-Produit-1, Thread-1-Produit-3, Thread-2-Produit-2, Thread-1-Produit-4, Thread-2-Produit-3, Thread-1-Produit-5, Thread-2-Produit-4, Thread-2-Produit-5, Thread-2-Produit-6, Thread-1-Produit-6, Thread-2-Produit-7, Thread-2-Produit-8, Thread-1-Produit-7, Thread-2-Produit-9, Thread-1-Produit-8, Thread-1-Produit-9]
*/

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();

        addElement(copyOnWriteList);

        System.out.println("Liste finale des produits : " + copyOnWriteList);

    }


    private static void addElement(List<Integer> list) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                list.add(i);

                String[] produits = {"Produit-0", "Produit-1", "Produit-2", "Produit-3", "Produit-4", "Produit-5", "Produit-6", "Produit-7", "Produit-8", "Produit-9"};
                Random random = new Random();
                String produit = produits[random.nextInt(produits.length)];

                System.out.println(Thread.currentThread().getName() + "-" + produit);
            }

        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }



}
