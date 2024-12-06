package org.example;

public class RemoteControl {

    // ----- Propriétés -----

    private Command command;

    // ----- Méthodes -----

    /**
     * Définir la commande actuelle
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

}
