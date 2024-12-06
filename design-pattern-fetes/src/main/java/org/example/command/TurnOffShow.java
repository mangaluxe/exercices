package org.example.command;

public class TurnOffShow implements Command {

    // ----- Propriétés -----

    private Show show;

    // ----- Constructeur -----

    public TurnOffShow(Show show) {
        this.show = show;
    }

    // ----- Méthodes -----

    public void execute() {
        show.showEnd();
    }

}
