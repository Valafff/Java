package org.top.figures;

public class Circle extends Figure {
    private double d;


    public Circle() {
        d = 0;
    }


    public Circle(double d) {
        this.d = d;
    }

    public Circle(String name, double d) {
        super(name);
        this.d = d;
    }

    public double getA() {
        return d;
    }

    public void setA(double d) {
        this.d = d;
    }


    // ПЕРЕОПРЕДЕЛЕННЫЕ МЕТОДЫ БАЗОВОГО КЛАССА
    @Override
    public double area() {
        return (Math.PI * d*d)/4;
    }

    @Override
    public double perimeter() {
        return Math.PI*d;
    }

    @Override
    public String toString() {
        return getName() + "(" + d + ")";
    }
}
