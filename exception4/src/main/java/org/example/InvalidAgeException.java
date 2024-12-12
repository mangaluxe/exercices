package org.example;

// Exception personnalisée

public class InvalidAgeException extends Exception {

    // ----- Constructeur -----

    public InvalidAgeException(String message) {
        super(message);
    }

}
