package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой Пользователь вводит сначала фамилию,
 * затем имя, затем отчество. После ввода программа выводит сообщение «Hello, <фамилия, имя, отчество>».
 */
public class NamePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lastName = scanner.next();
        String firstName = scanner.next();
        String surname = scanner.next();

        System.out.println("Hello, " + lastName + " " + firstName + " " + surname);
    }
}
