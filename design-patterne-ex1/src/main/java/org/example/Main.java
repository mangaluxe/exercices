package org.example;

/*
Exercice : Singleton - Gestionnaire de configuration

Objectif :
Créez une classe Singleton pour gérer les configurations globales d'une application. Cette classe doit permettre :
1. De charger les configurations à partir d'un fichier ou d'un dictionnaire simulé.
2. De récupérer une configuration par clé.
3. D'empêcher la modification directe des configurations après leur chargement.

Tâches :
- Implémentez la classe `ConfigurationManager` en tant que Singleton.
- Chargez une configuration simulée sous forme de dictionnaire.
- Ajoutez une méthode pour récupérer une valeur par clé.
- Testez dans une classe principale que l'unicité de l'instance est respectée.

Exemple de données de configuration :
{ "db.host": "localhost", "db.port": "5432", "app.name": "MyApplication" }
*/

public class Main {
    public static void main(String[] args) {

        ConfigurationManager configManager1 = ConfigurationManager.getInstance();
        ConfigurationManager configManager2 = ConfigurationManager.getInstance();

        // ----- Vérifie si les deux instances sont identiques -----

        System.out.println("Les deux instances sont identiques : " + (configManager1 == configManager2)); // Affiche: Les deux instances sont identiques : true
        configManager1.test(); // Affiche: Test ok
        configManager2.test(); // Affiche: Test ok

        // ----- Test des configurations -----

        System.out.println("db.host : " + configManager1.getConfiguration("db.host")); // Affiche: localhost
        System.out.println("db.port : " + configManager1.getConfiguration("db.port")); // Affiche: 5432
        System.out.println("app.name : " + configManager1.getConfiguration("app.name")); // Affiche: MyApplication

    }
}