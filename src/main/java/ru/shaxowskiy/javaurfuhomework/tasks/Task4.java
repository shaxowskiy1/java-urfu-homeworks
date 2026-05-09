package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через пробел:");
        List<String> sourceStrings = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .collect(Collectors.toList());

        List<String> stringsWithUppercaseStart = filterCapitalizedStrings(sourceStrings);
        System.out.println(stringsWithUppercaseStart);
    }

    public static List<String> filterCapitalizedStrings(List<String> sourceStrings) {
        return sourceStrings.stream()
                .filter(stringValue -> !stringValue.isEmpty())
                .filter(stringValue -> Character.isUpperCase(stringValue.charAt(0)))
                .collect(Collectors.toList());
    }
}
