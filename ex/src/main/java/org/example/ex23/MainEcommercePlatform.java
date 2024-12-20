package org.example.ex23;

/* Exercice Java : Simulation d'une Plateforme E-Commerce Multithreadée

## Objectif
Développer une application Java simulant une plateforme de e-commerce. Cette plateforme doit permettre à plusieurs utilisateurs de remplir leur panier avec des articles, de passer des commandes, et de traiter celles-ci en utilisant des concepts de concurrence.

## Contexte
Une entreprise souhaite simuler le fonctionnement de sa plateforme de e-commerce pour optimiser le traitement des commandes. Vous êtes chargé de concevoir et d'implémenter cette simulation.

## Fonctionnalités attendues
1. **Catalogue d'articles** :
    - Chaque article est défini par un identifiant, un nom, et un prix.
    - Un catalogue initial contenant au moins 4 articles doit être disponible.

2. **Gestion des utilisateurs** :
    - Chaque utilisateur dispose d'un panier personnel pour ajouter des articles.
    - Le panier doit être sécurisé pour un accès concurrent.

3. **Création des commandes** :
    - Une commande contient un identifiant unique et une liste d'articles.
    - Les commandes doivent être ajoutées à une liste commune.

4. **Traitement des commandes** :
    - Toutes les commandes doivent être traitées une fois que 10 utilisateurs ont passé leurs commandes.
    - Affichez les commandes traitées.

5. **Multithreading** :
    - Utilisez des threads pour simuler 10 utilisateurs effectuant des achats en parallèle.


## Contraintes techniques
- Utilisez plusieurs classes pour implémenter la solution ( par exemple : `Article`, `Utilisateur`, `Panier`, `Commande`, `ECommercePlatform`).

## Exécution
1. Ajoutez des articles aléatoires au panier de chaque utilisateur (au moins 5 articles par utilisateur).
2. Passez les commandes et affichez leur contenu.
3. Affichez le traitement des commandes une fois toutes les commandes passées.

## Critères de validation
- La simulation doit s'exécuter sans erreurs de concurrence.
- Les commandes et leur traitement doivent être correctement affichés dans la console.

*/

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MainEcommercePlatform {
    public static void main(String[] args) throws InterruptedException {

        Article article1 = new Article("1", "Pomme", 1.50);
        Article article2 = new Article("2", "Orange", 1.20);
        Article article3 = new Article("3", "Chocolat", 2.50);
        Article article4 = new Article("4", "Pain", 1.10);

        Utilisateur utilisateur1 = new Utilisateur("1", "Mario");
        Utilisateur utilisateur2 = new Utilisateur("2", "Luigi");

        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

        scheduler.scheduleAtFixedRate(() -> {
            Panier panier1 = new Panier();
            Panier panier2 = new Panier();

            panier1.addArticle(article1);
            panier1.addArticle(article2);
            panier1.addArticle(article3);
            panier1.addArticle(article4);

            Commande commande1 = new Commande("1", utilisateur1, panier1, 0, LocalDateTime.now(), "En cours");
            Commande commande2 = new Commande("2", utilisateur2, panier2, 0, LocalDateTime.now(), "En cours");

            List<Commande> commandes = new ArrayList<>();
            commandes.add(commande1);
            commandes.add(commande2);

            for (Commande commande : commandes) {
                System.out.println(commande);
            }

            for (Commande commande : commandes) {
                commande.setStatus("Traitée");
            }

            for (Commande commande : commandes) {
                System.out.println(commande);
            }

        }, 0, 1, TimeUnit.SECONDS); // Planifie une tâche qui s'exécutera périodiquement

        Thread.sleep(3000); // Attend x millisec

        scheduler.shutdown(); // Arrête le scheduler et toutes ses tâches en cours

    }
}
