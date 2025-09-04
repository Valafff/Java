package org.top;

import org.top.finance.Money;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(55, 78);
        System.out.println(money);

        money = money.increase(17);
        System.out.println(money);
    }
}
