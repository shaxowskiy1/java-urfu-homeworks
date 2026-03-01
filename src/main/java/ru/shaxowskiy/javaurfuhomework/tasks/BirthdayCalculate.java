package ru.shaxowskiy.javaurfuhomework.tasks;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * программа отображает сообщение содержащее имя пользователя и его возраст.
 */
public class BirthdayCalculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearBirth = scanner.nextInt();
        int monthBirth = scanner.nextInt();
        int dayBirth = scanner.nextInt();

        LocalDate dateBirth = null;
        try {
            dateBirth = LocalDate.of(yearBirth, monthBirth, dayBirth);
        } catch (Throwable e){
            System.out.println("Wrong input. Check please");
            System.exit(0);
        }

        long yearBetween = ChronoUnit.YEARS.between(dateBirth, LocalDate.now());
        long dayBetween = ChronoUnit.DAYS.between(dateBirth, LocalDate.now());
        long monthBetween = ChronoUnit.MONTHS.between(dateBirth, LocalDate.now());
        System.out.println("Between year is " + yearBetween);
        System.out.println("Between month is " + monthBetween);
        System.out.println("Between day is " + dayBetween);

    }
}
