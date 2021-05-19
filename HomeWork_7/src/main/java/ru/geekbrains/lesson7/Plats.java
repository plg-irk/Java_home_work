package ru.geekbrains.lesson7;

public class Dog extends Animals {

    protected Dog(String name, String typeAnimals) {
        super(name, typeAnimals);
    }

    @Override
    public void runAnimals (int value) {
        if(value < 500)
            System.out.println(name + " ran " + value + "m");
        else System.out.println(name + " cannot run " + value + "m");
    }

    @Override
    public void swimAnimals (int value) {
        if (value < 10)
            System.out.println(name + " swam " + value + "m");
        else System.out.println(name + " cannot swim " + value + "m");
    }
}