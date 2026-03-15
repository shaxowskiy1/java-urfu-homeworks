package ru.shaxowskiy.javaurfuhomework;

import java.util.Scanner;

/**
 * Напишите программу, в которой создается двумерный числовой
 * массив и этот массив заполняется «змейкой»: сначала первая строка (слева
 * направо), затем последний столбец (сверху вниз), вторая строка (справа
 * налево) и так далее, как показано на рисунке:
 */
public class TwoDimensionalFilledArray {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int countRow = scanner.nextInt();
        int countColumn = scanner.nextInt();
        int[][] matrix = new int[countRow][countColumn];


        int value = 1;
        int top = 0, bottom = countRow - 1;
        int left = 0, right = countColumn - 1;

        while (value <= countRow * countColumn) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
                render(matrix);
            }
            top++;
            System.out.println();


            for (int i = right; i >= left; i--) {
                if (top == countRow){
                    System.exit(0);
                }
                matrix[top][i] = value++;
                render(matrix);
            }
            top++;
        }
    }

    static void render(int[][] matrix) throws InterruptedException {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell == 0) System.out.print(" .  ");
                else System.out.printf("%2d  ", cell);
            }
            System.out.println();
        }
        Thread.sleep(500);
    }
}