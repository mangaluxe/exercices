package org.example.command;

public class RemoteControl {

    // ----- Propriétés -----

    private Command command;

    // ----- Méthodes -----

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}
