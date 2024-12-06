package org.example.builder;

import java.time.LocalDate;
import java.util.Date;

public class Event {

    // ----- Propriétés -----

    private String eventName;
    private LocalDate eventDate;
    private String address;

    // ----- Constructeur -----

    private Event(EventBuilder builder) {
        this.eventName = builder.eventName;
        this.eventDate = builder.eventDate;
        this.address = builder.address;
    }

    // ----- Méthodes -----

    public String toString() {
        return "Evènement : " + eventName + " du " + eventDate + " à l'addresse : " + address;
    }

    // ----- Classe imbriquée -----

    public static class EventBuilder { // Class dans une class. On le met en statique pour ne pas devoir l'instancier

        // --- Propriétés ---

        private String eventName;
        private LocalDate eventDate;
        private String address;

        // --- Méthodes ---

        public EventBuilder setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public EventBuilder setEventDate(LocalDate eventDate) {
            this.eventDate = eventDate;
            return this;
        }

        public EventBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Event build() {
            return new Event(this);
        }

    }

}
