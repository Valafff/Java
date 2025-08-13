package com.data.TestFullWepApp.repository;

import com.data.TestFullWepApp.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculationRepository extends JpaRepository<Calculation, Long> {
    List<Calculation> findByUserId(Long userId);
}
