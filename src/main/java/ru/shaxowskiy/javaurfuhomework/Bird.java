package ru.shaxowskiy.javaurfuhomework;

public class Bird extends Animal{

    private boolean isFly;

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Sound for Bird");
    }


    public boolean isFly() {
        return isFly;
    }

    public void setFly(boolean fly) {
        isFly = fly;
    }
}
