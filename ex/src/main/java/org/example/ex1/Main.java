package org.example.ex1;

/* Exercice Java :
Crée une classe `MonPremierThread` qui étend `Thread` et redéfinit la méthode `run()` pour afficher un message
contenant le nom du thread et un compteur (par exemple, de 1 à 10).
Dans la méthode `main`, crée et démarre 3 threads de cette classe.
*/

public class Main {
    public static void main(String[] args) {

//        MonPremierThread t1 = new MonPremierThread();
//        MonPremierThread t2 = new MonPremierThread();
//        MonPremierThread t3 = new MonPremierThread();
//        t1.start();
//        t2.start();
//        t3.start();

        // ----- Avec boucle (pour ne pas répéter) -----

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MonPremierThread());
            thread.start();
        }

    }
}