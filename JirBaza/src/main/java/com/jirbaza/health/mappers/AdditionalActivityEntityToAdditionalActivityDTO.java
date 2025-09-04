package com.jirbaza.health.mappers;

import com.jirbaza.health.dto.AdditionalActivityDTO;
import com.jirbaza.health.entities.AdditionalActivity;
import org.springframework.stereotype.Component;

@Component
public class AdditionalActivityEntityToAdditionalActivityDTO {

    public AdditionalActivityDTO map(AdditionalActivity entity) {
        if (entity == null) {
            return null;
        }

        AdditionalActivityDTO dto = new AdditionalActivityDTO();
        dto.setId(entity.getId());
        dto.setActivityType(entity.getActivityType());
        dto.setImagePath(entity.getImagePath());
        dto.setCalorieConsumptionBy60kg30yearMalePerHour(entity.getCalorieConsumptionBy60kg30yearMalePerHour());
        dto.setCalorieConsumptionBy60kg30yearFemalePerHour(entity.getCalorieConsumptionBy60kg30yearFemalePerHour());

        // Преобразование связи: из объекта в ID
        if (entity.getUserPerDayActivity() != null) {
            dto.setUserPerDayActivityId(entity.getUserPerDayActivity().getId());
        }

        return dto;
    }
}