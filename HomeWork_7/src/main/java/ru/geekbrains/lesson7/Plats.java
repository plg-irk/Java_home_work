package ru.geekbrains.lesson7;

    public class Plats {
        static int food;
        static int food_value;

        public void ValueFood (int food) {
            System.out.println("Food in plate= " + food);
        }

        public boolean setDecreaseFoot (int food) {
            if (food_value - food > 0) {
                food_value -= food;
                return true;
            } else {
                System.out.println("В тарелке мало еды");
                return false;
            }
        }

        public void setIncreaseFoot(int food) {
            food_value += food;
        }
    }