package com.testSecure1.secure1.repository;

import com.testSecure1.secure1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Помечает интерфейс как репозиторий Spring (компонент доступа к данным)
public interface UserRepository extends JpaRepository<User, Long> { // Наследует JpaRepository с указанием сущности User и типа ID Long
    Optional<User> findByUsername(String username); // Кастомный метод для поиска пользователя по имени пользователя
}