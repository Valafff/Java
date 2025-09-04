package com.jirbaza.health.mappers;
import com.jirbaza.health.dto.UserDTO;
import com.jirbaza.health.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserEntityToUserDTO {

    public UserDTO map(User entity) {
        if (entity == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setNickName(entity.getNickName());
        dto.setPassword(entity.getPassword()); // Осторожно: пароль в DTO
        dto.setRegistrationDate(entity.getRegistrationDate());
        dto.setImagePath(entity.getImagePath());
        dto.setAge(entity.getAge());
        dto.setHeight(entity.getHeight());
        dto.setGender(entity.getGender());
        dto.setStartWeight(entity.getStartWeight());
        dto.setCurrentWeight(entity.getCurrentWeight());
        dto.setTargetWeight(entity.getTargetWeight());

        // Преобразование связей в ID
        if (entity.getUsersFood() != null && !entity.getUsersFood().isEmpty()) {
            Set<Long> usersFoodIds = entity.getUsersFood().stream()
                    .map(usersFood -> usersFood.getId())
                    .collect(Collectors.toSet());
            dto.setUsersFoodIds(usersFoodIds);
        }

        if (entity.getUserDiaryPerDays() != null && !entity.getUserDiaryPerDays().isEmpty()) {
            Set<Long> diaryIds = entity.getUserDiaryPerDays().stream()
                    .map(diary -> diary.getId())
                    .collect(Collectors.toSet());
            dto.setUserDiaryPerDayIds(diaryIds);
        }

        return dto;
    }
}