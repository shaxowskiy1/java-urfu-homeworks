package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целые числа через пробел:");
        List<Integer> sourceNumbers = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Введите пороговое значение:");
        int threshold = Integer.parseInt(scanner.nextLine().trim());

        List<Integer> greaterNumbers = filterGreaterNumbers(sourceNumbers, threshold);
        System.out.println(greaterNumbers);
    }

    public static List<Integer> filterGreaterNumbers(List<Integer> sourceNumbers, int threshold) {
        return sourceNumbers.stream()
                .filter(numberValue -> numberValue > threshold)
                .collect(Collectors.toList());
    }
}
