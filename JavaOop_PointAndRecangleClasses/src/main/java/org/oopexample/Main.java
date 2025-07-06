package org.oopexample;

import org.oopexample.rectangle.Point;
import org.oopexample.rectangle.Rectangle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Point point1 = new Point("p1", 10, 30);
        Point point2 = new Point("p2", 14, -9);

        System.out.println(point1);
        System.out.println(point2);

        Rectangle rect = new Rectangle("r", 5, 5);
        System.out.println(rect.area());
        System.out.println(rect.perimeter());

        System.out.println(rect.toString());
    }
}