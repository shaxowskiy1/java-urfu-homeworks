package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целые числа через пробел:");
        List<Integer> sourceNumbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Введите делитель:");
        int divisor = Integer.parseInt(scanner.nextLine().trim());

        List<Integer> divisibleNumbers = filterDivisibleNumbers(sourceNumbers, divisor);
        System.out.println(divisibleNumbers);
    }

    public static List<Integer> filterDivisibleNumbers(List<Integer> sourceNumbers, int divisor) {
        return sourceNumbers.stream()
                .filter(numberValue -> numberValue % divisor == 0)
                .collect(Collectors.toList());
    }
}
