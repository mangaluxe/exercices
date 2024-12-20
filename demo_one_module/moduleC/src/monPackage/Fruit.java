package monPackage;

public class Fruit {

    private String nom;
    private String colour;

    public Fruit(String nom, String colour) {
        this.nom = nom;
        this.colour = colour;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "nom='" + nom + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
