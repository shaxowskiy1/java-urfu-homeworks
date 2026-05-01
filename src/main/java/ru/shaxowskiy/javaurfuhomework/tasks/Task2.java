package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите номер столбца (начиная с 0): ");

            int colIndex = scanner.nextInt();

            System.out.println("Выбранный столбец:");

            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][colIndex]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Вы ввели не число.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Столбца с таким номером не существует.");
        }
    }
}
