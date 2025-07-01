package org.top.strings;

// CustomString - класс кастомной строки, расширяющий возможности стандартной строки
public class CustomString {
    // поле - строковые данные
    protected String str;

    // конструкторы
    public CustomString() {
        str = "";
    }

    public CustomString(String str) {
        this.str = str;
    }

    // методы

    // insertStr - вставка строки toInsert начиная с позиции fromIndex
    public void insertStr(String toInsert, int fromIndex)
    {
        if (fromIndex < str.length())
        {
            String firstPart = str.substring(0, fromIndex);
            String secondPart = str.substring(fromIndex);
            str = firstPart + toInsert + secondPart;
        }
    }

    @Override
    public String toString() {
        return str;
    }
}
