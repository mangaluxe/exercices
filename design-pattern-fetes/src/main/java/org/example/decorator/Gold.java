package org.example.decorator;

public class Gold extends OptionDecorator {

    public Gold(Option option) {
        super(option);
    }

//    @Override
    public String description() {
        return option.description() + ", avec place Gold.";
    }

}
