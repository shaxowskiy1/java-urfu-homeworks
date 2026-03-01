package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.Scanner;

/**
 * название месяца и количество дней в этом месяце. Программа выводит
 * сообщение о том, что соответствующий месяц содержит указанное количестводней.
 */
public class MonthPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();
        String currentMonth = scanner.next().toUpperCase().trim();


        try{
            DatePrinter.Month month = DatePrinter.Month.valueOf(currentMonth);
            if (days > month.getDays() || days < 1) {
                throw new IllegalArgumentException("Wrong day for month " + month);
            }
            System.out.println("Month " + month + " has a " + days + " days");
        } catch (IllegalArgumentException e){
            System.out.println("You write a wrong month/day. Message" + e.getMessage());
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
}
