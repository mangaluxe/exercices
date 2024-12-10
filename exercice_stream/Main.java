package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
// import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Collectors;

/*
Exercice Java Stream

1. Lecture et affichage basique avec Streams
    - Utiliser un Stream pour lire le fichier CSV et afficher les 10 premiers films.
    - Afficher tous les titres des films en utilisant un Stream.

2. Filtrage avec Streams
    - Trouver tous les films d'un genre donné (par exemple : "Action") et affichez leur titre et leur année de sortie.
    - Filtrer les films réalisés après l'année 2000 et affichez uniquement leurs titres.
    - Afficher les films réalisés par un réalisateur spécifique (par exemple : "Michael Webster").

3. Tri et limitation avec Streams
    - Trier les films par nombre d'entrées (ordre croissant) et affichez les 5 premiers.
    - Trier les films par date de sortie (ordre croissant) et affichez leurs titres.
    - Afficher les 10 films avec le plus petit nombre d'entrées, triés par nombre d'entrées.

4. Regroupement avec Streams
    - Regrouper les films par genre et afficher le nombre de films dans chaque genre.
    - Regrouper les films par réalisateur et afficher les titres des films de chaque réalisateur.

5. Calculs avec Streams
    - Calculer le total des entrées au cinéma pour tous les films.
    - Trouver le genre avec le plus grand nombre total d'entrées en utilisant un Stream.
    - Calculer la moyenne des entrées pour les films d'un réalisateur donnée.

6. Transformation avec Streams
    - Transformer les données pour afficher une liste des films sous la forme : "Titre (Genre) - Réalisé par Réalisateur en Année".
    - Créer une liste contenant uniquement les genres uniques présents dans le fichier.

7. Questions avancées
    - Trouver le premier film (par date) dans chaque genre en utilisant un Stream.
    - Identifier les réalisateurs ayant réalisé plus de 50 films, en utilisant un Stream pour compter.
    - Calculer le nombre total d'entrées pour les films sortis entre deux années données (par exemple : 1990 et 2000).
*/


