package org.example.ex3;

import java.util.concurrent.Callable;

public class CalculateurCallable implements Callable<Integer> {
    private int nombre;

    public CalculateurCallable(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public Integer call() {
        int cube = nombre * nombre * nombre;
        return cube;
    }

}
