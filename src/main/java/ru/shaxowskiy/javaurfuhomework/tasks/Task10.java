package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через пробел:");
        List<String> sourceStrings = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .collect(Collectors.toList());

        List<String> letterOnlyStrings = filterLetterOnlyStrings(sourceStrings);
        System.out.println(letterOnlyStrings);
    }

    public static List<String> filterLetterOnlyStrings(List<String> sourceStrings) {
        return sourceStrings.stream()
                .filter(stringValue -> !stringValue.isEmpty())
                .filter(stringValue -> stringValue.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }
}
