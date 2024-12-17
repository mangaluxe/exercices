package org.example.ex11;

public class BankAccount {

    // Implémente une classe `BankAccount` avec deux méthodes synchronisées : `deposit()` et `withdraw()`.

    private int balance;

    public BankAccount(int initial) {
        this.balance = initial;
    }

    public synchronized void depot(int montant) {
        balance += montant;
        System.out.println(Thread.currentThread().getName() + " a déposé " + montant + ", solde actuel : " + balance);
    }

    public synchronized void retirer(int montant) {
        if (montant > balance) {
            System.out.println(Thread.currentThread().getName() + " n'a pas pu retirer " + montant + " (solde insuffisant). Solde actuel : " + balance);
        }
        else {
            balance -= montant;
            System.out.println(Thread.currentThread().getName() + " a retiré " + montant + ", solde actuel : " + balance);
        }
    }

}
