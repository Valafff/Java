package org.top.airportdirectoryapp.storage;

import org.springframework.stereotype.Service;

import org.top.airportdirectoryapp.model.Airport;
import org.top.airportdirectoryapp.model.AirportStorage;

import java.util.List;
import java.util.Optional;

// RdbAirportStorage - реализация AirportStorage, работающая с РСУБД через JPA-репозиторий
@Service
public class RdbAirportStorage implements AirportStorage {

    private final AirportRepository repository;

    public RdbAirportStorage(AirportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Airport> selectAll() {
        return repository.findAll()
                .stream()
                .map(AirportDbEntity::asAirport)
                .toList();
    }

    @Override
    public Optional<Airport> selectByCode(String code) {
        Optional<AirportDbEntity> dbAirport = repository.findByCode(code);
        return dbAirport.map(AirportDbEntity::asAirport);
    }

    @Override
    public void insert(Airport airport) {
        AirportDbEntity dbAirport = new AirportDbEntity(airport);
        repository.save(dbAirport);
    }

    @Override
    public void deleteByCode(String code) {
        Optional<AirportDbEntity> deleted = repository.findByCode(code);
        deleted.ifPresent(repository::delete);
    }

    @Override
    public void update(Airport airport) {
        Optional<AirportDbEntity> dbAirportOptional = repository.findByCode(airport.getCode());
        if (dbAirportOptional.isEmpty()) {
            return;
        }
        AirportDbEntity dbAirport = dbAirportOptional.get(); // в dbAirport задан id существующей в БД записи
        dbAirport.setName(airport.getName());
        dbAirport.setRunwayCount(airport.getRunwayCount());
        repository.save(dbAirport);
    }
}