public class Main {
    public static void main(String[] args) {

        String csvFile = "src/main/resources/films.csv";
        String delimiter = ","; // Séparateur utilisé dans CSV

        List<Film> films = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.lines()
                    .skip(1)
                    .map(line -> line.split(delimiter))
                    .map(values -> {
                        String titre = values[0];
                        LocalDate dateSortie = LocalDate.parse(values[1]);
                        String realisateur = values[2];
                        String genre = values[3];
                        long nombreEntrees = Long.parseLong(values[4]);
                        return new Film(titre, dateSortie, realisateur, genre, nombreEntrees);
                    })
                    .forEach(film -> films.add(film)); // Ajouter chaque film à la liste films
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // ========== ==========

        System.out.println("\n----- 1. Afficher les 10 premiers films -----\n");
        films.stream()
                .limit(10)
//                .forEach(System.out::println);
                .forEach(film -> System.out.println(film));


        System.out.println("\n----- Afficher tous les titres des films -----\n");
        films.stream()
                .map(Film::getTitre)
//                .forEach(System.out::println);
                .forEach(titre -> System.out.println("Titre : " + titre));


        System.out.println("\n----- 2. Afficher les films du genre 'Animation' -----\n");
        films.stream()
                .filter(film -> film.getGenre().equals("Animation"))
                .forEach(film -> {
                    System.out.println("Titre : " + film.getTitre() + ", Année de sortie : " + film.getDateSortie().getYear());
                });


        System.out.println("\n----- Films après 2000 -----\n");
        films.stream()
                .filter(film -> film.getDateSortie().getYear() > 2000)
                .forEach(film -> System.out.println(film.getTitre()));


        System.out.println("\n----- Afficher les films réalisés par un réalisateur spécifique -----\n");
        films.stream()
                .filter(film -> film.getRealisateur().equals("Anthony Daniels"))
                .forEach(film -> System.out.println(film.getTitre()));


        System.out.println("\n----- 3. Trier les films par nombre d'entrées (ordre croissant) et afficher les 5 premiers -----\n");
        films.stream()
                .sorted(Comparator.comparing(Film::getNombreEntrees))
                .limit(5)
                .forEach(film -> System.out.println(film.getTitre()));

        // https://medium.com/@coffeeandtips.tech/using-comparator-comparing-to-sort-java-stream-a6e0302dce1a


        System.out.println("\n----- Trier les films par date de sortie (ordre croissant) et afficher leurs titres -----\n");
        films.stream()
                .sorted(Comparator.comparing(Film::getDateSortie))
                .forEach(film -> System.out.println(film.getTitre()));


        System.out.println("\n----- Afficher les 10 films avec le plus petit nombre d'entrées, triés par nombre d'entrées -----\n");
        films.stream()
                .sorted(Comparator.comparing(Film::getNombreEntrees))
                .forEach(film -> System.out.println(film.getTitre()));


        System.out.println("\n----- 4. Regrouper les films par genre et afficher le nombre de films dans chaque genre -----\n");
        films.stream()
                .sorted(Comparator.comparing(Film::getGenre))
                // .collect(groupingBy(Film::getGenre))
                .collect(Collectors.groupingBy(Film::getGenre))
                .forEach((genre, getTitre) -> System.out.println(genre + " : " + getTitre.size()));


        System.out.println("\n----- Regrouper les films par réalisateur et afficher les titres des films de chaque réalisateur -----\n");
        films.stream()
                .sorted(Comparator.comparing(Film::getRealisateur))
                // .collect(groupingBy(Film::getRealisateur))
                .collect(Collectors.groupingBy(Film::getRealisateur))
                .forEach((realisateur, getTitre) -> System.out.println(realisateur + " : " + getTitre.size()));


        System.out.println("\n----- 5. Calculer le total des entrées au cinéma pour tous les films -----\n");
        films.stream()
                // .forEach(System.out.println(getTitre.size()));
                .forEach(film -> {
                    System.out.println(film.getTitre() + ". Nb entrées : " + film.getNombreEntrees());
                });


        System.out.println("\n----- Trouver le genre avec le plus grand nombre total d'entrées au cinéma -----\n");
        films.stream()
                .max(Comparator.comparing(Film::getNombreEntrees))
                .ifPresent(film -> System.out.println(film.getGenre() + " : " + film.getNombreEntrees()));

        // https://howtodoinjava.com/java8/stream-max-min-examples/


        System.out.println("\n----- Calculer la moyenne des entrées pour les films d'un réalisateur donnée -----\n");



        System.out.println("\n----- 6. Transformer les données pour afficher une liste des films sous la forme \"Titre (Genre) - Réalisé par Réalisateur en Année\" -----\n");
        films.stream()
                .forEach(film -> System.out.println(film.getTitre() + " (" + film.getGenre() + ") - Réalisé par " + film.getRealisateur() + " en " + film.getDateSortie().getYear()));


        System.out.println("\n----- Créer une liste contenant uniquement les genres uniques présents dans le fichier -----\n");
        films.stream()
                .map(Film::getGenre)
                .distinct()
                .forEach(System.out::println);

        // https://howtodoinjava.com/java8/java-stream-distinct-examples/


        System.out.println("\n----- 7. Trouver le premier film (par date) dans chaque genre -----\n");
        films.stream()
                .sorted(Comparator.comparing(Film::getDateSortie))
                .forEach(film -> System.out.println(film.getTitre()));


        System.out.println("\n----- Identifier les réalisateurs ayant réalisé plus de 50 films -----\n");
        // films.stream()
        //         .filter(film -> film.getRealisateur().length() > 50)
        //         .collect(Collectors.groupingBy(Film::getRealisateur))
        //         .forEach(System.out::println);


        System.out.println("\n----- Calculer le nombre total d'entrées pour les films sortis entre deux années données (par exemple : 1990 et 2000) -----\n");
        films.stream()
                .filter(film -> film.getDateSortie().getYear() >= 1990 && film.getDateSortie().getYear() <= 2000)
                .forEach(film -> System.out.println(film.getTitre()));

    }
}