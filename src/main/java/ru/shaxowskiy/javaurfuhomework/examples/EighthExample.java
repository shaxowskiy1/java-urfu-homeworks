package ru.shaxowskiy.javaurfuhomework.examples;

public class EighthExample {
    public static void m() {
        try {
            System.out.println("0");
        } finally {
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        m();
    }
}
