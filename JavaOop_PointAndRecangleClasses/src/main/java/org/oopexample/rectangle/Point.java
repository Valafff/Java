package org.oopexample.rectangle;

public class Point {
    // поля
    private final String name;
    private double x;
    private double y;


    // конструкторы
    public Point() {
        this(0);
    }


    public Point(double value) {
        this(value, value);
    }


    public Point(double x, double y) {
        this("", x, y);
    }


    public Point(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }


    // getters&setters
    public String getName() {
        return name;
    }


    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }


    // методы


    public double norm() {
        return Math.sqrt(x * x + y * y);
    }


    // переопределение toString
    @Override
    public String toString() {
        return String.format("%s(%.3f, %.3f)", name, x, y);
    }
}

