package org.example.ex12;

/* Exercice Java : Synchronisation de blocs

Crée une classe `SharedResource` avec une liste partagée (`List<Integer>`).
Utilise des blocs synchronisés pour garantir qu'un seul thread à la fois puisse ajouter ou supprimer des éléments.
Simule plusieurs threads effectuant ces opérations.

Résultat possible 1 :

Thread-1 a ajouté 0
Thread-1 a ajouté 1
Thread-1 a ajouté 2
Thread-1 a ajouté 3
Thread-1 a ajouté 4
Thread-2 a supprimé 0
Thread-2 a supprimé 1
Thread-2 a supprimé 2
Thread-2 a supprimé 3
Thread-2 a supprimé 4
État final de la liste : []

Résultat possible 2 :

Thread-2 n'a rien à supprimer.
Thread-2 n'a rien à supprimer.
Thread-2 n'a rien à supprimer.
Thread-2 n'a rien à supprimer.
Thread-2 n'a rien à supprimer.
Thread-1 a ajouté 0
Thread-1 a ajouté 1
Thread-1 a ajouté 2
Thread-1 a ajouté 3
Thread-1 a ajouté 4
État final de la liste : [0, 1, 2, 3, 4]
*/

public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.addElement(i);
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.deleteElement(i);
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("État final de la liste : " + sharedResource.getSharedList());

    }
}
