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
           if (gameWinner("X", valWinner) || gameWinnerD("X", valWinner)) {
                System.out.println("Вы победили!");
                break;
           }
           if (gameOver()) {
                System.out.println("Ничья");
                break;
           }
           pC();
           printMap_XO();
           if (gameWinner("O", valWinner)|| gameWinnerD("O", valWinner)) {
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
// Ход игрока
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
// Проверка комбинаций по X и Y с учетом того, что
// комбинация может начинаться не с верхнего ряда,
// через счетчик, где параметр "a" кол-во комбинаций

        boolean result_x = false;
        boolean result_y = false;
        int k;

        for (int i = 0; i < maxHeigth; i++) {
            if (result_x) {
                break;
            } else {k = 0;
                for (int j = 0; j < maxWidth; j++) {
                    if (map_XO[i][j] == str) {
                        k++;
                        if (k == a) {
                            result_x = true;
                            break;
                        }
                    } else if (i == 0 || j == 0 && map_XO[i][j] == emptyCell) continue;
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
            } else {k = 0;
                for (int j = 0; j < maxHeigth; j++) {
                    if (map_XO[j][i] == str) {
                        k++;
                        if (k == a) {
                            result_y = true;
                            break;
                        }
                    } else if (i == 0 || j == 0 && map_XO[i][j] == emptyCell) continue;
                    else {
                        result_y = false;
                        break;
                    }
                }
            }
        }

        return result_x || result_y;
    }

    public static boolean gameWinnerD(String str, int a) {
// Проверка комбинаций по диагоналям
        boolean result_d = false;
        int k;

        for (int j = 0; j < 2; j++) {
            if (result_d) break;
            else {
                k = 0;
                for (int i = 0; i < maxWidth - j; i++) {
                    if (map_XO[i + j][i] == str) {
                        k++;
                        if (k == a) {
                            result_d = true;
                            break;
                        }
                    } else if (i == 0 || j == 0 && map_XO[i+j][j] == emptyCell) continue;
                    else {
                        result_d = false;
                        break;
                    }
                }
            }
        }

        for (int j = 0; j < 2; j++) {
            if (result_d) break;
            else {
                k = 0;
                for (int i = 0; i < maxWidth - j; i++) {
                    if (map_XO[i][i+j] == str) {
                        k++;
                        if (k == a) {
                            result_d = true;
                            break;
                        }
                    } else if (i == 0 || j == 0 && map_XO[i][i+j] == emptyCell) continue;
                    else {
                        result_d = false;
                        break;
                    }
                }
            }
        }

        for (int j = 0; j < 2; j++) {
            if (result_d) break;
            else {
                k = 0;
                for (int i = 0; i < maxWidth - j; i++) {
                    if (map_XO[i][maxWidth - i - 1 - j] == str) {
                        k++;
                        if (k == a) {
                            result_d = true;
                            break;
                        }
                    } else if (i == 0 || j == 0 && map_XO[i][maxWidth - i - 1 - j] == emptyCell) continue;
                    else {
                        result_d = false;
                        break;
                    }
                }
            }
        }

        for (int j = 0; j < 2; j++) {
            if (result_d) break;
            else {
                k = 0;
                for (int i = 0; i < maxWidth - j; i++) {
                    if (map_XO[i+j][maxWidth - i - 1] == str) {
                        k++;
                        if (k == a) {
                            result_d = true;
                            break;
                        }
                    } else if (i == 0 || j == 0 && map_XO[i+j][maxWidth - i - 1] == emptyCell) continue;
                    else {
                        result_d = false;
                        break;
                    }
                }
            }
        }


        return result_d;
    }

    public static void sumCol() {
        for (int i = 0; i < maxHeigth; i++) {
            for (int j = 0; j < maxWidth; j++) {

            }

        }
    }


}

