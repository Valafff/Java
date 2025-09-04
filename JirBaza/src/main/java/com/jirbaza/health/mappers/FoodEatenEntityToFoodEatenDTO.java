package com.jirbaza.health.mappers;

import com.jirbaza.health.dto.FoodEatenDTO;
import com.jirbaza.health.entities.FoodEaten;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodEatenEntityToFoodEatenDTO {

    public FoodEatenDTO map(FoodEaten entity) {
        if (entity == null) {
            return null;
        }

        FoodEatenDTO dto = new FoodEatenDTO();
        dto.setId(entity.getId());
        dto.setMassNetto(entity.getMassNetto());
        dto.setTotalCalories(entity.getTotalCalories());

        // Преобразование связей в ID
        if (entity.getFood() != null) {
            dto.setFoodId(entity.getFood().getId());
        }
        if (entity.getUserDiaryPerDay() != null) {
            dto.setUserDiaryPerDayId(entity.getUserDiaryPerDay().getId());
        }

        return dto;
    }

    // Дополнительные методы для коллекций
    public List<FoodEatenDTO> mapList(List<FoodEaten> entities) {
        if (entities == null) {
            return null;
        }

        return entities.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public List<FoodEatenDTO> mapList(Iterable<FoodEaten> entities) {
        if (entities == null) {
            return null;
        }

        return ((List<FoodEaten>) entities).stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}