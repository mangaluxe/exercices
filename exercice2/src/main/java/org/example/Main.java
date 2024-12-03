package org.example;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        System.out.printf("Hello and welcome!");

        ArrayList<LibraryItem> items = new ArrayList<>();
        ArrayList<BorrowRecord> records = new ArrayList<>();


        // ----- Ajouter des éléments à une collection -----

        items.add(new Book(1, "Star Wars", 1984, "George Lucas", "Science-Fiction"));

        items.add(new Book(2, "Star Wars 2", 1986, "George Lucas", "Science-Fiction"));

        items.add(new Magazine(3, "Nintendo Magazine", 2010, 50));

        items.add(new Magazine(4, "Sega Magazine", 2000, 60));


        // ----- Lister tous les éléments de la bibliothèque -----

        System.out.println("Liste des éléments  de la bibliothèque :");
        for (LibraryItem i : items) {
            System.out.println(i.getDetails());
        }


        // ----- Emprunter un élément et créer un BorrowRecord -----

        records.add(new BorrowRecord(001, "Tom", "2024-12-02"));
        records.add(new BorrowRecord(002, "Nana", "2024-12-03"));


        // ----- Voir les livres disponibles et ceux empruntés -----

        System.out.println("Liste de livres empruntés :");
        for (BorrowRecord r : records) {
            System.out.println(r);
        }



















    }
}