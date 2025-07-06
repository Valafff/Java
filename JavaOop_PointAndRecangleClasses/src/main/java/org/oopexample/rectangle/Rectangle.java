package org.oopexample.rectangle;

public class Rectangle {

    private String name;
    private double a;
    private double b;

    public Rectangle(String name, double x, double y) {
        this.name = name;
        this.a = x;
        this.b = y;
    }

    public String getName() {
        return name;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double area() {
        return a*b;
    }

    public double perimeter() {
        return 2*(a+b);
    }

    @Override
    public String toString() {
        return String.format("%s(%.1f, %.1f)", name, a, b);
    }

}
