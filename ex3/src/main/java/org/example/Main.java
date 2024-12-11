package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/*
Implémenter les différentes tâches suivantes en utilisant Stream :

1. Filtrer les livres disponibles (dont `estDisponible` est `true`).
2. Trouver les livres publiés avant 1900 et afficher leur titre et auteur.
3. Grouper les livres par genre (par exemple, tous les "Romans" ensemble, tous les "Science-fiction" ensemble, etc.).
4. Trouver le livre le plus ancien dans la bibliothèque (le livre avec la date de publication la plus ancienne).
5. Vérifier s'il existe des livres dont le titre commence par "Harry".
6. Calculer le prix moyen des livres disponibles dans la bibliothèque.
7. Trier les livres par nombre de pages, puis par prix (en cas d'égalité du nombre de pages).
8. Calculer le total des pages pour tous les livres de genre "Fantasy".
9. Trouver le livre le plus cher disponible à la vente.
10. Trouver les auteurs les plus prolifiques (les auteurs ayant écrit plus de 17 livre) et afficher leurs livres.
11. Compter le nombre de livres dans chaque genre (afficher par exemple combien de "Romans", combien de "Science-fiction", etc.).
12. Vérifier si un livre est disponible et si son prix est inférieur à un seuil donné, et afficher les livres correspondants.
13. Calculer le nombre total de pages pour les livre de chaque année.
*/


public class Main {
    public static void main(String[] args) {

        String csvFile = "src/main/resources/books.csv";

        List<Livre> livres = new ArrayList<>(); // On crée une liste de films vide pour pouvoir stocker les films par la suite

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.lines()
                    .skip(1) // Ignore la première ligne
                    .map(line -> line.split(","))
                    .map(value -> new Livre(value[0], value[1], value[2], LocalDate.parse(value[3]), Integer.parseInt(value[4]), Boolean.parseBoolean(value[5]), Double.parseDouble(value[6])))
                    .forEach(livre -> livres.add(livre)); // Ajouter chaque livre à la liste livres
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // ========== Test ==========

//        livres.stream()
//                // .forEach(livre -> System.out.println(livre));
//                .forEach(System.out::println);

        // ========== ==========

        System.out.println("\n----- 1. Filtrer les livres disponibles (dont `estDisponible` est `true`) -----\n");
        livres.stream()
                .filter(livre -> livre.getEstDisponible())
                .forEach(System.out::println);


        System.out.println("\n----- 2. Trouver les livres publiés avant 1901 et afficher leur titre et auteur -----\n");
        livres.stream()
                .filter(livre -> livre.getDatePublication().getYear() < 1901)
//                .forEach(System.out::println);
                .forEach(livre -> System.out.println("Titre : " + livre.getTitre() + ". Auteur : " + livre.getAuteur())); // Afficher que leur titre et auteur


        System.out.println("\n----- 3. Grouper les livres par genre ('Fantasy' ensemble, 'Science-fiction' ensemble...). -----\n");
        livres.stream()
            .collect(Collectors.groupingBy(Livre::getGenre))
            .forEach((genre, livresDuGenre) -> {
                System.out.println("--- Genre : " + genre + " ---");
                livresDuGenre.forEach(livre -> System.out.println("Titre : " + livre.getTitre() + ". Auteur : " + livre.getAuteur()));
            });


        System.out.println("\n----- 4. Trouver le livre le plus ancien dans la bibliothèque (le livre avec la date de publication la plus ancienne) -----\n");
        livres.stream()
            .min(Comparator.comparing(Livre::getDatePublication))
            .ifPresent(livre -> System.out.println("Livre le plus ancien : " + livre.getTitre() + " (de " + livre.getAuteur() + "), publié en " + livre.getDatePublication()));


        System.out.println("\n----- 5. Vérifier s'il existe des livres dont le titre commence par 'Harry' -----\n");
        livres.stream()
                .filter(livre -> livre.getTitre().startsWith("Harry"))
                .forEach(System.out::println);


        System.out.println("\n----- 6. Calculer le prix moyen des livres disponibles dans la bibliothèque -----\n");
        livres.stream()
                .filter(livre -> livre.getEstDisponible())
                .mapToDouble(Livre::getPrix)
                .average()
//                .ifPresent(System.out::println);
                .ifPresent(moyen -> System.out.println("Prix moyen : " + moyen));


        System.out.println("\n---- 7. Trier les livres par nombre de pages, puis par prix (en cas d'égalité du nombre de pages) -----\n");
        livres.stream()
//                .sorted(Comparator.comparing(Livre::getPrix))
//                .sorted(Comparator.comparing(Livre::getNbPages))
                .sorted(Comparator.comparing(Livre::getNbPages).thenComparing(Livre::getPrix)) // Plus court
                .forEach(livre -> System.out.println("Titre : " + livre.getTitre() + ". Nb pages : " + livre.getNbPages() + ". Prix : " + livre.getPrix()));


        System.out.println("\n----- 8. Calculer le total des pages pour tous les livres de genre 'Fantasy' -----\n");
        long grandTotal = livres.stream()
                .filter(entry -> entry.getGenre().equals("Fantasy"))
//                .forEach(entry -> System.out.println("Titre : " + entry.getTitre() + ". Genre : " + entry.getGenre() + ". Nb pages : " + entry.getNbPages()));
                .mapToLong(Livre::getNbPages)
                .sum();
        System.out.println("Total de tous les livres Fantasy : " + grandTotal);


        System.out.println("\n----- 9. Trouver le livre le plus cher disponible à la vente -----\n");
        livres.stream()
                .filter(Livre::getEstDisponible)
                .max(Comparator.comparing(Livre::getPrix))
                .ifPresent(livre -> System.out.println("Livre le plus cher : " + livre.getTitre() + ". Prix : " + livre.getPrix()));


        System.out.println("\n----- 10. Trouver les auteurs les plus prolifiques (les auteurs ayant écrit plus de 17 livres) et afficher leurs livres -----\n");
        livres.stream()
                .collect(Collectors.groupingBy(Livre::getAuteur, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 17)
                .forEach(entry -> System.out.println("Auteur : " + entry.getKey() + ", nombre livres : " + entry.getValue()));


        System.out.println("\n----- 11. Compter le nombre de livres dans chaque genre (afficher par exemple combien de 'Romans', combien de 'Science-fiction', etc.) -----\n");
        livres.stream()
                .collect(Collectors.groupingBy(Livre::getGenre, Collectors.counting()))
                .forEach((genre, count) -> System.out.println(genre + " : " + count));
   

        System.out.println("\n----- 12. Vérifier si un livre est disponible et si son prix est inférieur à un seuil donné, et afficher les livres correspondants -----\n");
        livres.stream()
                .filter(livre -> livre.getEstDisponible())
                .filter(livre -> livre.getPrix() < 10)
                .forEach(System.out::println);

        System.out.println("\n----- 13. Calculer le nombre total de pages pour les livres de chaque année -----\n");
        livres.stream()
                .collect(Collectors.groupingBy(livre -> livre.getDatePublication().getYear(),
                        Collectors.summingLong(Livre::getNbPages)))
                .forEach((annee, totalPages) -> {
                    System.out.println("Année " + annee + " : " + totalPages + " pages");
                });

    }
}