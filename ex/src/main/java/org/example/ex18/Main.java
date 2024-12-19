package org.example.ex18;

/* Exercice Java : Liste partagée avec `CopyOnWriteArrayList`

Implémente une application où plusieurs threads ajoutent des éléments à une liste partagée (par exemple, des noms de produits)
en utilisant `CopyOnWriteArrayList`. Vérifie que la liste finale contient tous les éléments sans duplications.

Résultat possible  :

Liste finale des produits : [Thread-1-Produit-0, Thread-2-Produit-0, Thread-1-Produit-1, Thread-1-Produit-2, Thread-2-Produit-1, Thread-1-Produit-3, Thread-2-Produit-2, Thread-1-Produit-4, Thread-2-Produit-3, Thread-1-Produit-5, Thread-2-Produit-4, Thread-2-Produit-5, Thread-2-Produit-6, Thread-1-Produit-6, Thread-2-Produit-7, Thread-2-Produit-8, Thread-1-Produit-7, Thread-2-Produit-9, Thread-1-Produit-8, Thread-1-Produit-9]
*/

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> products = new CopyOnWriteArrayList<>();

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                String product = Thread.currentThread().getName() + "Produit " + i;
                products.add(product);
                System.out.println(product);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(task);
        executor.submit(task);

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("Liste finale : " + products);
        System.out.println("Taille finale: " + products.size());
    }

}
