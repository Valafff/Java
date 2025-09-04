package org.top.airportdirectoryapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.top.airportdirectoryapp.model.AirportScenario;
import org.top.airportdirectoryapp.storage.AirportRepository;
import org.top.airportdirectoryapp.storage.RdbAirportStorage;

// ComponentConfiguration - класс-провайдер для создания сервисов с целью последующей инъекции в Spring-приложение
@Configuration
public class ComponentConfiguration {

    private final AirportRepository airportRepository;

    public ComponentConfiguration(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Bean
    public AirportScenario airports() {
        return new AirportScenario(new RdbAirportStorage(airportRepository));
    }
}
