package org.example;

public class House {

    // ----- Propriétés -----

    protected int wall;
    protected String roof;
    protected String floor;
    protected int door;

    // ----- Constructeur -----

    public House() {}

    public House(int wall, String roof, String floor, int door) {
        this.wall = wall;
        this.roof = roof;
        this.floor = floor;
        this.door = door;
    }

    // ----- Getters/Setters -----

    public int getWall() {
        return wall;
    }

    public String getRoof() {
        return roof;
    }

    public String getFloor() {
        return floor;
    }

    public int getDoor() {
        return door;
    }

    public void setWall(int wall) {
        this.wall = wall;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    // ----- Méthodes -----

    public void showDetails() {
        System.out.println("Nombre de murs: " + wall + ", Toit: " + roof + ", Sol: " + floor + ", Nombre de portes: " + door);
    }

}
