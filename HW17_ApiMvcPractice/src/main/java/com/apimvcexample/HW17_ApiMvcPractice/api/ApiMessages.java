package com.apimvcexample.HW17_ApiMvcPractice.api;

public class ApiMessages
{
    // DataToConvertMessage - данные для конвертации значения между двумя с/с
    public record DataToConvertMessage(String value, String from, String to) {}
    // ErrorMessage - сообщение об ошибке
    public record ErrorMessage(String type, String message) {}
}
