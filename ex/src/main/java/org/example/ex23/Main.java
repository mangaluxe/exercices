package org.example.ex23;

/*
# Exercice : Simulation d'une Plateforme E-Commerce Multithreadée

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

public class Main {
    public static void main(String[] args) {



    }
}
