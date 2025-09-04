package org.top.airportdirectoryapp.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// AirportRepository - JPA-репозиторий для работы с аэропортами
@Repository
public interface AirportRepository extends JpaRepository<AirportDbEntity, Integer> {
    // findByCode - получение записи по коду
    Optional<AirportDbEntity> findByCode(String code);
}
