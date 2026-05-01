package ru.shaxowskiy.javaurfuhomework.examples;

public class SeventhExample {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        }
    }
}
