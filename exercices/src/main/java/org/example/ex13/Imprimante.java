package org.example.ex13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Imprimante {

    private static final Lock verrou = new ReentrantLock();

    public void utiliser() {
        verrou.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " tente d'utiliser l'imprimante...");
        }
        finally {
            verrou.unlock();
        }
    }

    public void utiliser2() {
        if (verrou.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " a acquis le verrou et utilise l'imprimante.");
            }
            finally {
                verrou.unlock();
            }
        }
        else {
            System.out.println(Thread.currentThread().getName() + " n'a pas pu accéder à l'imprimante.");
        }
    }

    public void utiliser3() {
        try {
            if (verrou.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " a terminé d'utiliser l'imprimante et libère le verrou");
                }
                finally {
                    verrou.unlock();
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + " n'a pas pu accéder à l'imprimante (temps d'attente dépassé)");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
