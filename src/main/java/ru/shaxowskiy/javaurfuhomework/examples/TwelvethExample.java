package ru.shaxowskiy.javaurfuhomework.examples;

public class TwelvethExample {
    public static void m(String str, double number) {
        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (number > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }
    public static void main(String[] args) {
        m(null, 0.000001);
    }
}
