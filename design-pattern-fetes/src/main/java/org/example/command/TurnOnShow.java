package org.example.command;

public class TurnOnShow implements Command {

    // ----- Propriétés -----

    private Show show;

    // ----- Constructeur -----

    public TurnOnShow(Show show) {
        this.show = show;
    }

    // ----- Méthodes -----

    public void execute() {
        show.showBegin();
    }

}
