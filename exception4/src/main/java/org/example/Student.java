package org.example;

public class Student {

    // ----- Propriétés -----

    private String name;
    private int age;

    // ----- Constructeur -----

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ----- Getters/Setters -----

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ----- Méthodes -----

    @Override
    public String toString() {
        return "Etudiant [Nom : " + name + ". Age : " + age + "]";
    }
}
