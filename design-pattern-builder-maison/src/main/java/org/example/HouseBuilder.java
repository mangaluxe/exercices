package org.example;

// Interface `HouseBuilder` pour définir les étapes de construction

public interface HouseBuilder {

    void setWall(int wall); // Nombre de Murs
    void setRoof(String roof); // Type de Toit
    void setFloor(String floor); // Type de Sol
    void setDoor(int door); // Nombre de Portes

    House build();

}
