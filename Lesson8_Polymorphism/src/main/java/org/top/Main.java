package org.top;

import org.top.figures.*;

public class Main {

    static void testFigure(Figure figure) {
        System.out.println("figure: " + figure);
        System.out.println("area: " + figure.area());
        System.out.println("perimeter: " + figure.perimeter());
    }

    public static void main(String[] args) {
        testFigure(new Figure("UNKNOWN FIGURE"));

        testFigure(new Rectangle("ABCD", 3, 9.1));
        testFigure(new Circle("O", 3));
        testFigure(new Square("A", 3));
        testFigure(new Triangle("ABC", 3, 4,5));



        // ОКРУЖНОСТЬ, ТРЕУГОЛЬНИК, ТРАПЕЦИЯ, ПАРАЛЛЕЛОГРАММ, РОМБ, КВАДРАТ, ЭЛЛИПС - РЕАЛИЗОВАТЬ ЛЮБЫЕ 3 И ПРОТЕСТИРОВАТЬ ЧЕРЕЗ testFigure
    }
}
