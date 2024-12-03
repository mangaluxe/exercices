package org.example;

public class BorrowRecord {

    // ----- Propriétés -----

    private int itemId;
    private String borrowerName;
    private String borrowDate;

    // ----- Constructeur -----

    public BorrowRecord(int itemId, String borrowerName, String borrowDate) {
        this.itemId = itemId;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
    }

    // ----- Getters -----

    public int getItemId() {
        return itemId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    // ----- Méthodes -----

    @Override
    public String toString() {
        return "Item ID: " + itemId + ", Borrower: " + borrowerName + ", Borrow Date: " + borrowDate;
    }

}
