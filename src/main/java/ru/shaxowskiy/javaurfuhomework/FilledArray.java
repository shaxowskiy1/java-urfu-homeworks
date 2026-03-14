package ru.shaxowskiy.javaurfuhomework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Напишите программу, в которой создается массив и заполняется
 * случайными числами. Массив отображается в консольном окне. В этом
 * массиве необходимо определить элемент с минимальным значением. В
 * частности, программа должна вывести значение элемента с минимальным
 * значением и индекс этого элемента. Если элементов с минимальным
 * значением несколько, должны быть выведены индексы всех этих элементов.
 */
public class FilledArray {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(numbers));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        System.out.println("Min = " + min);
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == min){
                indexes.add(i);
            }
        }
        System.out.println("Indexes = " + indexes);
    }
}
