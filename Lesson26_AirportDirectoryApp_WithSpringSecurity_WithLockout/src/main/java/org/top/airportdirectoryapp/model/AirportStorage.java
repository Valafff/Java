package org.top.airportdirectoryapp.model;

import java.util.List;
import java.util.Optional;

// AirportStorage - интерфейс хранилища аэропортов
public interface AirportStorage {
    // selectAll - получение всех аэропортов из хранилища
    List<Airport> selectAll();

    // selectByCode - получение аэропорта по коду
    Optional<Airport> selectByCode(String code);

    // insert - вставка нового аэропорта
    void insert(Airport airport);

    // deleteByCode - удаление записи по коду
    void deleteByCode(String code);

    // update - обновление аэропорта
    void update(Airport airport);
}
