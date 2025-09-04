package com.jirbaza.health.mappers;

import com.jirbaza.health.dto.UserDTO;
import com.jirbaza.health.entities.User;
import com.jirbaza.health.entities.UsersFood;
import com.jirbaza.health.entities.UserDiaryPerDay;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDTOToUserEntity {

    public User map(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        User entity = new User();
        entity.setId(dto.getId());
        entity.setNickName(dto.getNickName());
        entity.setPassword(dto.getPassword());
        entity.setRegistrationDate(dto.getRegistrationDate());
        entity.setImagePath(dto.getImagePath());
        entity.setAge(dto.getAge());
        entity.setHeight(dto.getHeight());
        entity.setGender(dto.getGender());
        entity.setStartWeight(dto.getStartWeight());
        entity.setCurrentWeight(dto.getCurrentWeight());
        entity.setTargetWeight(dto.getTargetWeight());

        // Связи должны управляться через отдельные сервисы
        // Здесь мы не восстанавливаем полные связи, только устанавливаем пустые коллекции
        // чтобы избежать NullPointerException

        return entity;
    }

    // Метод для частичного обновления существующей entity
    public User map(UserDTO dto, User existingEntity) {
        if (dto == null || existingEntity == null) {
            return existingEntity;
        }

        // Обновляем только те поля, которые пришли в DTO и не null
        if (dto.getNickName() != null) {
            existingEntity.setNickName(dto.getNickName());
        }
        if (dto.getPassword() != null) {
            existingEntity.setPassword(dto.getPassword());
        }
        if (dto.getRegistrationDate() != null) {
            existingEntity.setRegistrationDate(dto.getRegistrationDate());
        }
        if (dto.getImagePath() != null) {
            existingEntity.setImagePath(dto.getImagePath());
        }
        if (dto.getAge() != null) {
            existingEntity.setAge(dto.getAge());
        }
        if (dto.getHeight() != null) {
            existingEntity.setHeight(dto.getHeight());
        }
        if (dto.getGender() != null) {
            existingEntity.setGender(dto.getGender());
        }
        if (dto.getStartWeight() != null) {
            existingEntity.setStartWeight(dto.getStartWeight());
        }
        if (dto.getCurrentWeight() != null) {
            existingEntity.setCurrentWeight(dto.getCurrentWeight());
        }
        if (dto.getTargetWeight() != null) {
            existingEntity.setTargetWeight(dto.getTargetWeight());
        }

        // Связи не обновляются через этот метод - они управляются отдельно

        return existingEntity;
    }
}