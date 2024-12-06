package org.example.decorator;

public abstract class OptionDecorator implements Option {

    protected Option option;

    public OptionDecorator(Option option) {
        this.option = option;
    }

}
