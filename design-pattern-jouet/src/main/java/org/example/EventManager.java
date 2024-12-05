package org.example;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    // ----- Propriétés -----

    private List<Observer> observers = new ArrayList<>();

    // ----- Constructeur -----

    // ----- Méthodes -----

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
