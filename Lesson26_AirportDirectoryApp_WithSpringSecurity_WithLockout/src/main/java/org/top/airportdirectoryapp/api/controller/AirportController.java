package org.top.airportdirectoryapp.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.top.airportdirectoryapp.api.message.CommonApiMessages.ErrorMessage;
import org.top.airportdirectoryapp.model.*;

import java.util.List;

// AirportController - контроллер для работы с аэропортами
@RestController
@RequestMapping("api/airport")
public class AirportController {

    private final AirportScenario airports;

    public AirportController(AirportScenario airports) {
        this.airports = airports;
    }

    // обработчики операций со справочником аэропортов

    @GetMapping
    public List<Airport> getAll() {
        return airports.listAll();
    }

    @GetMapping("{code}")
    public Airport getById(@PathVariable String code) {
        return airports.getByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Airport airport) {
        airports.add(airport);
    }

    @DeleteMapping("{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String code) {
        airports.remove(code);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void edit(@RequestBody Airport airport) {
        airports.edit(airport);
    }

    // обработчики исключений

    @ExceptionHandler(AirportNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleAirportNotFound(AirportNotFoundException e) {
        return new ErrorMessage(e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler(DuplicatedCodeException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage handleDuplicatedCode(DuplicatedCodeException e) {
        return new ErrorMessage(e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler(InvalidCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidCode(InvalidCodeException e) {
        return new ErrorMessage(e.getClass().getSimpleName(), e.getMessage());
    }
}
