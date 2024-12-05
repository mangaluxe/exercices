package org.example;

/*
Exercice : Decorator - Personnalisation de texte

Objectif :
Créez un système de personnalisation de texte où différents décorateurs ajoutent des transformations au texte, comme :
1. Conversion en majuscules ou minuscules.
2. Ajout d'un préfixe ou d'un suffixe.

Tâches :
1. Implémentez une interface `Text` avec une méthode `transform()`.
2. Créez un décorateur abstrait et plusieurs décorateurs concrets (pour changer la casse, ajouter des préfixes, etc.).
3. Testez dans une classe principale.
*/

public class Main {
    public static void main(String[] args) {

        Text message = new Message();

        Text messageUpper = new Upper(message);
        System.out.println(messageUpper.transform()); // Message après majuscule

        Text messagePrefix = new Prefix(messageUpper);
        System.out.println(messagePrefix.transform()); // Message après ajout de préfixe
        
    }
}