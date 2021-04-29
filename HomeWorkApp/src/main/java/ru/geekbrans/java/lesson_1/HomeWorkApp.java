package ru.geekbrans.java.lesson_1;

public class HomeWorkApp {

    public static void main(String[] args) {

        printThreeWorks();
        checkSumSign();
        printColor();
        compareNumber();
    }

    public static void printThreeWorks() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = - 5;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная ");
        }
        else
            System.out.println("Сумма отрицательная ");

    }

    public static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) System.out.println("Зеленый");

    }

    public static void compareNumber() {
        int a = 10;
        int b = 15;

        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }

    }
    
}