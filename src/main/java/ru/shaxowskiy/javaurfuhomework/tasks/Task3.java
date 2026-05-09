package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первый массив целых чисел через пробел:");
        int[] firstNumbers = parseIntArray(scanner.nextLine());
        System.out.println("Введите второй массив целых чисел через пробел:");
        int[] secondNumbers = parseIntArray(scanner.nextLine());

        int[] commonNumbers = findCommonElements(firstNumbers, secondNumbers);
        System.out.println(Arrays.toString(commonNumbers));
    }

    public static int[] findCommonElements(int[] firstNumbers, int[] secondNumbers) {
        Set<Integer> secondNumbersSet = Arrays.stream(secondNumbers)
                .boxed()
                .collect(Collectors.toSet());

        return Arrays.stream(firstNumbers)
                .filter(secondNumbersSet::contains)
                .toArray();
    }

    public static int[] parseIntArray(String inputLine) {
        return Arrays.stream(inputLine.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
