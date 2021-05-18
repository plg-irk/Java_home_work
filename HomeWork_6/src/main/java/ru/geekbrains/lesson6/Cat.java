package ru.geekbrains.lesson6;

public class Cat extends Animals {
    protected String color;

    protected Cat(String name, String color, String typeAnimals) {
        super(name, typeAnimals);
    }

    @Override
        public void runAnimals (int value) {
        if(value < 200)
            System.out.println(name + " ran " + value + "m");
        else System.out.println(name + " cannot run " + value + "m");
    }

    @Override
    public void swimAnimals (int value) {
        System.out.println(name + "cannot swim");
    }
}
