package org.example;

/*
Exercice Java Lambda

Crée une application Calculatrice qui permet d'effectuer les operations classiques (Addition/Soustraction/Multiplication/Division) via une interface fonctionnelle qui s'appellera Calculator.

Les differentes methodes Lambda seront stockées dans un Map pour pouvoir y acceder.

Gérer une interface IMH qui affichera nos informations via un Consumer.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

//    public static double addition(double a, double b) {
//        return (a + b);
//    }
//
//    public static double soustraction(double a, double b) {
//        return (a - b);
//    }
//
//    public static double multiplication(double a, double b) {
//        return (a * b);
//    }
//
//    public static double division(double a, double b) {
//        return (a / b);
//    }


    public static void main(String[] args) {

        Map<String, Calculator> operations = new HashMap<>();

        operations.put("addition", (a, b) -> a + b);
        operations.put("soustraction", (a, b) -> a - b);
        operations.put("multiplication", (a, b) -> a * b);
        operations.put("division", (a, b) -> a / b);

        // ----- Test sans IHM : -----

        double num1 = 2;
        double num2 = 5;

//        double result = addition(num1, num2);
//        System.out.println(result);
//
//        double result2 = soustraction(num1, num2);
//        System.out.println(result2);
//
//        double result3 = multiplication(num1, num2);
//        System.out.println(result3);
//
//        double result4 = division(num1, num2);
//        System.out.println(result4);


//        String choix = "addition";
//        String choix = "soustraction";
//        String choix = "multiplication";
        String choix = "division";

        if (operations.containsKey(choix)) {
            double result = operations.get(choix).calcul(num1, num2);
            System.out.println("Résultat: " + result);
        }
        else {
            System.out.println("Erreur");
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choix opération ?");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction"); 
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            int choice = Integer.parseInt(sc.nextLine());

            double result = switch (choice) {
                case 1 -> operations.get("addition").calcul(num1, num2);
                case 2 -> operations.get("soustraction").calcul(num1, num2);
                case 3 -> operations.get("multiplication").calcul(num1, num2);
                case 4 -> operations.get("division").calcul(num1, num2);
                default -> {
                    System.out.println("Erreur");
                    yield 0.0; // yield pour retourner une valeur dans un switch moderne
                }
            };

            System.out.println("Résultat : " + result);
        }

    }
}