package com.apimvcexample.HW17_ApiMvcPractice.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;

// Аннотация @Service указывает, что это класс сервиса (бизнес-логика)
@Service
public interface iConverter
{
    String convert(String value, String from, String to);
    List<String> numberSystems();
}
