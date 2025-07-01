package javalessons.hw;

public class SimpleTasks {
    public  static  boolean isPrime(int value)
    {

        if (value <= 1) {
            return false;
        }
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= value; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void sumAndMultValue(int value) {
        int sum = 0;
        int mult = 1;
        int abs = Math.abs(value);

        while (abs > 0) {
            int digit = abs % 10;
            sum += digit;
            mult *= digit;
            abs /= 10;
        }

        System.out.println("Сумма цифр: " + sum);
        System.out.println("Произведение цифр: " + mult);
    }

    public static void  nodNokCalc(int value1, int value2)
    {
        int a = value1;
        int b =value2;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        int nod = Math.abs(a);
        int nok = (value1*value2)/nod;

        System.out.println("НОД " + value1 + ", " + value2 + " = " + nod);
        System.out.println("НОК " + value1 + ", " + value2 + " = " + nok);
    }
}
