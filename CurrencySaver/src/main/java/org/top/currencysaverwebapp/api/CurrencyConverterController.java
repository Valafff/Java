package org.top.currencysaverwebapp.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.top.currencysaverwebapp.converter.CurrencyConverter;
import org.top.currencysaverwebapp.converter.InvalidValueException;
import org.top.currencysaverwebapp.converter.UnsupportedCurrencyException;
import org.top.currencysaverwebapp.simple.SimpleCurrencyConverter;
import org.top.currencysaverwebapp.simple.SimpleRatesProvider;
import org.top.currencysaverwebapp.api.ApiMessages.*;

import java.util.List;

@RestController
@RequestMapping("api/currencies")
@Tag(name = "Конвертер валют", description = "Операции с валютами")
public class CurrencyConverterController {

    private final CurrencyConverter converter;

    public CurrencyConverterController() {
        // TODO: внедрить сервис через Spring DI
        converter = new SimpleCurrencyConverter(new SimpleRatesProvider());
    }

    @GetMapping
    @Operation(summary = "Поддерживаемые валюты", description = "Получить список поддерживаемых валют")
    public List<String> supportedCurrencies() {
        return converter.supportedCurrencies();
    }

    @PostMapping("convert")
    @Operation(summary = "Конвертировать валюту", description = "Конвертировать значение из одной валюты в другую")
    @ApiResponse(responseCode = "200", description = "Успешная конвертация", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConvertResultMessage.class)))
    @ApiResponse(responseCode = "400", description = "Неверный запрос", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    @ApiResponse(responseCode = "404", description = "Валюта не найдена", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    public ResponseEntity<?> convert(@RequestBody DataToConvertMessage data) {
        if (data.from() == null || data.from().isEmpty()) {
            // 400
            ErrorMessage error = new ErrorMessage("EmptyString", "'from' is null or empty");
            return ResponseEntity.badRequest().body(error);
        }
        if (data.to() == null || data.to().isEmpty()) {
            // 400
            ErrorMessage error = new ErrorMessage("EmptyString", "'to' is null or empty");
            return ResponseEntity.badRequest().body(error);
        }
        if (data.value() == null) {
            // 400
            ErrorMessage error = new ErrorMessage("EmptyValue", "'value' is null");
            return ResponseEntity.badRequest().body(error);
        }

        try {
            double result = converter.convert(data.from(), data.to(), data.value());
            // 200
            ConvertResultMessage resultMessage = new ConvertResultMessage(result, data);
            return ResponseEntity.ok(resultMessage);
        } catch (InvalidValueException ex) {
           // 400
            ErrorMessage error = new ErrorMessage(ex.getClass().getSimpleName(), ex.getMessage());
            return ResponseEntity.badRequest().body(error);
        } catch (UnsupportedCurrencyException ex) {
            // 404
            ErrorMessage error = new ErrorMessage(ex.getClass().getSimpleName(), ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }
}
