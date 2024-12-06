package org.example;

/* Exercice Java Design pattern - Gestionnaire de Fêtes

Application Java permettant de gérer des événements, leurs prestations, et leurs invités tout en utilisant des concepts avancés de conception logicielle.

Fonctionnalités principales :
    1. Création d'événements : Simplifiez la configuration en rassemblant les informations essentielles comme le nom, la date, le lieu, et les prestations associées.
    2. Gestion des prestations complexes : Structurez et combinez des prestations simples ou avancées selon les besoins.
    3. Actions dynamiques sur les invités : Exécutez, annulez ou rejouez facilement des opérations liées aux participants.

Structure :
    - Événement : Inclut des détails comme le nom, la date, le lieu et les prestations associées. Il est conçu pour une configuration intuitive et flexible.
    - Prestation : Représente des services ou activités associées à un événement, avec la possibilité de structurer des prestations simples ou combinées.
    - Actions sur invités : Permet de gérer les interactions avec les participants de manière flexible et efficace.
*/

import org.example.builder.Event;
import org.example.command.*;
import org.example.decorator.Gold;
import org.example.decorator.Option;
import org.example.decorator.Prestation;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // ----- Builder -----

        Event event = new Event.EventBuilder()
                .setEventName("Salon Pokémon")
                .setEventDate(LocalDate.of(2024, 12, 12))
                .setAddress("1 rue du ciel, Lille") 
                .build();

        System.out.println(event);

        // ----- Decorator -----

        Option prestation = new Prestation(); // Objet initial

        Option prestationGold = new Gold(prestation); // Ajout pour l'objet initial

        System.out.println(prestationGold.description());

        // ----- Command -----

        Show show = new Show();

        Command turnOnShow = new TurnOnShow(show);
        Command turnOffShow = new TurnOffShow(show);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnShow);
        remote.pressButton();

        remote.setCommand(turnOffShow);
        remote.pressButton();

    }
}