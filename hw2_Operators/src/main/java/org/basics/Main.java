package org.basics;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //Пользователь вводит первый член арифметической прогрессии, кол-во элементов в прогрессии,
        // а также шаг между двумя соседними членами прогрессии.
        // Найти сумму всех членов этой прогрессии от первого до последнего,
        // введенного пользователем. Циклы использовать нельзя.

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите  первый член арифметической прогрессии: ");
        int firstMember, elementsNumber, step;
        if (sc.hasNextInt())
        {
            firstMember = sc.nextInt();
            System.out.print("Введите количество элементов прогрессии: ");
            if (sc.hasNextInt())
            {
                elementsNumber = sc.nextInt();
                System.out.print("Укажите шаг между соседними членами: ");
                if (sc.hasNextInt())
                {
                    step = sc.nextInt();

                    int result = (2*firstMember + step*(elementsNumber - 1)) * elementsNumber/2;
                    System.out.println("Сумма арифметической прогрессии: " + result);
                }
                else
                {
                    System.out.print("Ошибка ввода - некорректный шаг прогрессии");
                }
            }
            else
            {
                System.out.print("Ошибка ввода - некорректное число членов прогрессии");
            }
        }
        else
        {
            System.out.print("Ошибка ввода - введите корректный первый член прогрессии");
        }

        //Пользователь вводит две стороны произвольного треугольника и значение угла между ними.
        // Необходимо найти третью сторону по теореме косинусов (см. в интернете).
        // Проверить для прямоугольных и непрямоугольных треугольников,
        // использовать проверку через онлайн-калькулятор.

        System.out.print("Введите сторону треугольника а: ");
        double a, b, conner;
        if (sc.hasNextDouble())
        {
            a = sc.nextDouble();
            System.out.print("Введите сторону треугольника b: ");
            if (sc.hasNextDouble())
            {
                b = sc.nextDouble();
                System.out.print("Укажите угол между сторонами(град): ");
                if (sc.hasNextDouble())
                {
                    conner = sc.nextDouble();

                    double result = Math.sqrt(a*a + b*b - 2*a*b*Math.cos(conner*Math.PI/180));
                    System.out.println("Длина третье стороны треугольника равна: " + result);
                }
                else
                {
                    System.out.print("Ошибка ввода - некорректный угол между сторонами треугольника");
                }
            }
            else
            {
                System.out.print("Ошибка ввода - некорректная сторона b");
            }
        }
        else
        {
            System.out.print("Ошибка ввода - некорректная сторона а");
        }


//        Пользователь вводит шестизначное число.
//        Оно считается счастливым если суммы первых трех цифр и последних трех равны.
//        Вывести информацию о том, является ли введенное число счастливым.

          System.out.print("Введите шестизначное число: ");
          if (sc.hasNextInt())
          {
              int value = sc.nextInt();
              if(value >= 100000 && value <= 999999)
              {
                  int rightPart = value%1000;
                  int leftPart = value/1000;
                  if (rightPart == leftPart)
                  {
                      System.out.println("Число " + value + " счастливое");
                  }
                  else
                  {
                      System.out.println("Число " + value + " не счастливое");
                  }
              }
              else
              {
                  System.out.print("Ошибка ввода - некорректное число");
              }
          }
          else
          {
              System.out.print("Ошибка ввода - некорректное число");
          }

//        Пользователь вводит стоимость шоколадки (в рублях и копейках)
//        а также кол-во денег у него в кармане (в рублях и копейках).
//        Программа должна посчитать, сколько шоколадок может купить пользователь,
//        и какая у него останется сдача, если он купит максимальное кол-во шоколадок.
//        Все вычисления делать в целочисленных типах.
//        При вводе значений копеек больше 100 делать приведение к канонической форме либо выводить ошибку.

        System.out.print("Введите стоимость шоколадки (рубли): ");
        int chocolateRubles = sc.nextInt();
        System.out.print("Введите стоимость шоколадки (копейки): ");
        int chocolateKopecks = sc.nextInt();

        if (chocolateKopecks >= 100)
        {
            System.out.println("Ошибка: копеек должно быть меньше 100");
            return;
        }

        System.out.print("Введите количество денег у вас (рубли): ");
        int moneyRubles = sc.nextInt();
        System.out.print("Введите количество денег у вас (копейки): ");
        int moneyKopecks = sc.nextInt();

        if (moneyKopecks >= 100)
        {
            System.out.println("Ошибка: копеек должно быть меньше 100");
            return;
        }

        int totalChocolateKopecks = chocolateRubles * 100 + chocolateKopecks;
        int totalMoneyKopecks = moneyRubles * 100 + moneyKopecks;

        if (totalChocolateKopecks == 0)
        {
            System.out.println("Ошибка: шоколадка не может стоить 0 копеек");
            return;
        }

        int numberOfChocolates = totalMoneyKopecks / totalChocolateKopecks;
        int remainingKopecks = totalMoneyKopecks % totalChocolateKopecks;

        int changeRubles = remainingKopecks / 100;
        int changeKopecks = remainingKopecks % 100;

        System.out.println("Максимальное количество шоколадок: " + numberOfChocolates);
        System.out.println("Сдача: " + changeRubles + " руб. " + changeKopecks + " коп.");

        //Пользователь вводит 3 стороны треугольника a, b,c - сказать,
        // существует ли такой треугольник (условие существования по сторонам)

        System.out.print("Введите длину стороны a: ");

        a = sc.nextDouble();

        System.out.print("Введите длину стороны b: ");
        b = sc.nextDouble();

        System.out.print("Введите длину стороны c: ");
        double c = sc.nextDouble();


        boolean exists = (a + b > c) && (a + c > b) && (b + c > a) && (a > 0) && (b > 0) && (c > 0);

        if (exists)
        {
            System.out.println("Треугольник с такими сторонами существует");
        }
        else
        {
            System.out.println("Треугольник с такими сторонами не существует");
        }

//        Пользователь вводит число int, необходимо посчитать количество битов, равных единице в этом числе не используя циклы.
        System.out.print("Введите целое число: ");
        int number = sc.nextInt();
        int count = Integer.bitCount(number);
        System.out.println("Количество единичных битов: " + count);

//                Пользователь вводит целое неотрицательное число.
//                Необходимо возвести число 2 в степень, равную этому числу.
//                Циклы использовать нельзя. Переполнения не обрабатывать.

        System.out.print("Введите неотрицательное целое число: ");
        int someNumber = sc.nextInt();

        int result = 1 << someNumber;

        System.out.println("2^" + someNumber + " = " + result);

//        Пользователь вводит 2 числа – a, b. Необходимо сказать,
//         какой бит стоит на позиции b в числе a. Циклы использовать нельзя.
//         Позиция битов отсчитывается по разрядам числа – справа-налево начиная с нуля (нулевой разряд).

        System.out.print("Введите число a: ");
        int A = sc.nextInt();
        System.out.print("Введите позицию бита b: ");
        int B = sc.nextInt();

        if (B < 0 || B >= 32)
        {
            System.out.println("Ошибка: позиция бита должна быть от 0 до 31");
            return;
        }

        int bit = (A >> B) & 1;

        System.out.println("Бит на позиции " + B + " в числе " + A + " равен " + bit);

    }
}