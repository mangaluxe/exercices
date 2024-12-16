package org.example.ex1;

/* Exercice Java :
Crée une classe `MonPremierThread` qui étend `Thread` et redéfinit la méthode `run()` pour afficher un message
contenant le nom du thread et un compteur (par exemple, de 1 à 10).
Dans la méthode `main`, crée et démarre 3 threads de cette classe.
*/

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MonPremierThread("Thread-" + i));
            thread.start();
        }

    }
}