package org.top.currencysaverwebapp.converter;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException(double value) {
        super("value '" + value + "' is invalid");
    }
}
