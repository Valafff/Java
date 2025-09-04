package org.top.airportdirectoryapp.api.message;

// CommonApiMessages - класс для группировки общих сообщений API
public class CommonApiMessages {

    // StringMessage - строковое сообщение
    public record StringMessage(String message) {}

    // ErrorMessage - сообщение об ошибке
    public record ErrorMessage(String code, String details) {}
}
