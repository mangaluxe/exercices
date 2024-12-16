package org.example.ex2;

public class MaTacheRunnable implements Runnable {

    private final int nombre;

    public MaTacheRunnable(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        int carre = nombre * nombre;
        System.out.println("Le carre de " + nombre + " est " + carre);
    }

}
