package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Scanner;

public class SumDiffNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        System.out.println(firstNumber + secondNumber);
        System.out.println(firstNumber - secondNumber);
    }
}
