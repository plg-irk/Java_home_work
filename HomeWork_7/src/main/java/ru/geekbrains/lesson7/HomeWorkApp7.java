package ru.geekbrains.lesson7;

public class HomeWorkApp7 {

    public static void main(String[] args) {

        Cat catMurka = new Cat("Murka", "white", "cat");
        Plats platfood = new Plats ();

        catMurka.appetit = 15;
        catMurka.health = 20;

        platfood.setIncreaseFoot(100);


        catMurka.runAnimals(150);
        catMurka.runAnimals(100);

        catMurka.setEatCat(platfood, 12);
        catMurka.setEatCat(platfood, 10);
    }


}
