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
    public void testIncreaseSuccess() {
        int origin = 250;
        int percent = 20;
        int expected = origin + (int)(origin / 100.0 * percent); // 300

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
        money = money.IncreaseWithRoundingToSmaller(percent);
        int actual = money.absolute();

        assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseWithRoundingToBigger() {
        int origin = 260;
        int percent = 17;
        int expected = 305;

        Money money = new Money(0, origin);
        money = money.IncreaseWithRoundingToBigger(percent);
        int actual = money.absolute();

        assertEquals(expected, actual);
    }

}