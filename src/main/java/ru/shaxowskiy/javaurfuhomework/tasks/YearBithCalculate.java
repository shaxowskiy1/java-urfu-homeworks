package ru.shaxowskiy.javaurfuhomework.tasks;

import java.time.LocalDate;
import java.util.Scanner;

public class YearBithCalculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = scanner.nextInt();
        if (age < 0){
            throw new IllegalArgumentException("Wrong input");
        }

        LocalDate date = LocalDate.now().minusYears(age);
        System.out.println("Year birth is " + date.getYear());

    }
}
