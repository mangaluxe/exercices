package org.example;

/*
Exercice : Observer - Notifications d'événements

Objectif :
Utilisez le pattern Observer pour créer un système de notification d'événements.
1. Implémentez une classe `EventManager` comme sujet, permettant d'ajouter et de notifier des observateurs.
2. Implémentez plusieurs observateurs, chacun ayant une réaction spécifique à une notification.
3. Testez en simulant des événements dans une classe principale.
*/

public class Main {
    public static void main(String[] args) {

        EventManager em = new EventManager(1);

        System.out.println("Message initial : " + em.getEventCount());

        Messenger m = new Messenger("Affiche message...");

        Writer w = new Writer("Ecriture...");

        em.addObserver(w);
        em.addObserver(m);

        em.setEventCount(2);

    }
}