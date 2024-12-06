package org.example;

public class addSongCommand implements Command {

    // ----- Propriétés -----

    private Playlist playlist;

    // ----- Constructeur -----

    public addSongCommand(Playlist playlist) {
        this.playlist = playlist;
    }

    // ----- Méthodes -----

    @Override
    public void execute() {
        playlist.addSong();
    }
}
