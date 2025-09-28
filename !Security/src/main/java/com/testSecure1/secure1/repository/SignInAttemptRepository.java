package com.testSecure1.secure1.repository;

import com.testSecure1.secure1.entity.SignInAttempt;
import com.testSecure1.secure1.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Помечает интерфейс как репозиторий Spring (компонент доступа к данным)
public interface SignInAttemptRepository extends JpaRepository<SignInAttempt, Long> { // Наследует JpaRepository с указанием сущности и типа ID
    Page<SignInAttempt> findByUser(User user, Pageable pageable); // Кастомный метод для поиска попыток входа по пользователю с пагинацией
}