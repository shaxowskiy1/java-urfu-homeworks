package ru.shaxowskiy.javaurfuhomework;

public record Rectangle(double length, double width) {

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }
}
