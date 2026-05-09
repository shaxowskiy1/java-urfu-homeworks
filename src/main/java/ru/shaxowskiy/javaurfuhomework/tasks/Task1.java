package ru.shaxowskiy.javaurfuhomework.tasks;


import java.time.OffsetDateTime;
import java.util.concurrent.Executors;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        try (var executor = Executors.newFixedThreadPool(2)) {
            executor.submit(() -> System.out.println(Thread.currentThread().getName() + " " + OffsetDateTime.now()));
            executor.submit(() -> System.out.println(Thread.currentThread().getName() + " " + OffsetDateTime.now()));
        }
    }
}
