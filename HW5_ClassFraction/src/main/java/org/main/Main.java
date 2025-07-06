package org.main;
import org.main.fraction.Fraction;

public class Main {
    public static void main(String[] args) {

        Fraction fr1 = new Fraction(1,-4);
        System.out.println("Первая дробь: " + fr1.toString());
        fr1.setNumerator(5);
        fr1.setDenominator(2);
        System.out.println("Первая дробь после изменений: " + fr1.toString());
        System.out.println("Числитель дроби 1: " + fr1.getNumerator());
        System.out.println("Знаменатель дроби 1: " + fr1.getDenominator());
        System.out.println("Целое значение дроби 1: " + fr1.getInteger());
        fr1.changeSign();
        System.out.println("Первая дробь с измененным знаком: " + fr1.toString());
        Fraction fr2 = new Fraction(5,2);
        System.out.println("Вторая дробь: " + fr2.getFraction());
        Fraction fr3 = Fraction.sumFractions(fr1, fr2);
        System.out.println("Дробь 3 - сумма дробей 1 и 2: " + fr3.toString());
        fr3 = fr3.plus(fr2);
        System.out.println("Сумма дробей 2 и 3: " + fr3.toString());
        fr1.setFraction(3, 5);
        fr2.setFraction(2, 5);
        fr1 = fr1.minus(fr2);
        System.out.println("Разность дробей 1 и 2: " + fr1.toString());
        fr1 = fr1.mult(fr3);
        System.out.println("Произведение дробей 1 и 3: " + fr1.toString());
        fr1.setFraction(1, 5);
        fr2.setFraction(5, 1);
        fr1 = fr1.division(fr2);
        System.out.println("Частное дробей 1 и 2: " + fr1.toString());
        fr3.setFraction(1,3);
        fr3.toCommonDenominator(fr1);
        System.out.println("Общий знаменатель дрбей 1 и 3 : " + fr3.getDenominator());
    }
}