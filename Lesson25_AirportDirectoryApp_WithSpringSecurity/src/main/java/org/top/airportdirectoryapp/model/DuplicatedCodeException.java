package org.top.airportdirectoryapp.model;

// DuplicatedCodeException - ошибка попытки добавления в систему дублирующегося кода аэропорта
public class DuplicatedCodeException extends RuntimeException {
    public DuplicatedCodeException(String code) {
        super("airport with code " + code + " already exists");
    }
}
