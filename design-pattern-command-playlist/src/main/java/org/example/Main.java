package org.example;

/*
Exercice : Command - Gestion d'une Playlist

Objectif :
Utilisez le pattern Command pour gérer une playlist de musique en ajoutant ou supprimant des chansons.

Tâches :
1. Implémentez une classe `Playlist` pour gérer les chansons.
2. Créez des commandes concrètes pour ajouter et supprimer des chansons.
3. Testez dans une classe principale en simulant l'ajout et la suppression de chansons.
*/

public class Main {
    public static void main(String[] args) {

        Playlist playlist = new Playlist();

        Command addSong = new addSongCommand(playlist);
        Command deleteSong = new deleteSongCommand(playlist);

        RemoteControl remoteControl = new RemoteControl();

        // ----- Ajouter chanson de la playlist -----

        remoteControl.setCommand(addSong);
        remoteControl.execute();

        // ----- Supprimer chanson de la playlist -----

        remoteControl.setCommand(deleteSong);
        remoteControl.execute();

    }
}