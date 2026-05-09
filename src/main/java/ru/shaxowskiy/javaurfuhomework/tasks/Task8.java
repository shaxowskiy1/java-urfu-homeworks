package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через пробел:");
        List<String> sourceStrings = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .collect(Collectors.toList());
        System.out.println("Введите минимальную длину:");
        int minimumLength = Integer.parseInt(scanner.nextLine().trim());

        List<String> longStrings = filterByLength(sourceStrings, minimumLength);
        System.out.println(longStrings);
    }

    public static List<String> filterByLength(List<String> sourceStrings, int minimumLength) {
        return sourceStrings.stream()
                .filter(stringValue -> stringValue.length() > minimumLength)
                .collect(Collectors.toList());
    }
}
