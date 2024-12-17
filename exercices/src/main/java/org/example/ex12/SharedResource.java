package org.example.ex12;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    // ----- Propriétés -----

    private final List<Integer> sharedList = new ArrayList<>();

    // ----- Getter -----

    public List<Integer> getSharedList() {
        return sharedList;
    }

    // ----- Méthodes -----

    public synchronized void addElement(int element) {
        sharedList.add(element);
        System.out.println(Thread.currentThread().getName() + " a ajouté " + element);
    }

    public synchronized void deleteElement(int element) {
        if (!sharedList.isEmpty()) {
            sharedList.remove(element);
            System.out.println(Thread.currentThread().getName() + " a supprimé " + element);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " n'a rien à supprimer.");
        }
    }

}
