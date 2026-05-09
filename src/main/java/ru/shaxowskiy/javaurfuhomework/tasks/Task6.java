package ru.shaxowskiy.javaurfuhomework.tasks;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task6 {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        int[] numbers = fillNumbers();
        System.out.println(Arrays.toString(numbers));
        List<Future<Long>> futures = new ArrayList<>();
        int chunkSize = (int) Math.ceil((double) numbers.length / cores);

        try (var executor = Executors.newFixedThreadPool(cores)) {
            for (int i = 0; i < cores; i++) {
                final int start = i * chunkSize;
                final int end = Math.min(start + chunkSize, numbers.length);

                if (start < numbers.length) {
                    futures.add(executor.submit(() -> {
                        long sum = 0;
                        for (int j = start; j < end; j++) {
                            sum += numbers[j];
                        }
                        return sum;
                    }));
                }
            }
        }

        Long maxValue = futures
                .stream()
                .mapToLong(
                        future -> {
                            try {
                                return future.get();
                            } catch (InterruptedException | ExecutionException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .sum();

        System.out.println("Sum value: " + maxValue);

    }

    private static int[] fillNumbers() {
        return new Random().ints(10).toArray();
    }
}
