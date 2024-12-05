package org.example;

public class Prefix extends TextDecorator {

    public Prefix(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return "Pré-" + text.transform();
    }
}
