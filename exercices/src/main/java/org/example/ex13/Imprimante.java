package org.example.ex13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Imprimante {

    private static final Lock verrou = new ReentrantLock();

//    public void imprimer() {
//        verrou.lock();
//        try {
//            System.out.println(Thread.currentThread().getName() + " tente d'utiliser l'imprimante...");
//            Thread.sleep(1000);
//            System.out.println(Thread.currentThread().getName() + " a terminé d'utiliser l'imprimante");
//        }
//        catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        finally {
//            verrou.unlock();
//        }
//    }

//    public void imprimer() {
//        if (verrou.tryLock()) {
//            try {
//                System.out.println(Thread.currentThread().getName() + " a acquis le verrou et utilise l'imprimante.");
//                Thread.sleep(1000);
//                System.out.println(Thread.currentThread().getName() + " a terminé d'utiliser l'imprimante");
//            }
//            catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            finally {
//                verrou.unlock();
//            }
//        }
//        else {
//            System.out.println(Thread.currentThread().getName() + " n'a pas pu accéder à l'imprimante.");
//        }
//    }

    public void imprimer(String taskName) {
        try {
            System.out.println(taskName + " tente d'utiliser l'imprimante...");
            if (verrou.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(taskName + " a acpuis le verrou et utiliser l'imprimante");
                    Thread.sleep(1000);
                }
                finally {
                    verrou.unlock();
                    System.out.println(taskName + " a terminé d'utiliser l'imprimante et libère le verrou.");
                }
            }
            else {
                System.out.println(taskName + " n'a pas pu accéder à l'imprimante (temps d'attente dépassé)");
            }
        }
        catch (InterruptedException e) {
            System.out.println(taskName + " a été interrompu.");
        }
    }

}
