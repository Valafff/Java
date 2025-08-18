package com.apimvcexample.HW17_ApiMvcPractice.exceptions;

//Исключение можно выбрасывать вручную, когда встречается некорректное значение
public class InvalidValueException extends RuntimeException
{
    public InvalidValueException(String value)
    {
        super("value" + value + "is invalid");
    }
}
