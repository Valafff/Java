package org.top.strings;

import java.util.regex.Pattern;

// CustomText - класс кастомного текста, наследник CustomString
public class CustomText extends CustomString {
    // поле - разделитель токенов текста
    protected String delimiter;

    // конструкторы
    public CustomText() {
        delimiter = "+";
    }

    public CustomText(String content, String delimiter) {
        super(content);
        this.delimiter = delimiter;
    }

    // методы

    // getTextToken - получение токена текста по заданному индексу
    public String getTextToken(int index) {
        try
        {
            String[] tokens = str.split(Pattern.quote(delimiter) );
            return tokens[index];
        }
        catch (Exception e) {
            throw(e);
        }

    }
}
