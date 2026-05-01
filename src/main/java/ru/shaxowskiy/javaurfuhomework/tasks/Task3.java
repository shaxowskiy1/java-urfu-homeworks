package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();
            byte[] array = new byte[size];

            int totalSum = 0;

            for (int i = 0; i < size; i++) {
                System.out.print("Введите элемент массива (от -128 до 127): ");
                array[i] = scanner.nextByte();
                totalSum += array[i];
            }

            if (totalSum < Byte.MIN_VALUE || totalSum > Byte.MAX_VALUE) {
                throw new ArithmeticException("Сумма вышла за границы диапазона типа byte.");
            }

            System.out.println("Сумма элементов: " + (byte)totalSum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена строка или число вне диапазона byte (-128...127).");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
