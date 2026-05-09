package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через пробел:");
        List<String> sourceStrings = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .collect(Collectors.toList());
        System.out.println("Введите подстроку:");
        String requiredSubstring = scanner.nextLine();

        List<String> stringsWithSubstring = filterBySubstring(sourceStrings, requiredSubstring);
        System.out.println(stringsWithSubstring);
    }

    public static List<String> filterBySubstring(List<String> sourceStrings, String requiredSubstring) {
        return sourceStrings.stream()
                .filter(stringValue -> stringValue.contains(requiredSubstring))
                .collect(Collectors.toList());
    }
}
