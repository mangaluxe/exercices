package org.example;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    // ----- Propriétés -----

    private String name;
    private List<Employee> employees = new ArrayList<>();

    // ----- Constructeur -----

    public Manager(String name) {
        this.name = name;
    }

    // ----- Méthodes -----

    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Nom du manager : " + name);
    }

}
