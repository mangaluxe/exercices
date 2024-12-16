package org.example.ex2;

/* Exercice Java :
Crée une classe `MaTacheRunnable` qui implémente l'interface `Runnable`. La méthode `run()` doit afficher le carré d’un nombre entier donné en paramètre.
Dans la méthode `main`, crée plusieurs threads utilisant cette classe pour calculer les carrés des nombres de 1 à 5.

Exemple :

Le carré de 3 est 9
Le carré de 5 est 25
Le carré de 4 est 16
Le carré de 1 est 1
Le carré de 2 est 4
*/

public class Main {
    public static void main(String[] arg) {

        for (int i = 1; i <= 5; i++) {
            MaTacheRunnable tache = new MaTacheRunnable(i);
            Thread thread = new Thread(tache);
            thread.start();

//            Thread thread = new Thread(new MaTacheRunnable(i)); // Marche aussi
//            thread.start();
        }

    }
}
