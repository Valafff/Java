package org.example.classes;
import java.util.NoSuchElementException;

public class IntQueue extends IntArray
{
    private int size;

    public IntQueue()
    {
        this(0);
    }

    public IntQueue(int capacity)
    {
        super(capacity);
        this.size = 0;
    }

    public void add(int value)
    {
        if (size == array.length)
        {
            throw new IllegalStateException("Очередь полна");
        }
        array[size] = value;
        size++;
    }

    public boolean offer(int value)
    {
        if (size == array.length)
        {
            return false;
        }
        else
        {
            this.add(value);
            return  true;
        }
    }

    public int remove()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("Очередь пуста");
        }
        int value = array[0];
        // Сдвиг всех элементов на одну позицию влево
        System.arraycopy(array, 1, array, 0, size - 1);
        array[size - 1] = null; // Очистка пустой ячейки
        size--;
        return value;
    }

    public Integer poll()
    {
        if (size == 0)
        {
            return null;
        }
        return remove();
    }


    public int element()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("Очередь пуста");
        }
        return array[0];
    }

    public Integer peek()
    {
        if (size == 0)
        {
            return null;
        }
        return element();
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isFull()
    {
        return size == array.length;
    }

    @Override
    public String toString() {
        return "Размер очереди: " + size() + ", Элементы очереди: " + super.toString();
    }
}

