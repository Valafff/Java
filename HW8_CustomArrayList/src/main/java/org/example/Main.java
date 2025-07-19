package org.example;
import org.example.classes.CustomArrayList;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        CustomArrayList<Integer> testList = new CustomArrayList<>();
        System.out.println("Начальная емкость коллекции: " + testList.capacity());

        Random rand = new Random();
        for (int i = 0; i < 20; i++)
        {
            testList.add(rand.nextInt(-101, 101));
        }

        System.out.println("testList после заполнения данными: "+testList);
        System.out.println("Новая емкость коллекции: " + testList.capacity());
        System.out.println("Элемент по индексу 4: " + testList.get(4));
        testList.set(4, 888);
        System.out.println("Элемент по индексу 4 после set: " + testList.get(4));
        testList.add(999);
        System.out.println("Последний элемент массива: " + testList.get(testList.size()-1));
        testList.remove();
        System.out.println("Последний элемент массива после remove: " + testList.get(testList.size()-1));
        testList.shrink();
        System.out.println("Новая емкость коллекции после shrink: " + testList.capacity());
        testList.grow(100);
        System.out.println("Новая емкость коллекции после grow: " + testList.capacity());
        testList.clear();
        System.out.println("Новая емкость коллекции после clear: " + testList.capacity());
        testList.add(rand.nextInt(-101, 101));
        System.out.println("testList после добавления случайного числа: "+testList);
    }
}