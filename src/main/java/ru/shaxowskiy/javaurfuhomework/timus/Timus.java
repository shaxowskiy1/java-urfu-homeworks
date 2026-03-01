package ru.shaxowskiy.javaurfuhomework.timus;

import java.util.Scanner;

/**
 * Известно, что на обработку одного квадратного метра панели требуется 1 нанограмм сульфида.
 * Всего необходимо обработать N прямоугольных панелей размером A на B метров. Вам необходимо как можно скорее подсчитать,
 * сколько всего сульфида необходимо на обработку всех панелей «Энии». И не забудьте, что панели требуют обработки с обеих сторон.
 */
public class Timus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result = n * a * b * 2;

        System.out.println(result);
    }
}
