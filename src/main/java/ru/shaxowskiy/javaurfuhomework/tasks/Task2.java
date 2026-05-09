package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.concurrent.Executors;

public class Task2 {
    public static void main(String[] args) {
        try (var executor = Executors.newFixedThreadPool(1)) {
            executor.submit(() -> {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
}
