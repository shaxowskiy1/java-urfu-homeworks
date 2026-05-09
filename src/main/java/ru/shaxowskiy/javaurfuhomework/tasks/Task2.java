package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целые числа через пробел и нажмите Enter:");

        String input = in.nextLine().trim();

        String[] strings = input.split("\\s+");

        int[] evenNumbers = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .toArray();

        System.out.println(Arrays.toString(evenNumbers));
    }

}
