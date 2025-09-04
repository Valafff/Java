package org.top.airportdirectoryapp.model;

// AirportNotFoundException - ошибка аэропорта, не найденного по коду
public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(String code) {
        super("airport with code " + code + " not found");
    }
}
