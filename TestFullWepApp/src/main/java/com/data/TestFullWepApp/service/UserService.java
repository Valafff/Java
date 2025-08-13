package com.data.TestFullWepApp.service;

import com.data.TestFullWepApp.model.User;
import com.data.TestFullWepApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Сервис для управления пользователями.
 * Предоставляет методы для регистрации и входа пользователей с использованием хэширования паролей.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Регистрирует нового пользователя с хэшированным паролем.
     * @param username Имя пользователя.
     * @param password Пароль в открытом виде.
     * @return Созданный объект пользователя.
     */
    public User register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        // Хэшируем пароль перед сохранением в базу данных
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    /**
     * Выполняет вход пользователя в систему, проверяя хэшированный пароль.
     * @param username Имя пользователя.
     * @param password Пароль в открытом виде для проверки.
     * @return Объект пользователя в случае успеха, иначе null.
     */
    public User login(String username, String password) {
        return userRepository.findByUsername(username)
                // Проверяем, совпадает ли предоставленный пароль с хэшем в базе данных
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(null);
    }
}
