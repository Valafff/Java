package com.testSecure1.secure1.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Указывает, что этот класс является JPA сущностью
@Table(name = "sign_in_attempts") // Задает имя таблицы в базе данных
public class SignInAttempt {

    @Id // Поле является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент для первичного ключа
    private Long id; // Уникальный идентификатор записи

    private LocalDateTime attemptTime; // Время попытки входа

    private boolean successful; // Флаг успешности попытки входа (true/false)

    @ManyToOne(fetch = FetchType.LAZY) // Многие-к-одному: много попыток к одному пользователю
    @JoinColumn(name = "user_id", nullable = false) // Внешний ключ к таблице users, не может быть null
    private User user; // Ссылка на объект пользователя

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для времени попытки
    public LocalDateTime getAttemptTime() {
        return attemptTime;
    }

    // Сеттер для времени попытки
    public void setAttemptTime(LocalDateTime attemptTime) {
        this.attemptTime = attemptTime;
    }

    // Геттер для флага успешности
    public boolean isSuccessful() {
        return successful;
    }

    // Сеттер для флага успешности
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    // Геттер для объекта пользователя
    public User getUser() {
        return user;
    }

    // Сеттер для объекта пользователя
    public void setUser(User user) {
        this.user = user;
    }
}