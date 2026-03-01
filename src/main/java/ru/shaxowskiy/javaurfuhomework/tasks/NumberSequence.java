package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        System.out.println(number - 1);
        System.out.println(number);
        System.out.println(number + 1);
        System.out.println(number * number);
    }
}
