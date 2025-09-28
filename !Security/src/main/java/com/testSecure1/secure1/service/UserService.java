package com.testSecure1.secure1.service;

import com.testSecure1.secure1.entity.SignInAttempt;
import com.testSecure1.secure1.entity.User;
import com.testSecure1.secure1.repository.SignInAttemptRepository;
import com.testSecure1.secure1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service // Помечает класс как сервисный компонент Spring (бизнес-логика)
public class UserService {

    @Autowired // Внедрение зависимости UserRepository
    private UserRepository userRepository; // Репозиторий для работы с пользователями

    @Autowired // Внедрение зависимости SignInAttemptRepository
    private SignInAttemptRepository signInAttemptRepository; // Репозиторий для записи попыток входа

    @Autowired // Внедрение зависимости PasswordEncoder
    private PasswordEncoder passwordEncoder; // Кодировщик паролей

    private static final int MAX_FAILED_ATTEMPTS = 5; // Максимальное количество неудачных попыток перед блокировкой
    private static final int LOCK_TIME_MINUTES = 30; // Время блокировки в минутах

    public User registerUser(String username, String password) { // Метод регистрации нового пользователя
        if (userRepository.findByUsername(username).isPresent()) { // Проверка существования пользователя
            return null; // Возврат null если пользователь уже существует
        }
        User user = new User(); // Создание нового объекта пользователя
        user.setUsername(username); // Установка имени пользователя
        user.setPassword(passwordEncoder.encode(password)); // Кодирование и установка пароля
        user.setFailedLoginAttempts(0); // Инициализация счетчика неудачных попыток
        user.setLockTime(null); // Инициализация времени блокировки
        return userRepository.save(user); // Сохранение пользователя в БД и возврат
    }

    public Optional<User> findByUsername(String username) { // Поиск пользователя по имени
        return userRepository.findByUsername(username); // Делегирование запроса репозиторию
    }

    public void deleteUser(Long userId) { // Удаление пользователя по ID
        userRepository.deleteById(userId); // Делегирование удаления репозиторию
    }

    // Сохранить пользователя (для использования в листенере)
    public User saveUser(User user) { // Сохранение пользователя
        return userRepository.save(user); // Делегирование сохранения репозиторию
    }

    // Сброс счетчика неудачных попыток
    @Transactional // Аннотация транзакционности
    public void resetFailedAttempts(String username) { // Сброс счетчика попыток
        Optional<User> userOptional = userRepository.findByUsername(username); // Поиск пользователя
        if (userOptional.isPresent()) { // Если пользователь найден
            User user = userOptional.get(); // Получение объекта пользователя
            user.setFailedLoginAttempts(0); // Сброс счетчика попыток
            user.setLockTime(null); // Сброс времени блокировки
            userRepository.save(user); // Сохранение изменений
        }
    }

    // Запись попытки входа с правильной логикой блокировки
    @Transactional // Аннотация транзакционности
    public void recordLoginAttempt(String username, boolean success) { // Запись попытки входа
        Optional<User> userOptional = userRepository.findByUsername(username); // Поиск пользователя
        if (userOptional.isPresent()) { // Если пользователь найден
            User user = userOptional.get(); // Получение объекта пользователя

            // Записываем попытку входа
            SignInAttempt attempt = new SignInAttempt(); // Создание новой попытки входа
            attempt.setUser(user); // Установка связи с пользователем
            attempt.setAttemptTime(LocalDateTime.now()); // Установка времени попытки
            attempt.setSuccessful(success); // Установка флага успешности
            signInAttemptRepository.save(attempt); // Сохранение попытки входа

            // Обновляем счетчик попыток только если аккаунт не заблокирован
            if (user.getLockTime() == null || user.getLockTime().isBefore(LocalDateTime.now())) {
                if (success) {
                    // Успешный вход - сбрасываем счетчик
                    user.setFailedLoginAttempts(0); // Сброс счетчика
                    user.setLockTime(null); // Сброс блокировки
                } else {
                    // Неудачный вход - увеличиваем счетчик
                    int newFailedAttempts = user.getFailedLoginAttempts() + 1; // Увеличение счетчика
                    user.setFailedLoginAttempts(newFailedAttempts); // Установка нового значения

                    // Блокируем если достигли лимита
                    if (newFailedAttempts >= MAX_FAILED_ATTEMPTS) { // Проверка достижения лимита
                        user.setLockTime(LocalDateTime.now().plusMinutes(LOCK_TIME_MINUTES)); // Установка времени блокировки
                    }
                }
                userRepository.save(user); // Сохранение изменений пользователя
            }
        }
    }

    // Проверка, заблокирован ли пользователь
    public boolean isUserLocked(String username) { // Проверка блокировки пользователя
        Optional<User> userOptional = userRepository.findByUsername(username); // Поиск пользователя
        if (userOptional.isPresent()) { // Если пользователь найден
            User user = userOptional.get(); // Получение объекта пользователя
            return user.getLockTime() != null && user.getLockTime().isAfter(LocalDateTime.now()); // Проверка актуальности блокировки
        }
        return false; // Возврат false если пользователь не найден
    }

    // Получение оставшегося времени блокировки
    public long getRemainingLockTime(String username) { // Расчет оставшегося времени блокировки
        Optional<User> userOptional = userRepository.findByUsername(username); // Поиск пользователя
        if (userOptional.isPresent()) { // Если пользователь найден
            User user = userOptional.get(); // Получение объекта пользователя
            if (user.getLockTime() != null && user.getLockTime().isAfter(LocalDateTime.now())) { // Проверка актуальности блокировки
                return java.time.Duration.between(LocalDateTime.now(), user.getLockTime()).toMinutes(); // Расчет оставшихся минут
            }
        }
        return 0; // Возврат 0 если блокировки нет или она истекла
    }
}