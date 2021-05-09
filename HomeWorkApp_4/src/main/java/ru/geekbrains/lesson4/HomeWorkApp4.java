package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {

    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

    // Set the initial data
    public static final int maxHeigth = 3;
    public static final int maxWidth = 3;
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
           if (gameWinner("X")) {
                System.out.println("Вы победили!");
                break;
           }
           if (gameOver()) {
                System.out.println("Ничья");
                break;
           }
           pC();
           printMap_XO();
           if (gameWinner("O")) {
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
        if (x <0 || x > maxHeigth || y<0 || y > maxWidth) {
            System.out.println("Ваш ход за игровым полем");
            return true;
        } else if (map_XO[x][y] != emptyCell) {
            System.out.println("Ячейка занята");
            return true;
        } else
            System.out.println("Ok ");
            return false;
    }

    public static void human() {
        int x, y;
        do {
            System.out.println("Введите координату Вашего хода по горизонтали: ");
            x = scanner.nextInt() -1;
            System.out.println("Введите координату Вашего хода по вертикали: ");
            y = scanner.nextInt() -1;
        } while (emptyFild(x, y));
        map_XO[x][y] = "X";
    }

    public static void pC() {
        int x, y;
        do {
            x = rand.nextInt(maxHeigth);
            y = rand.nextInt(maxWidth);
        } while (emptyFild(x, y));
        map_XO[x][y] = "O";
    }

    public static boolean gameOver() {

        int result = 0;
        for (int i = 0; i < maxHeigth; i++) {
            for (int j = 0; j < maxWidth; j++) {
                 if (map_XO[i][j] == emptyCell) {
                     result ++;
                 }
            }
        }
        return result == 0;

    }

    public static boolean gameWinner(String str) {
        boolean result_x = false;
        boolean result_y = false;
        boolean result_d = false;

        for (int i = 0; i < maxHeigth; i++) {
            if (result_x) {
                break;
            } else {
                for (int j = 0; j < maxWidth; j++) {
                    if (map_XO[i][j] == str) result_x = true;
                    else {
                        result_x = false;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < maxWidth; i++) {
            if (result_y) {
                break;
            } else {
                for (int j = 0; j < maxHeigth; j++) {
                    if (map_XO[j][i] == str) result_y = true;
                    else {
                        result_y = false;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < maxWidth; i++) {
            if (map_XO[i][i] == str) result_d = true;
                    else {
                        result_d = false;
                        break;
                    }
            }

        if (!result_d) {
            for (int i = 0; i < maxWidth; i++) {
                if (map_XO[i][maxWidth - i - 1] == str) result_d = true;
                else {
                    result_d = false;
                    break;
                }
            }
        }
        return result_x || result_y || result_d;
    }
}

