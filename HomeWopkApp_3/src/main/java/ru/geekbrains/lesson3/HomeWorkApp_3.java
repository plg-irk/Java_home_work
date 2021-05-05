package ru.geekbrains.lesson3;

import java.util.Arrays;

public class HomeWorkApp_3 {

    public static void main(String[] args) {
        
        int[] array = {0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1};
        System.out.println("begin= " + Arrays.toString(array));
        System.out.println("final= " + Arrays.toString(changeElementArr(array)));
        System.out.println();

        int[] arrFinal = new int[100];
        System.out.println("Array value= " + Arrays.toString(myIntArray(arrFinal, arrFinal.length)));
        System.out.println();

        int[] arrMulti = {12, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, -1};
        System.out.println(Arrays.toString(multiArray(arrMulti, 6, 2 )));;
        System.out.println();

        int[][] array2D = new int[5][5];
        print2DArray(d2Table(array2D));
        System.out.println();

        System.out.println(Arrays.toString(fillArray("Java", 5)));
        System.out.println();

        System.out.println(Arrays.toString(arrMulti));
        minMaxArray(arrMulti);
        System.out.println();

        int[] table = {0, 1, 2, 3};
        System.out.println(sumArray(table));
        System.out.println();

        System.out.println(Arrays.toString(table));
        System.out.println(Arrays.toString(shiftElementArray(table, 1)));
    }

    public static int[] changeElementArr (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 1 ? 0 : 1);
        }
        return arr;
    }

    public static int[] myIntArray(int[] array, int lenArray) {
        for (int i = 0; i < lenArray; i++) {
            array[i] = i+1;
        }
        return array;
    }

    private static int[] multiArray(int[] arr, int value, int factor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < value) {arr[i] = arr[i] * factor;}
        }
        System.out.println("Массив где элементы меньше " + value + " умножены на " + factor);
        return arr;

    }

    public static int[][] d2Table (int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = ((i + j) == table.length - 1 || i == j ? 1 : 0);
            }
        }
        return table;
    }


    public static void print2DArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[] fillArray(String str, int a) {
        String[] arr = new String[a];
        for (int i = 0; i < a; i++) {
            arr[i] = str;
        }
        return arr;
    }

    public static void minMaxArray(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
            }
        System.out.println("Min= " + min);
        System.out.println("Max= " + max);
    }

    public static boolean sumArray(int[] arr) {
        int sum1 =0;
        int sum2 =0;
        if (arr.length % 2 != 0) return false;
        else {
            for (int i = 0; i < arr.length/2; i++) {
                sum1 += arr[i];
                sum2 += arr[i+ arr.length/2];
            }
            return sum1 == sum2;
        }
    }

    public static int[] shiftElementArray(int[] arr, int n) {
        int b;
        for (int i = 0; i < arr.length; i++) {
            if (i + n < arr.length) {
                System.out.println("i= "+i +" " +"n= " +n);
                b = arr[i];
              arr[i] = arr[i+n];
              arr[i+n] = b;
                System.out.println(Arrays.toString(arr));
            }
        } return arr;
    }




}
