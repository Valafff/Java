package com.apimvcexample.HW17_ApiMvcPractice.services;

import com.apimvcexample.HW17_ApiMvcPractice.interfaces.iConverter;
import org.springframework.stereotype.Service;
import com.apimvcexample.HW17_ApiMvcPractice.exceptions.*;

import java.util.List;

// Аннотация @Service указывает, что это класс сервиса
@Service
public class ConverterService implements iConverter
{
    private final List<String> numberSystems;

    @Override
    public List<String> numberSystems()
    {
        return numberSystems;
    }

    public ConverterService()
    {
        numberSystems = List.of("2", "4", "8", "10", "16");
    }

    @Override
    public String convert(String value, String fromBase, String toBase)
    {
        try
        {
            if(!numberSystems().contains(fromBase))
            {
                throw new InvalidValueException(fromBase);
            }
            if (!numberSystems().contains(toBase))
            {
                throw new InvalidValueException(toBase);
            }

            // Преобразуем строку в число в исходной системе счисления
            //Integer.parseInt(string, radix)
            //string — это число в виде строки, которое хотим преобразовать
            //radix — основание системы счисления, в которую преобразуем (2-36)
            int decimal = Integer.parseInt(value, Integer.parseInt(fromBase));

            //Integer.toString(decimal, radix)
            //decimal — это число в десятичной системе, которое хотим преобразовать
            //radix — основание системы счисления, в которую преобразуем (2-36)
            return Integer.toString(decimal, Integer.parseInt(toBase));
        }
        catch (NumberFormatException e)
        {
            return e.getMessage();
        }
    }
}
