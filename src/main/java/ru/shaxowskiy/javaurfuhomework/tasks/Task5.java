package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через пробел:");
        List<Integer> sourceNumbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> squaredNumbers = squareNumbers(sourceNumbers);
        System.out.println(squaredNumbers);
    }

    public static List<Integer> squareNumbers(List<Integer> sourceNumbers) {
        return sourceNumbers.stream()
                .map(numberValue -> numberValue * numberValue)
                .collect(Collectors.toList());
    }
}
