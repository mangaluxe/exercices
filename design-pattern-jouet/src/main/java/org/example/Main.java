package org.example;

/*
Exercice. Description :

    Le Père Noël a besoin de moderniser son atelier pour mieux gérer la production de jouets et la coordination
    des lutins. Votre mission est de créer une petite application orientée objet qui permet de :

    - Fabriquer différents types de jouets de manière extensible.
    - Ajouter des personnalisations et des décorations aux jouets.
    - Notifier les lutins des différentes étapes de production.

    Pour cela, vous allez concevoir une solution en Java utilisant des principes de programmation orientée objet
    et des patterns de conception. L’objectif est d'explorer un pattern de chaque catégorie suivante :

    - Création d'objets (Creational). Ex: Builder ou Factory
    - Organisation et composition des objets (Structural). Ex: Decorator
    - Comportement et interactions des objets (Behavioral). Ex: Notification avec Observer

Objectifs :

    - Appliquer les principes de la programmation orientée objet, comme l'héritage, le polymorphisme et
    l'encapsulation.
    - Comprendre et mettre en œuvre des patterns de conception adaptés aux besoins de l'application.
    - Créer une solution modulaire et extensible.

Instructions :

    1. Implémentez un système permettant de fabriquer différents types de jouets.
    2. Ajoutez la possibilité de décorer ou de personnaliser les jouets de manière flexible.
    3. Mettez en place un système de notification pour informer les lutins.
    4. Assurez-vous que votre solution respecte les principes SOLID et est facilement extensible.
*/

public class Main {
    public static void main(String[] args) {

        // ----- Decorator -----

        Toy plainToy = new PlainToy();
        System.out.println("Jouet brut : " + plainToy.complet());

        Toy toyWithPackaging = new Packaging(plainToy);
        System.out.println(toyWithPackaging.complet());

        
        // ----- Observer -----

        EventManager em = new EventManager();
        Observer notificationLogger = new NotificationLogger();

        em.addObserver(notificationLogger);
        em.notifyObservers("Jouet terminé !");

        // ----- Factory -----

        ToyFactory dollFactory = new DollFactory();
        Toy doll = dollFactory.createToy();
        doll.enjoy();

        ToyFactory gameFactory = new GameFactory();
        Toy game = gameFactory.createToy();
        game.enjoy();
    }
}
