package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {

    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

    // Set the initial data
    public static final int maxHeigth = 5;
    public static final int maxWidth = 5;
    public static final int valWinner = 4;
    public static final String emptyCell = "_";
    public static final String[][] map_XO = new String[maxHeigth][maxWidth];

    public static void main(String[] args) {

        for (int i = 0; i < maxHeigth; i++) {
            for (int j = 0; j < maxWidth; j++) {
                map_XO[i][j] = emptyCell;
            }
        }

        printMap_XO();

       while (true) {
           human();
           printMap_XO();
           if (gameWinner("X", valWinner) ) {
                System.out.println("Вы победили!");
                break;
           }
           if (gameOver()) {
                System.out.println("Ничья");
                break;
           }
           pC();
           printMap_XO();
           if (gameWinner("O", valWinner)) {
                System.out.println("Победил компьютер");
                break;
           }
           if (gameOver()) {
                System.out.println("Ничья");
                break;
           }
       }
    }

    public static void printMap_XO() {
        // Printing a field of the game
        for (int i = 0; i < maxHeigth; i++) {
            for (int j = 0; j < maxWidth; j++) {
                System.out.print(map_XO[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("*****************");
    }

    public static boolean emptyFild(int x, int y) {
// Праверка на возможность хода
        if (outFild(x, y)) return true;
        else if (map_XO[x][y] != emptyCell) {
            System.out.println("Ячейка занята");
            return true;
        } else
            System.out.println("Ok ");
            return false;
    }

    public static boolean outFild(int i, int j) {
// Праверка на ход в не поля
        if (i <0 || i >= maxHeigth || j<0 || j >= maxWidth) {
            System.out.println("Ваш ход за игровым полем");
            return true;
        } else
        return false;
    }

    public static void human() {
// Ход игрока
        int x, y;
        do {
            System.out.println("Введите координату Вашего хода по горизонтали: ");
            x = scanner.nextInt() -1;
            System.out.println("Введите координату Вашего хода по вертикали: ");
            y = scanner.nextInt() -1;
        } while (outFild(x, y) || emptyFild(x, y));
        map_XO[x][y] = "X";
    }

    public static void pC() {
// Ход компьютера
        int x, y;
        do {
            x = rand.nextInt(maxHeigth);
            y = rand.nextInt(maxWidth);
        } while (emptyFild(x, y));
        map_XO[x][y] = "O";
    }

    public static boolean gameOver() {
// Проверка на наличие пустых ячеек
        for (int i = 0; i < maxHeigth; i++) {
            for (int j = 0; j < maxWidth; j++) {
                 if (map_XO[i][j] == emptyCell) {
                     return false;
                 }
            }
        }
        return true;

    }

    public static boolean gameWinner(String str, int a) {

        boolean result_x = false;
        boolean result_y = false;
        boolean result_d = false;
        boolean result_d1 = false;


        for (int i = 0; i < maxHeigth; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (map_XO[i][j] == str) {

                    if (!outFild(i, j+a-1)) {
                        int val_y =0;
                        for (int k = 0; k < a; k++) {
                            if (map_XO[i][j + k] == str)
                                val_y ++;
                            if (val_y == a) result_y = true;
                        }
                    }

                    if (!outFild(i+a-1, j)) {
                        int val_x =0;
                        for (int k = 0; k < a; k++) {
                            if (map_XO[i+k][j] == str)
                                val_x ++;
                            if (val_x == a) result_y = true;
                        }
                    }

                    if (!outFild(i+a-1, j+a-1)) {
                        int val_d =0;
                        for (int k = 0; k < a; k++) {
                            if (map_XO[i+k][j+k] == str)
                                val_d ++;
                            if (val_d == a) result_d = true;
                        }
                    }

                    if (!outFild(i+a-1, j-a+1)) {
                        int val_d1 =0;
                        for (int k = 0; k < a; k++) {
                            if (map_XO[i+k][j-k] == str)
                                val_d1 ++;
                            if (val_d1 == a) result_d1 = true;
                        }
                    }

                }

            }

        }
        return result_x == true || result_y == true || result_d == true || result_d1 == true;
    }

}
