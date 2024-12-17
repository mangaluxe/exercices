package org.example.ex11;

public class BankAccount {

    // Implémente une classe `BankAccount` avec deux méthodes synchronisées : `deposit()` et `withdraw()`.

    // ----- Propriétés -----

    private int balance;

    // ----- Constructeur -----

    public BankAccount(int initial) {
        this.balance = initial;
    }

    // ----- Getter -----

    public int getBalance() {
        return balance;
    }

    // ----- Méthodes -----

    public synchronized void deposer(int montant) {
        balance += montant;
        System.out.println(Thread.currentThread().getName() + " a déposé " + montant + ". Solde actuel : " + balance);
    }

    public synchronized void retirer(int montant) {
        if (montant > balance) {
            System.out.println(Thread.currentThread().getName() + " n'a pas pu retirer " + montant + " (solde insuffisant). Solde actuel : " + balance);
        }
        else {
            balance -= montant;
            System.out.println(Thread.currentThread().getName() + " a retiré " + montant + ". Solde actuel : " + balance);
        }
    }

}
