package org.top.airportdirectoryapp.stub;

import org.top.airportdirectoryapp.model.Airport;
import org.top.airportdirectoryapp.model.AirportStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// AirportStorageStub - in-memory заглушка для AirportStorage
public class AirportStorageStub implements AirportStorage {

    private final List<Airport> airports = new ArrayList<Airport>();

    public AirportStorageStub() {
        airports.add(new Airport("DME", "Аэропорт Домодедово", 3));
        airports.add(new Airport("BAX", "Аэропорт Барнаул", 1));
    }

    @Override
    public List<Airport> selectAll() {
        return airports;
    }

    @Override
    public Optional<Airport> selectByCode(String code) {
        return airports.stream().filter(a -> a.getCode().equals(code)).findFirst();
    }

    @Override
    public void insert(Airport airport) {
        airports.add(airport);
    }

    @Override
    public void deleteByCode(String code) {
        airports.removeIf(a -> a.getCode().equals(code));
    }

    @Override
    public void update(Airport airport) {
        deleteByCode(airport.getCode());
        insert(airport);
    }
}
