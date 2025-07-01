package javalessons.hw;
import java.util.InputMismatchException;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Пользователь вводит число, необходимо определить, является ли введенное число
    Scanner sc = new Scanner(System.in);
    System.out.print("Введите число ");
       if (sc.hasNextInt())
       {
           int input = sc.nextInt();
           var result = SimpleTasks.isPrime(input);
           System.out.println("Число " + (result? "простое" : "не простое"));
           SimpleTasks.sumAndMultValue(input);
       }
       else
       {
           System.out.println("Ошибка ввода");
       }

       try {
           System.out.print("Введите первое число ");
           int first = sc.nextInt();
           System.out.print("Введите второе число ");
           int second = sc.nextInt();

           SimpleTasks.nodNokCalc(first, second);
       }
       catch (InputMismatchException e)
       {
           System.out.println("Ошибка ввода");
       }
    }
}