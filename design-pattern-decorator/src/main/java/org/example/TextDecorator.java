package org.example;

public abstract class TextDecorator implements Text {

    // ----- Propriétés ----

    protected Text text;

    // ----- Constructeur -----

    public TextDecorator(Text text) {
        this.text = text;
    }
}
