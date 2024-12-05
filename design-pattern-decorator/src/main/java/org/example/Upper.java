package org.example;

public class Upper extends TextDecorator {

    public Upper(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return text.transform().toUpperCase();
    }

}
