package com.testSecure1.secure1.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // Указывает, что этот класс является JPA сущностью
@Table(name = "users") // Задает имя таблицы в базе данных
public class User {

    @Id // Поле является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент для первичного ключа
    private Long id; // Уникальный идентификатор пользователя

    @Column(unique = true, nullable = false) // Ограничения: уникальное значение, не может быть null
    private String username; // Имя пользователя (логин)

    @Column(nullable = false) // Ограничение: не может быть null
    private String password; // Зашифрованный пароль

    private int failedLoginAttempts; // Счетчик неудачных попыток входа

    private LocalDateTime lockTime; // Время блокировки аккаунта

    @OneToMany(mappedBy = "user", // Обратная сторона связи (поле "user" в классе SignInAttempt)
            cascade = CascadeType.ALL, // Каскадные операции (сохранение, удаление и т.д.)
            orphanRemoval = true) // Удаление "сирот" при удалении из коллекции
    private List<SignInAttempt> signInAttempts = new ArrayList<>(); // Список попыток входа

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для имени пользователя
    public String getUsername() {
        return username;
    }

    // Сеттер для имени пользователя
    public void setUsername(String username) {
        this.username = username;
    }

    // Геттер для пароля
    public String getPassword() {
        return password;
    }

    // Сеттер для пароля
    public void setPassword(String password) {
        this.password = password;
    }

    // Геттер для счетчика неудачных попыток входа
    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    // Сеттер для счетчика неудачных попыток входа
    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    // Геттер для времени блокировки
    public LocalDateTime getLockTime() {
        return lockTime;
    }

    // Сеттер для времени блокировки
    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    // Геттер для списка попыток входа
    public List<SignInAttempt> getSignInAttempts() {
        return signInAttempts;
    }

    // Сеттер для списка попыток входа
    public void setSignInAttempts(List<SignInAttempt> signInAttempts) {
        this.signInAttempts = signInAttempts;
    }
}