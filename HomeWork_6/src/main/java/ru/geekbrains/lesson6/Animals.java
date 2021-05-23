package ru.geekbrains.lesson6;

public class Animals {
    protected String name;
    protected String typeAnimals;


    protected Animals(String name, String typeAnimals) {
        this.name = name;
        this.typeAnimals = typeAnimals;
    }

    public void runAnimals (int value) {
        System.out.println(name + " ran " + value + "m");
    }

    public void swimAnimals (int value) {
        System.out.println(name + " swam " + value + "m");
    }

}
