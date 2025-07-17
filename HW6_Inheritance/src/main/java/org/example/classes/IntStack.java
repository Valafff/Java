package org.example.classes;

public class IntStack extends IntArray
{
    public int stackSize;

    public IntStack() {
        super(0);
        stackSize = 0;
    }

    public int getStackSize()
    {
        return stackSize;
    }

    public void push(int element)
    {
        Integer[] temp = new Integer[array.length + 1];
        temp[0] = element;
        System.arraycopy(array, 0, temp, 1, array.length);
        array = temp;
        stackSize ++;
    }

    public boolean isEmpty()
    {
        return !(array.length>0);
    }

    public Integer peek()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("Стек пуст");
        }
        return getElement(0);
    }


    public int pop()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("Стек пуст");
        }
        int first = this.peek();
        Integer[] temp = new Integer[array.length - 1];
        System.arraycopy(array, 1, temp, 0, array.length - 1);
        array = temp;
        stackSize--;
        return first;
    }

    @Override
    public String toString(){
        return "Размер стека = "+stackSize+", "+ "Элементы стека: " + super.toString();
    }

}

