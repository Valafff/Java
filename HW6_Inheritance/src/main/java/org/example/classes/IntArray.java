package org.example.classes;

import java.util.Arrays;

public class IntArray
{
    public Integer[] array;

    public IntArray(Integer[] array)
    {
        this.array = array;
    }

    public IntArray(int size)
    {
        this.array = new Integer[size];
    }

    public void setArray(Integer[] array)
    {
        this.array = array;
    }

    public Integer[] getArray()
    {
        return array;
    }

    public Integer getElement(int index)
    {
        if (index < 0 || index >= array.length)
        {
            System.out.println("Индекс вне диапазона массива");
            return null;
        }
        return this.array[index];
    }

    public void setElement(int index, int element)
    {
        if (index < 0 || index >= array.length)
        {
            System.out.println("Индекс вне диапазона массива");
            return;
        }
        this.array[index] = element;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(array);
    }
}
