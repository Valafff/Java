package com.jirbaza.health.mappers;

import com.jirbaza.health.dto.FoodDTO;
import com.jirbaza.health.entities.Food;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FoodEntityToFoodDTO {

    public FoodDTO map(Food entity) {
        if (entity == null) {
            return null;
        }

        FoodDTO dto = new FoodDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setImagePath(entity.getImagePath());
        dto.setCalorieBy100gr(entity.getCalorieBy100gr());
        dto.setGlycemicIndex(entity.getGlycemicIndex());

        // Преобразование коллекции UsersFood в коллекцию ID
        if (entity.getUsersFood() != null && !entity.getUsersFood().isEmpty()) {
            dto.setUsersFoodIds(
                    entity.getUsersFood().stream()
                            .map(usersFood -> usersFood.getId())
                            .collect(Collectors.toSet())
            );
        }

        return dto;
    }

    // Дополнительный метод для преобразования коллекций
    public Set<FoodDTO> mapSet(Set<Food> entities) {
        if (entities == null) {
            return null;
        }

        return entities.stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }

    // Дополнительный метод для преобразования списков
    public List<FoodDTO> mapList(List<Food> entities) {
        if (entities == null) {
            return null;
        }

        return entities.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}