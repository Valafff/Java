package com.jirbaza.health.mappers;

import com.jirbaza.health.dto.FoodEatenDTO;
import com.jirbaza.health.entities.FoodEaten;
import com.jirbaza.health.entities.Food;
import com.jirbaza.health.entities.UserDiaryPerDay;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodEatenDTOToFoodEatenEntity {

    public FoodEaten map(FoodEatenDTO dto) {
        if (dto == null) {
            return null;
        }

        FoodEaten entity = new FoodEaten();
        entity.setId(dto.getId());
        entity.setMassNetto(dto.getMassNetto());
        entity.setTotalCalories(dto.getTotalCalories());

        // Создание заглушек для связанных сущностей (только ID)
        if (dto.getFoodId() != null) {
            Food food = new Food();
            food.setId(dto.getFoodId());
            entity.setFood(food);
        }

        if (dto.getUserDiaryPerDayId() != null) {
            UserDiaryPerDay userDiaryPerDay = new UserDiaryPerDay();
            userDiaryPerDay.setId(dto.getUserDiaryPerDayId());
            entity.setUserDiaryPerDay(userDiaryPerDay);
        }

        return entity;
    }

    // Метод для частичного обновления существующей entity
    public FoodEaten map(FoodEatenDTO dto, FoodEaten existingEntity) {
        if (dto == null || existingEntity == null) {
            return existingEntity;
        }

        // Обновляем только те поля, которые пришли в DTO
        if (dto.getMassNetto() != null) {
            existingEntity.setMassNetto(dto.getMassNetto());
        }
        if (dto.getTotalCalories() != null) {
            existingEntity.setTotalCalories(dto.getTotalCalories());
        }

        // Обновление связей (только если переданы новые ID)
        if (dto.getFoodId() != null) {
            Food food = new Food();
            food.setId(dto.getFoodId());
            existingEntity.setFood(food);
        }

        if (dto.getUserDiaryPerDayId() != null) {
            UserDiaryPerDay userDiaryPerDay = new UserDiaryPerDay();
            userDiaryPerDay.setId(dto.getUserDiaryPerDayId());
            existingEntity.setUserDiaryPerDay(userDiaryPerDay);
        }

        return existingEntity;
    }

    // Дополнительные методы для коллекций
    public List<FoodEaten> mapList(List<FoodEatenDTO> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}