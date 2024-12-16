package org.example;

public class MonPremierThread extends Thread {

    private final String threadName;

    public MonPremierThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
//        super.run();

        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + " - Compteur : " + i);
        }
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            System.out.println("Thread " + getName() + " interrompu.");
        }

    }
}
