package org.example;

public class TraditionalHouseBuilder implements HouseBuilder {

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

        if (house.getWall() == 0) {
            house.setWall(6); // Murs
        }

        if (house.getRoof() == null) {
            house.setRoof("Toit traditionnel");
        }

        if (house.getFloor() == null) {
            house.setFloor("Sol traditionnel");
        }

        if (house.getDoor() == 0) {
            house.setDoor(6); // Portes
        }

        return house;
    }

    /**
     * Ajouter cheminée pour maison traditionelle
     */
    public void addChimey() {
        System.out.println("Ajout d'un cheminée");
    }

}
