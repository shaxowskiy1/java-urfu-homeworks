package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой Пользователь вводит имя и возраст.
 * Программа отображает сообщение об имени и возрасте пользователя.
 */
public class BirthdayPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        int age = scanner.nextInt();

        System.out.println("Message about name " + name + " and age " + age);
    }
}
