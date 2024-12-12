package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/*
Écrivez un programme Java pour simuler la gestion d'une liste d'étudiants. Chaque étudiant est représenté par une classe Student avec les attributs name (nom) et age (âge). Le programme doit permettre à l'utilisateur d'ajouter des étudiants à la liste et d'afficher la liste complète des étudiants. Cependant, vous devez créer une exception personnalisée appelée InvalidAgeException, qui sera levée si l'utilisateur tente d'ajouter un étudiant avec un âge négatif. Lorsque cette exception est levée, le programme doit afficher un message d'erreur approprié et demander à l'utilisateur de saisir à nouveau l'âge de l'étudiant.
*/


public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Ajouter un étudiant. Nom : (Taper 'exit' pour sortir)");
                String nom = sc.nextLine();

                if (nom.equals("exit")) {
                    break;
                }

                System.out.println("Age :");
                int age = Integer.parseInt(sc.nextLine());

                if (age < 0 || age > 100) {
                    throw new InvalidAgeException("Erreur d'age !");
                }

                students.add(new Student(nom, age));
                System.out.println("Etudiant ajouté ! Liste mise à jour :");
                for (Student s : students) {
                    System.out.println(s);
                }
            }
            catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e) { // Sans ce catch, Java affichera une erreur "NumberFormatException"
                System.out.println("Il faut taper un nombre");
            }
        }

    }
}
