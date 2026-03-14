package ru.shaxowskiy.javaurfuhomework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Напишите программу «Шифр Цезаря», которая зашифровывает
 * введенный текст. Используете кодовую таблицу символов. При запуске
 * программы в консоль необходимо вывести сообщение: «Введите текст для
 * шифрования», после ввода текста, появляется сообщение: «Введите ключ».
 * После того как введены все данные, необходимо вывести преобразованную
 * строку с сообщением «Текст после преобразования: ». Далее необходимо
 * задать вопрос пользователю: «Выполнить обратное преобразование? (y/n)»,
 * если пользователь вводит «y», тогда выполнить обратное преобразование.
 * Если пользователь вводит «n», того программа выводит сообщение «До
 * свидания!». Если пользователь вводит что-то другое, отличное от «y» или «n»,
 * то программа ему выводит сообщение: «Введите корректный ответ».
 */
public class Cipher {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String phrase = inputPhrase();

        String encrypt = encrypt(phrase);

        outputDecode(encrypt);
    }

    private static void outputDecode(String encrypt) {
        System.out.print("Выполнить обратное преобразование?(y/n): ");
        switch (scanner.next()) {

            case "y" -> decode(encrypt);

            case "n" -> System.out.println("До свидания!");

            default -> System.out.println("Введите корректный ответ");
        }
    }

    private static void decode(String encrypt) {
        char[] wordLetters = encrypt.toCharArray();

        for (int i = 0; i < wordLetters.length; i++) {
            wordLetters[i] = (char) ('а' + (wordLetters[i] - 'а' - 3 + 33) % 33);
        }

        System.out.println(new String(wordLetters));
    }

    private static String encrypt(String phrase) {
        char[] wordLetters = phrase.toCharArray();

        for (int i = 0; i < wordLetters.length; i++) {
            wordLetters[i] = (char) ('а' + (wordLetters[i] - 'а' + 3) % 33);
        }
        String word = new String(wordLetters);
        System.out.println(word);
        return word;
    }

    private static String inputPhrase() {
        System.out.print("Введите текст для шифрования: ");
        return scanner.nextLine().toLowerCase().trim();
    }
}
