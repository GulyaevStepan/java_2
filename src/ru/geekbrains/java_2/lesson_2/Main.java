package ru.geekbrains.java_2.lesson_2;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            String str = "10 3  2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
            String [][] result = method1(str);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(method3(method2(method1(str))));
        } catch (SuperException e) {
            System.out.println("Что-то пошло не так");
            System.out.println(e.getStackTrace());
            /*
            * Что-то пошло не так. Родительские методы не работают так,
            * как у других эксепшенов.
            * */
        }

        /*try {
            String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
            String [][] result = method1(str);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(method3(method2(method1(str))));
        } catch (InputMismatchException e) {
            System.out.println("В матрице должны быть только целые числа");
        } catch (NoSuchElementException e) {
            System.out.println("Матрица должна быть размером 4х4");
        }*/
    }

    /*
    * Метод не идеален: он допускает матрицу не 4х4, а матрицу с 16 элементами.
    * Т.е. если будет матрица 2х8 или 1х16, то метод не выкинет исключения.
    * */
    public static String[][] method1 (String str) {
        Scanner scanner = new Scanner(str);
        String [][] result = new String [4][4];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (scanner.hasNext()) {
                    result[i][j] = scanner.next();
                } else {
                    throw new SuperException();
                    //throw new NoSuchElementException();
                }
            }
        }
        if (scanner.hasNext()) {
            throw new SuperException();
            //throw new NoSuchElementException();
        }
        scanner.close();
        return result;
    }

    public static int[][] method2 (String [][] str) {
        int[][] result = new int[4][4];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                Scanner scanner = new Scanner(str[i][j]);
                if (scanner.hasNextInt()) {
                    result[i][j] = scanner.nextInt();
                } else {
                    throw new SuperException();
                    //throw new InputMismatchException();
                }
                scanner.close();
            }
        }
        return result;
    }

    public static int method3 (int [][] str) {
        int result = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                result += str[i][j];
            }
        }
        result /= 2;
        return result;
    }
}
