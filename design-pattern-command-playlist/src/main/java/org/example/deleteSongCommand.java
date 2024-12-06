package org.example;

public class deleteSongCommand implements Command {

    // ----- Propriétés -----

    private Playlist playlist;

    // ----- Constructeur -----

    public deleteSongCommand(Playlist playlist) {
        this.playlist = playlist;
    }

    // ----- Méthodes -----

    @Override
    public void execute() {
        playlist.deleteSong();
    }
}
