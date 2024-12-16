package org.example.ex4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutorService {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executor.submit(() -> System.out.println("Tâche " + finalI + " exécutée par " + Thread.currentThread().getName()));
        }
        executor.shutdown();
    }
}