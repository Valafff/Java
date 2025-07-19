package org.example.classes;

import java.util.Arrays;

public class CustomArrayList <T>
{
    private final int ARRAYSTARTCAPACITY = 10;
    private final double GROWCOEFFICIENT = 1.5;
    private Object[] elementsArray;
    private int sizeCounter;

    public CustomArrayList()
    {
        this.elementsArray = new Object[ARRAYSTARTCAPACITY];
        this.sizeCounter = 0;
    }

    @SuppressWarnings("unchecked") //игнор предупреждения о стирании типов, в методах add и set указывается тип дженерика
    public T get(int index)
    {
        return (T) elementsArray[index];
    }

    public void set(int index, T element)
    {
        elementsArray[index] = element;
    }

    public void add(T element)
    {
        if (sizeCounter == elementsArray.length)
        {
            autoGrow(sizeCounter + 1);
        }
        elementsArray[sizeCounter++] = element;
    }

    private void autoGrow(int newCapacity)
    {
        newCapacity *=GROWCOEFFICIENT;
        elementsArray = Arrays.copyOf(elementsArray, (int) newCapacity);
    }

    public T remove()
    {
        if (sizeCounter == 0)
        {
            throw new IllegalStateException("List is empty");
        }
        T removedElement = get(sizeCounter - 1);
        elementsArray[--sizeCounter] = null; // Для GC
        return removedElement;
    }

    public void shrink()
    {
        if (sizeCounter < elementsArray.length)
        {
            elementsArray = Arrays.copyOf(elementsArray, sizeCounter);
        }
    }

    public void grow(int newCapacity)
    {
        if (newCapacity <= elementsArray.length)
        {
            return;
        }
        elementsArray = Arrays.copyOf(elementsArray, (int) newCapacity);
    }

    public int size()
    {
        return sizeCounter;
    }

    public int capacity()
    {
        return elementsArray.length;
    }

    public void clear()
    {
        if (elementsArray.length != 0)
        {
            sizeCounter = 0;
            elementsArray = new Object[0];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementsArray, sizeCounter));
    }
}