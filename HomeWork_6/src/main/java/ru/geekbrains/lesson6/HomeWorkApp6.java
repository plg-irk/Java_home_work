package ru.geekbrains.lesson6;

public class HomeWorkApp6 {

    public static void main(String[] args) {

        Animals[] arrayAnimals = new Animals[5];

        arrayAnimals[0] = new Cat("Murzik","blak", "cat");
        arrayAnimals[1] = new Cat("cat","white", "cat");
        arrayAnimals[2] = new Cat("Murka", "redhead","cat");
        arrayAnimals[3] = new Dog("Bobik", "dog");
        arrayAnimals[4] = new Dog("Sharik", "dog");

        int numCat = 0;
        int numDog = 0;
        for (Animals arrayAnimal : arrayAnimals) {
            if (arrayAnimal.typeAnimals.equals ("cat")) numCat++;
            else numDog++;
        }
        System.out.println("Animals= " + arrayAnimals.length + "\n" +
                "Cats= " + numCat + "\n" +
                "Dogs= " + numDog + "\n");
    }

}
