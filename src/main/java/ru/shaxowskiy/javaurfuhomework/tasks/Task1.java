package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    private final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        List<Integer> numbers = List.of();
        try {
            numbers = inputNumbers();
        } catch (IllegalArgumentException e){
            System.out.println("User input the negative numbers");
        }
        catch (InputMismatchException e){
            System.out.println("User input the string");

        }

        calculateAverage(numbers);
    }

    private static void calculateAverage(List<Integer> numbers) {
        Integer sum = 0;
        for (Integer num : numbers){
            sum += num;
        }
        System.out.println("Average is " + sum / numbers.size());
    }

    private static List<Integer> inputNumbers() {
        System.out.println("Input two positive number");
        int firstInputedNumber = scanner.nextInt();
        int secondInputedNumber = scanner.nextInt();


        if (firstInputedNumber < 0 || secondInputedNumber < 0){
            throw new IllegalArgumentException("User input the negative numbers");
        }

        return List.of(firstInputedNumber, secondInputedNumber);
    }
}
