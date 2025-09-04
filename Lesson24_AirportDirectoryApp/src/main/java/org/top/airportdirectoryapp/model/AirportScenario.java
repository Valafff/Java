package org.top.airportdirectoryapp.model;

import java.util.List;
import java.util.Optional;

// AirportScenario - сценарии для работы с аэропортами
public class AirportScenario {

    // хранилище аэропортов
    private final AirportStorage storage;

    public AirportScenario(AirportStorage storage) {
        this.storage = storage;
    }

    // listAll - получение всех аэропортов из справочника
    // вход: -
    // выход: список аэропортов
    // исключения: -
    public List<Airport> listAll() {
        return storage.selectAll();
    }

    // getByCode - получение аэропорта по коду
    // вход: код аэропорта в заданном формате
    // выход: аэропорт с заданным кодом
    // исключения:
    //  - AirportNotFoundException - аэропорт с данным кодом не найден
    //  - InvalidCodeException - переданный код не является валидным кодом аэропорта
    public Airport getByCode(String code) {
        validateCode(code);
        Optional<Airport> airport = storage.selectByCode(code);
        if (airport.isEmpty()) {
            throw new AirportNotFoundException(code);
        }
        return airport.get();
    }

    // add - добавление нового аэропорта в справочник
    // вход: объект аэропорта для добавления с заполненными полями
    // выход: -
    // исключения:
    //  - InvalidCodeException - код переданного аэропорта не является валидным кодом аэропорта
    //  - DuplicatedCodeException - код переданного аэропорта уже встречается в другой записи
    public void add(Airport airport) {
        String code = airport.getCode();;
        validateCode(code);
        if (storage.selectByCode(code).isPresent()) {
            throw new DuplicatedCodeException(code);
        }
        storage.insert(airport);
    }

    // remove - удаление аэропорта из справочника по коду
    // вход: код аэропорта в заданном формате
    // выход: -
    // исключения:
    //  - AirportNotFoundException - аэропорт с данным кодом не найден
    //  - InvalidCodeException - переданный код не является валидным кодом аэропорта
    public void remove(String code) {
        validateCode(code);
        if (storage.selectByCode(code).isEmpty()) {
            throw new AirportNotFoundException(code);
        }
        storage.deleteByCode(code);
    }

    // edit - редактирование аэропорта, разрешено редактировать все поля кроме кода
    // вход: объект аэропорта, в котором:
    //  - поле кода содержит значение, присутствующего в системе
    //  - значения остальных полей могут отличаться от объекта в системе
    // выход: -
    // исключения:
    //  - AirportNotFoundException - аэропорт с данным кодом не найден
    //  - InvalidCodeException - переданный код не является валидным кодом аэропорта
    public void edit(Airport airport) {
        String code = airport.getCode();;
        validateCode(code);
        if (storage.selectByCode(code).isEmpty()) {
            throw new AirportNotFoundException(code);
        }
        storage.update(airport);
    }

    // validateCode - вспомогательный метод валидации кода
    private void validateCode(String code) {
        if (code == null) {
            throw new InvalidCodeException("null", "code is null");
        }
        if (!code.matches("[A-Z]{3}")) {
            throw new InvalidCodeException(code, "code can contains only three uppercase letters");
        }
    }
}
