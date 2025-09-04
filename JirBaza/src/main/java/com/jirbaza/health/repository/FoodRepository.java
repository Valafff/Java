package com.jirbaza.health.repository;

import com.jirbaza.health.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository  extends JpaRepository<Food, String>
{

}
