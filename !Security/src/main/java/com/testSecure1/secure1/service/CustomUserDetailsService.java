package com.testSecure1.secure1.service;

import com.testSecure1.secure1.entity.User;
import com.testSecure1.secure1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.LockedException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@Service // Помечает класс как сервисный компонент Spring (бизнес-логика)
public class CustomUserDetailsService implements UserDetailsService { // Реализует интерфейс UserDetailsService Spring Security

    @Autowired // Внедрение зависимости UserRepository через автосвязывание
    private UserRepository userRepository; // Репозиторий для работы с пользователями в БД

    @Override // Переопределение метода из интерфейса UserDetailsService
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, LockedException { // Основной метод для загрузки пользователя по имени
        User user = userRepository.findByUsername(username) // Поиск пользователя в репозитории
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username)); // Если не найден - исключение

        if (user.getLockTime() != null) { // Проверка наличия времени блокировки
            if (user.getLockTime().isAfter(LocalDateTime.now())) { // Проверка актуальности блокировки
                long minutesRemaining = ChronoUnit.MINUTES.between(LocalDateTime.now(), user.getLockTime()); // Расчет оставшегося времени блокировки
                throw new LockedException("User account is locked (From CustomUserDetailsService). Try again in " + (minutesRemaining + 1) + " minutes."); // Исключение с информацией о блокировке
            } else {
                // Unlock the user if the lock time has expired // Разблокировка пользователя при истечении времени
                user.setLockTime(null); // Сброс времени блокировки
                user.setFailedLoginAttempts(0); // Сброс счетчика неудачных попыток
                userRepository.save(user); // Сохранение изменений в БД
            }
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>()); // Создание UserDetails объекта для Spring Security
    }
}