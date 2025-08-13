package org.top.currencysaverwebapp.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сообщения API")
public class ApiMessages {

    @Schema(description = "Строковое сообщение")
    public record StringMessage(
            @Schema(description = "Сообщение", example = "pong")
            String message
    ) {}

    @Schema(description = "Данные для конвертации значения между двумя валютами")
    public record DataToConvertMessage(
            @Schema(description = "Исходная валюта", example = "USD")
            String from,
            @Schema(description = "Целевая валюта", example = "RUB")
            String to,
            @Schema(description = "Сумма", example = "100.0")
            Double value
    ) {}

    @Schema(description = "Результат конвертации")
    public record ConvertResultMessage(
            @Schema(description = "Результат")
            Double result,
            @Schema(description = "Аргументы")
            DataToConvertMessage arg
    ) {}

    @Schema(description = "Сообщение об ошибке")
    public record ErrorMessage(
            @Schema(description = "Тип ошибки", example = "InvalidValueException")
            String type,
            @Schema(description = "Сообщение об ошибке", example = "value must be positive")
            String message
    ) {}
}
