package ru.shaxowskiy.javaurfuhomework.examples;

public class FifthExample {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (Throwable e) {
            System.out.println("1");
        }
    }
}
