package org.example;

/*
Exercice : Composite - Organisation d'une société

Objectif :
Utilisez le pattern Composite pour représenter une organisation où chaque employé peut avoir des subordonnés.

Tâches :
1. Implémentez une interface `Salarie` avec une méthode `showDetails()`.
2. Créez des classes concrètes pour les managers et les employés individuels.
3. Testez dans une classe principale en créant une hiérarchie de l'organisation.
*/

public class Main {
    public static void main(String[] args) {

        Employe employe1 = new Employe("Tom");
        Employe employe2 = new Employe("Jack");

        employe1.showDetails();
        employe2.showDetails();

        Manager manager1 = new Manager("Monsieur X");
        manager1.add(employe1);
        manager1.add(employe2);

        manager1.showDetails();

        Employe employe3 = new Employe("Mario");

        Manager manager2 = new Manager("Luigi");
        manager2.add(manager1);
        manager2.add(employe3);

        manager2.showDetails();

    }
}