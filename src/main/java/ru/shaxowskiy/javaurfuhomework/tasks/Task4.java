package ru.shaxowskiy.javaurfuhomework.tasks;

import java.time.OffsetDateTime;
import java.util.concurrent.Executors;

public class Task4 {
    public static void main(String[] args) {
        try (var executor = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i < 10; i++) {
                    executor.submit(() -> System.out.println(Thread.currentThread().getName() + " " + OffsetDateTime.now()));
            }
        }
    }
}
