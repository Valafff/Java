package com.jirbaza.health.mappers;

import com.jirbaza.health.dto.AdditionalActivityDTO;
import com.jirbaza.health.entities.AdditionalActivity;
import com.jirbaza.health.entities.UserPerDayAdditionalActivities;
import org.springframework.stereotype.Component;

@Component //-отмечает класс как Spring Bean. Можно не добавлять в конфигураионный файл
public class AdditionalActivityDTOToAdditionalActivityEntity {

    public AdditionalActivity map(AdditionalActivityDTO dto) {
        if (dto == null) {
            return null;
        }

        AdditionalActivity entity = new AdditionalActivity();
        entity.setId(dto.getId());
        entity.setActivityType(dto.getActivityType());
        entity.setImagePath(dto.getImagePath());
        entity.setCalorieConsumptionBy60kg30yearMalePerHour(dto.getCalorieConsumptionBy60kg30yearMalePerHour());
        entity.setCalorieConsumptionBy60kg30yearFemalePerHour(dto.getCalorieConsumptionBy60kg30yearFemalePerHour());

        // Преобразование связи: из ID в объект (только если ID указан)
        if (dto.getUserPerDayActivityId() != null) {
            UserPerDayAdditionalActivities userActivity = new UserPerDayAdditionalActivities();
            userActivity.setId(dto.getUserPerDayActivityId());
            entity.setUserPerDayActivity(userActivity);
        }

        return entity;
    }
}