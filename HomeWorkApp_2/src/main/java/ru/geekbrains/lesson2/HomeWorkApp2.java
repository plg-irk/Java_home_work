package ru.geekbrains.lesson2;

public class HomeWorkApp2 {

    public static void main(String[] args) {

        System.out.println(sumInt_10_20(5, 6));
        printSingInt(2);
        System.out.println(negativeInt(0));
        printRepeatString("Oh!Java", 3);
        System.out.println("Is leap year? " + yearLeap(2016));

    }

    public static boolean sumInt_10_20 (int a, int b) {
        // Проверка: 10 < (a + b) <= 20, предположил, что по условию
        // включительно только для 20
        return (a + b) <= 20 && (a + b) > 10;
    }

    public static void printSingInt (int a) {

        System.out.println((a >= 0) ? "Positive" : "Negative" );
    }

    public static boolean negativeInt (int a) {
        return a < 0;
    }

    public static void printRepeatString (String str, int a) {

        for (int i = 0; i < a; i++) {
            System.out.println (str);
        }
    }

    public static boolean yearLeap (int a) {

        if (a % 400 == 0) {
            return true;
        } else
        {if (a % 100 == 0 || a % 4 != 0) {
            return false;
        } else {
            return true;
        }
        }
    }

}
