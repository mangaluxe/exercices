package org.example;

import java.util.ArrayList;
import java.util.List;

public class EventManager { // Ajouter et Notifier des observateurs

    // ----- Propriétés -----

    private int eventCount = 0;
    private List<Observer> observers = new ArrayList<>();

    // ----- Constructeur -----

    public EventManager(int eventCount) {
        this.eventCount = eventCount;
    }

    // ----- Getters/Setters -----

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
        notifyObservers();
    }


    // ----- Méthodes -----

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(String.valueOf(eventCount));
        }
    }


}
