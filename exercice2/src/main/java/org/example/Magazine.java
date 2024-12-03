package org.example;

public class Magazine extends LibraryItem { // Sous-class (Héritée de LibraryItem)

    // ----- Propriétés -----

    private int issueNumber; // Numéro de série

    // ----- Constructeur -----

    public Magazine(int id, String title, int publicationYear, int issueNumber) {
        super(id, title, publicationYear);
        this.issueNumber = issueNumber;
    }

    // ----- Getters -----

    public int getIssueNumber() {
        return issueNumber;
    }

    // ----- Méthodes -----

    @Override
    public String getDetails() {
        return "Magazine: : [Titre : " + getTitle() + ", Issue No: " + issueNumber + ", Year: " + getPublicationYear() + "]";
    }

}