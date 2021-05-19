package ru.geekbrains.lesson7;

public class Cat extends Animals {
    protected String color;
    protected int appetit;
    protected int health;

    protected Cat(String name, String color, String typeAnimals) {
        super(name, typeAnimals);
    }

    @Override
    public void runAnimals (int value) {
        if(value < 200) {
            if (health > value/10) {
                health -= value / 10;
                System.out.println(name + " ran " + value + "m");
            } else System.out.println(name + " не хватит сил пробежать " +
                    value + "m");
        } else System.out.println(name + " cannot run " + value + "m");
    }

    @Override
    public void swimAnimals (int value) {
        System.out.println(name + "cannot swim");
    }

    public void setAppetit(int appetit) {
        this.appetit = appetit;
    }

    public void setHealth (int health) {
        this.health = health;
    }

    protected void setEatCat(Plats plats, int food) {
        if (appetit > food)
            if (plats.setDecreaseFoot(food)) {
                health += food;
                System.out.println("Я поел");
        } else System.out.println("Я столько не съем!");
    }
}