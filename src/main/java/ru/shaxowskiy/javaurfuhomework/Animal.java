package ru.shaxowskiy.javaurfuhomework;

/**
 * Создайте класс Animal (животное) и добавьте в него поля и
 * методы, которые общие для всех животных (например, имя, возраст, метод для
 * издания звука).
 * Создайте подклассы (например, Dog, Cat, Bird), которые
 * наследуют класс Animal и добавляют свои уникальные поля и методы
 * (например, порода, тип корма, способность летать).
 * Создайте объекты для каждого из подклассов и вызовите их
 * методы, чтобы проверить, что наследование работает корректно.
 */
public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Animal() {
    }

    abstract void makeSound();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
