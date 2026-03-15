package ru.shaxowskiy.javaurfuhomework;

/**
 * 6 Создание классов и интерфейсов для работы с фигурами:
 * Создайте классы для различных геометрических фигур (например,
 * круг, квадрат, треугольник), каждый из которых имеет свои методы и поля.
 * Создайте интерфейс, который определяет методы, которые
 * должны быть реализованы для каждой фигуры, чтобы вычислить ее площадь и
 * периметр.
 * Реализуйте методы интерфейса в каждом классе фигуры и
 * создайте объекты для каждой из них, чтобы вычислить их площадь и
 * периметр.
 */
public class Circle implements Square, Perimeter {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class RectangleDto implements Square, Perimeter {
    private double side;

    public RectangleDto(double side) {
        this.side = side;
    }

    @Override
    public double calculateSquare() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}

class Triangle implements Square, Perimeter {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateSquare() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}