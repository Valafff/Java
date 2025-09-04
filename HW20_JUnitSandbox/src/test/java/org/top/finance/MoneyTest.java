package org.top.finance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    public void testAbsolute() {
        // 1. подготовка тестирования
        int expected = 631;
        Money money = new Money(0, expected);

        // 2. непосредственно тестирование
        int actual = money.absolute();

        // 3. проверка результатов
        assertEquals(expected, actual);
    }

    @Test
    public void testIncrease() {
        int origin = 250;
        int percent = 20;
        int expected = 300;

        Money money = new Money(0, origin);
        money = money.increase(percent);
        int actual = money.absolute();

        assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseWithRoundingToSmaller() {
        int origin = 260;
        int percent = 17;
        int expected = 304;

        Money money = new Money(0, origin);
        money = money.increase(percent);
        int actual = money.absolute();

        assertEquals(expected, actual);
    }

    //Выполнение ДЗ
    @Test
    public void testIncreaseWithRoundingToBigger() {
        int origin = 260;
        int percent = 18;
        int expected = 307;

        Money money = new Money(0, origin);
        money = money.increase(percent);
        int actual = money.absolute();

        assertEquals(expected, actual);
    }

    @Test
    public void testSub() {
        Money m1 = new Money(10, 50);
        Money m2 = new Money(5, 25);
        Money result = m1.sub(m2);
        assertEquals(525, result.absolute());
    }

    @Test
    public void testSubWithNegativeResult() {
        Money m1 = new Money(5, 25);
        Money m2 = new Money(10, 50);
        Money result = m1.sub(m2);
        assertEquals(525, result.absolute());
    }

    @Test
    public void testSum() {
        Money m1 = new Money(10, 50);
        Money m2 = new Money(5, 75);
        Money result = m1.sum(m2);
        assertEquals(1625, result.absolute());
    }


    @Test
    public void testNormalization() {
        Money money = new Money(1, 150);
        assertEquals(2, money.getMainPart());
        assertEquals(50, money.getSubPart());
    }
}