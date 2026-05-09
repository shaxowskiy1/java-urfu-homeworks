package ru.shaxowskiy.javaurfuhomework.tasks;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task5 {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        int[] numbers = fillNumbers();
        System.out.println(Arrays.toString(numbers));
        List<Future<Integer>> futures = new ArrayList<>();
        int chunkSize = (int) Math.ceil((double) numbers.length / cores);

        try (var executor = Executors.newFixedThreadPool(cores)) {
            for (int i = 0; i < cores; i++) {
                final int start = i * chunkSize;
                final int end = Math.min(start + chunkSize, numbers.length);

                if (start < numbers.length) {
                    futures.add(executor.submit(() -> {
                        int localMax = Integer.MIN_VALUE;
                        for (int j = start; j < end; j++) {
                            if (numbers[j] > localMax) localMax = numbers[j];
                        }
                        return localMax;
                    }));
                }
            }
        }

        Integer maxValue = futures
                .stream()
                .map(
                        future -> {
                            try {
                                return future.get();
                            } catch (InterruptedException | ExecutionException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("Does not exist max value in array"));

        System.out.println("Max value: " + maxValue);

    }

    private static int[] fillNumbers() {
        return new Random().ints(100).toArray();
    }
}
