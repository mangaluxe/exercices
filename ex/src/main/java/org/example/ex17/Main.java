package org.example.ex17;

/*
# Gestion d'un inventaire avec `ConcurrentHashMap`

Crée une application où plusieurs threads effectuent une simulation d'achats et de réapprovisionnements dans un magasin.
Chaque article du magasin est représenté par une clé unique dans un `ConcurrentHashMap`.
Les threads doivent réduire le stock d'un article lorsqu'un achat est simulé et augmenter le stock lors d'un réapprovisionnement.

Résultat possible  :

Acheteur-1 a acheté 1 unité de ProduitC
Acheteur-2 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitA
Acheteur-1 a acheté 1 unité de ProduitB
Acheteur-2 a acheté 1 unité de ProduitB
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-1 a acheté 1 unité de ProduitC
Acheteur-2 a acheté 1 unité de ProduitB
Réapprovisionneur a réapprovisionné 10 unités de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-2 a acheté 1 unité de ProduitB
Acheteur-1 a acheté 1 unité de ProduitB
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitC
Acheteur-2 a acheté 1 unité de ProduitB
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitC
Inventaire final : {ProduitC=14, ProduitA=72, ProduitB=44}

Résultat possible 2 :

Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitC
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitC
Acheteur-1 a acheté 1 unité de ProduitB
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitB
Réapprovisionneur a réapprovisionné 10 unités de ProduitB
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitC
Réapprovisionneur a réapprovisionné 10 unités de ProduitC
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-1 a acheté 1 unité de ProduitB
Acheteur-2 a acheté 1 unité de ProduitA
Acheteur-2 a acheté 1 unité de ProduitC
Acheteur-2 a acheté 1 unité de ProduitB
Acheteur-2 a acheté 1 unité de ProduitC
Inventaire final : {ProduitC=34, ProduitA=40, ProduitB=56}
*/

import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;


public class Main {

    /**
     * Acheteur
     * @param map
     * @param nom
     */
    private static void Acheteur(ConcurrentHashMap<String, Integer> map, String nom) {
        for (int i = 0; i < 5; i++) {

            String[] produits = {"ProduitA", "ProduitB", "ProduitC"};
            Random random = new Random();
            String produit = produits[random.nextInt(produits.length)];
//            System.out.println(produit);

            map.put(produit, map.get(produit) + 1);

            System.out.println(nom + " a acheté 1 unité de " + produit);
        }
    }


    /**
     * Réapprovisionneur
     * @param map
     */
    private static void Réapprovisionneur(ConcurrentHashMap<String, Integer> map) {
        for (int i = 0; i < 10; i++) {

            String[] produits = {"ProduitA", "ProduitB", "ProduitC"};
            Random random = new Random();
            String produit = produits[random.nextInt(produits.length)];

            map.put(produit, map.get(produit) + 10);

            System.out.println("Réapprovisionneur a réapprovisionné 10 unités de " + produit);
        }
    }


    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("ProduitA", 5);
        map.put("ProduitB", 10);
        map.put("ProduitC", 20);

        Thread thread1 = new Thread(() -> Acheteur(map, "Acheteur-1"));
        Thread thread2 = new Thread(() -> Acheteur(map, "Acheteur-2"));
        Thread thread3 = new Thread(() -> Réapprovisionneur(map));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(map);
        
    }
}