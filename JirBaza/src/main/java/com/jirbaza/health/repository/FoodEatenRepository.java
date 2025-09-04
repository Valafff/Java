package com.jirbaza.health.repository;

import com.jirbaza.health.entities.FoodEaten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodEatenRepository  extends JpaRepository<FoodEaten, String>
{
}
