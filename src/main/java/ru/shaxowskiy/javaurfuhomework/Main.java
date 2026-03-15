package ru.shaxowskiy.javaurfuhomework;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Dog", 1);
        dog.makeSound();

        Animal bird = new Bird("Bird", 1);
        System.out.println(bird.getName());
    }
}
