package org.example.ex12;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    // ----- Propriétés -----

    private final List<Integer> sharedList = new ArrayList<>();
    private final Object object = new Object();

    // ----- Getter -----

    public List<Integer> getSharedList() {
        return sharedList;
    }

    // ----- Méthodes -----

    public void addElement(int element) {
        synchronized (object) {
            sharedList.add(element);
            System.out.println(Thread.currentThread().getName() + " a ajouté " + element);
        }
    }

    public void deleteElement(int element) {
        synchronized (object) {
            if (!sharedList.isEmpty()) {
                int removed = sharedList.remove(0);
                System.out.println(Thread.currentThread().getName() + " a supprimé " + removed);
            }
            else {
                System.out.println(Thread.currentThread().getName() + " n'a rien à supprimer.");
            }
        }
    }

}
