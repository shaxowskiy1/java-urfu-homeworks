package ru.shaxowskiy.javaurfuhomework.tasks;

public class Task3 {
    private static final Object lock = new Object();
    private static int counter = 1;
    private static final int MAX = 10;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (counter <= MAX) {
                synchronized (lock) {
                    if (counter % 2 != 0) {
//                        System.out.println("Thread 1: " + counter);
                        System.out.println(counter);
                        counter++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (counter <= MAX) {
                synchronized (lock) {
                    if (counter % 2 == 0) {
//                        System.out.println("Thread 2: " + counter);
                        System.out.println(counter);
                        counter++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
