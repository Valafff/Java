package org.main.fraction;

public class Fraction {
    int numerator;
    int denominator;
    boolean isMinus = false;

    public Fraction() {}

    public Fraction(int numerator, int denominator)
    {
        signTest(numerator, denominator);
        this.numerator = Math.abs(numerator);
        this.denominator = Math.abs(denominator);
    }

    public int getNumerator()
    {
        return numerator;
    }

    public void setNumerator(int numerator)
    {
        if (numerator < 0 && denominator <= 0 || numerator > 0 && denominator >= 0)
        {
            isMinus = false;
        }
        else
        {
            isMinus = true;
        }
        this.numerator = Math.abs(numerator);
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setDenominator(int denominator)
    {
        try
        {
            if (denominator == 0)
            {
                throw new ArithmeticException("Знаменатель не может быть равен нулю");
            }
            this.denominator = Math.abs(denominator);
            signTest(numerator, denominator);
        }
        catch (ArithmeticException e)
        {
            throw e;
        }
    }

    public void setFraction(int numerator, int denominator)
    {
        try
        {
            if (denominator == 0)
            {
                throw new ArithmeticException("Знаменатель не может быть равен нулю");
            }
            this.numerator = numerator;
            this.denominator = denominator;
            signTest(numerator, denominator);
        }
        catch (ArithmeticException e)
        {
            throw e;
        }
    }

    public String getFraction()
    {
        try
        {
            return this.toString();
        }
        catch (ArithmeticException e)
        {
            return "Ошибка вывода дроби";
        }
    }

    private void signTest(int num, int den)
    {
        if (num * den < 0)
        {
            isMinus = true;
        }
        else
        {
            isMinus = false;
        }
    }

    public void changeSign()
    {
        isMinus = !isMinus;
    }

    public int getInteger()
    {
        return  numerator / denominator;
    }

    public static Fraction sumFractions(Fraction fr1, Fraction fr2)
    {
        int commonDenominator = fr1.denominator * fr2.denominator;
        int numerator1 = fr1.numerator * fr2.denominator;
        if (fr1.isMinus)
        {
            numerator1 = -numerator1;
        }
        int numerator2 = fr2.numerator * fr1.denominator;
        if (fr2.isMinus)
        {
            numerator2 = -numerator2;
        }
        int sumNumerator = numerator1 + numerator2;
        Fraction result = new Fraction(sumNumerator, commonDenominator);
        result.reduce();
        return result;
    }

    public Fraction plus(Fraction secondFraction)
    {
        return sumFractions(this, secondFraction);
    }

    public Fraction minus(Fraction secondFraction)
    {
        secondFraction.changeSign();
        Fraction result = this.plus(secondFraction);
        secondFraction.changeSign();
        return result;
    }

    public Fraction mult(Fraction secondFraction)
    {
        int newNumerator = this.numerator * secondFraction.numerator;
        int newDenominator = this.denominator * secondFraction.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.reduce();
        return result;
    }

    public Fraction division(Fraction secondFraction)
    {
        if (secondFraction.numerator == 0)
        {
            throw new ArithmeticException("Ошибка деления на ноль");
        }
        int newNumerator = this.numerator * secondFraction.denominator;
        int newDenominator = this.denominator * secondFraction.numerator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.reduce();
        return result;
    }

    public void reduce()
    {
        int nodValue = nod(this.numerator, this.denominator);
        this.numerator /= nodValue;
        this.denominator /= nodValue;
    }

    private int nod(int a, int b)
    {
        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void toCommonDenominator(Fraction secondFraction)
    {
        int commonDenominator = this.denominator * secondFraction.denominator;
        this.numerator *= secondFraction.denominator;
        secondFraction.numerator *= this.denominator;
        this.denominator = commonDenominator;
        secondFraction.denominator = commonDenominator;
    }

    @Override
    public String toString()
    {
        try
        {
            if (numerator ==0)
            {
                return String.format("%d", numerator);
            }
            int value = getInteger();

            if (!isMinus)
            {
                if (value!=0)
                {
                    return String.format("%d %d/%d", value, numerator%denominator, denominator);
                }
                return String.format("%d/%d", numerator, denominator);
            }
            else
            {
                if (value!=0)
                {
                    return String.format("-%d %d/%d", value, numerator%denominator, denominator);
                }
                return String.format("-%d/%d", numerator, denominator);
            }
        }
        catch (ArithmeticException e)
        {
            throw e;
        }
    }
}
