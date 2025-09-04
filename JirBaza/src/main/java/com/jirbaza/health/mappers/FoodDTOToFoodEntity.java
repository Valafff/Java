package com.jirbaza.health.mappers;

import com.jirbaza.health.dto.FoodDTO;
import com.jirbaza.health.entities.Food;
import com.jirbaza.health.entities.UsersFood;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FoodDTOToFoodEntity {

    public Food map(FoodDTO dto) {
        if (dto == null) {
            return null;
        }

        Food entity = new Food();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setImagePath(dto.getImagePath());
        entity.setCalorieBy100gr(dto.getCalorieBy100gr());
        entity.setGlycemicIndex(dto.getGlycemicIndex());

        // ВАЖНО: При преобразовании из DTO в Entity мы НЕ восстанавливаем
        // полную связь с UsersFood, так как это может привести к
        // непредсказуемому поведению и циклическим ссылкам.
        // Связи должны управляться через отдельные сервисы.

        return entity;
    }

    // Метод для частичного обновления существующей entity
    public Food map(FoodDTO dto, Food existingEntity) {
        if (dto == null || existingEntity == null) {
            return existingEntity;
        }

        // Обновляем только те поля, которые пришли в DTO
        if (dto.getTitle() != null) {
            existingEntity.setTitle(dto.getTitle());
        }
        if (dto.getImagePath() != null) {
            existingEntity.setImagePath(dto.getImagePath());
        }
        if (dto.getCalorieBy100gr() != null) {
            existingEntity.setCalorieBy100gr(dto.getCalorieBy100gr());
        }
        if (dto.getGlycemicIndex() != null) {
            existingEntity.setGlycemicIndex(dto.getGlycemicIndex());
        }

        return existingEntity;
    }

    // Дополнительные методы для коллекций
    public Set<Food> mapSet(Set<FoodDTO> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }

    public List<Food> mapList(List<FoodDTO> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}