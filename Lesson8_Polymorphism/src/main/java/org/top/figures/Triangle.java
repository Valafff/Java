package org.top.figures;

public class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public Triangle() {
        a = 0; b=0; c =0;
    }


    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double b) {
        this.c = c;
    }

    // ПЕРЕОПРЕДЕЛЕННЫЕ МЕТОДЫ БАЗОВОГО КЛАССА
    @Override
    public double area() {
        return Math.sqrt(((a + b + c) / 2) * (((a + b + c) / 2) - a) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - c));
    }

    @Override
    public double perimeter() {
        return (a +b+c);
    }

    @Override
    public String toString() {
        return getName() + "(" + a + "; " + b +  "; "+ c +")";
    }
}
