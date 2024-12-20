import monPackage.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Fruit fruit;

    public static void main(String[] args) {

        List<Fruit> listeFruit = new ArrayList<>();
        listeFruit.add(new Fruit("Pomme", "Rouge"));
        listeFruit.add(new Fruit("Banane", "Jaune"));
        listeFruit.add(new Fruit("Orange", "Orange"));

        for (Fruit fruit : listeFruit) {
            System.out.println(fruit.getNom());
        }
        
    }
}
