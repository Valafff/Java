package org.top.figures;

public class Square extends Figure {
    private double a;

    public Square() {
        a = 0;
    }


    public Square(double a ) {
        this.a = a;
    }

    public Square(String name, double a) {
        super(name);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }



    // ПЕРЕОПРЕДЕЛЕННЫЕ МЕТОДЫ БАЗОВОГО КЛАССА
    @Override
    public double area() {
        return a * a;
    }

    @Override
    public double perimeter() {
        return 4*a;
    }

    @Override
    public String toString() {
        return getName() + "(" + a + "; " + a + ")";
    }
}
