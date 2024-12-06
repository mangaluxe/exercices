package org.example;

public class HouseBaseBuilder implements HouseBuilder {

    private House house = new House();

    // ----- Méthodes -----

    @Override
    public void setWall(int wall) {
        house.setWall(wall);
    }

    @Override
    public void setRoof(String roof) {
        house.setRoof(roof);
    }

    @Override
    public void setFloor(String floor) {
        house.setFloor(floor);
    }

    @Override
    public void setDoor(int door) {
        house.setDoor(door);
    }

    @Override
    public House build() {
        return house;
    }

}
