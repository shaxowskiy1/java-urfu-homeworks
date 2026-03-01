package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Scanner;

/**
 * Напишите программу, в которой Пользователь последовательно вводит
 * название текущего дня недели, название месяца и дату (номер дня в месяце).
 * Программа выводит сообщение о сегодняшней дате (день недели, дата, месяц).
 */
public class DatePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentDay = scanner.nextInt();
        String currentMonth = scanner.next().toUpperCase().trim();
        String currentWeekDay = scanner.next().toUpperCase().trim();


        try{
            Month month = Month.valueOf(currentMonth);
            WeekDay weekDay = WeekDay.valueOf(currentWeekDay);
            if (currentDay > month.getDays() || currentDay < 1) {
                throw new IllegalArgumentException("Wrong day for month " + month);
            }
            System.out.println("Now is " + month + " " + currentDay + " " + weekDay);
        } catch (IllegalArgumentException e){
            System.out.println("You write a wrong month/day/weekDay. Message: " + e.getMessage());
        }
    }

    enum Month{
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        Month(int daysInMonth) {
            this.days = daysInMonth;
        }

        public int getDays(){
            return days;
        }
    }

    public enum WeekDay {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}
