package org.example.ex1;

public class MonPremierThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + " - Compteur : " + i);
        }
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            System.out.println("Thread " + getName() + " interrompu.");
        }

    }
}
