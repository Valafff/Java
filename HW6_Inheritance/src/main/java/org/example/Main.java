package org.example;

import org.example.classes.IntArray;
import org.example.classes.IntQueue;
import org.example.classes.IntStack;

public class Main {
    public static void main(String[] args)
    {

        //класс IntArray
        Integer[] value = {1, 2, 3, 4};
        IntArray customArr = new IntArray(value);
        System.out.println(customArr.toString());
        System.out.println("Элемент 2-го индекса: " + customArr.getElement(2));
        customArr.setElement(3, 876);
        System.out.println("После установки нового элемента на индекс 0");
        System.out.println(customArr.toString());
        IntArray customArr2 = new IntArray(5);
        System.out.println(customArr2.toString());
        customArr2.setArray(customArr.getArray());
        System.out.println(customArr2.toString());

        //класс IntStack
        IntStack customStack = new IntStack();
        for (int i = 0; i < 10; i++)
        {
            customStack.push(i);
        }
        System.out.println("Размер стека "+customStack.getStackSize());
        System.out.println(customStack.toString());
        System.out.println("Первый элемент: " + customStack.peek());
        customStack.pop();
        System.out.println("После удаления первого элемента в стеке");
        System.out.println(customStack.toString());
        System.out.println("Размер стека после удаления элемента "+customStack.getStackSize());

        //класс IntQueue
        IntQueue customQueue = new IntQueue(5);

        customQueue.offer(1);
        customQueue.offer(2);
        customQueue.offer(3);
        System.out.println("Очередь после добавления: " + customQueue);
        System.out.println("Первый элемент (peek): " + customQueue.peek());
        System.out.println("Первый элемент (element): " + customQueue.element());
        System.out.println("Удалённый элемент (poll): " + customQueue.poll());
        System.out.println("Удалённый элемент (remove): " + customQueue.remove());
        System.out.println("Очередь после удаления: " + customQueue);
        System.out.println("Размер очереди: " + customQueue.size());
        System.out.println("Очередь пуста? " + customQueue.isEmpty());

    }
}