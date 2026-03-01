package ru.shaxowskiy.javaurfuhomework.tasks;

import java.math.BigDecimal;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal firstNumber = scanner.nextBigDecimal();
        BigDecimal secondNumber = scanner.nextBigDecimal();

        System.out.println(firstNumber.add(secondNumber));

    }
}
