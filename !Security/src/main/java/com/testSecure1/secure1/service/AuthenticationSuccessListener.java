package com.testSecure1.secure1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component // Помечает класс как компонент Spring (управляемый бин)
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> { // Реализует интерфейс слушателя событий успешной аутентификации

    @Autowired // Внедрение зависимости UserService через автосвязывание
    private UserService userService; // Сервис для работы с пользователями

    @Override // Переопределение метода родительского интерфейса
    public void onApplicationEvent(AuthenticationSuccessEvent event) { // Обработчик события успешной аутентификации
        String username = ((UserDetails) event.getAuthentication().getPrincipal()).getUsername(); // Извлечение имени пользователя из UserDetails
        userService.recordLoginAttempt(username, true); // Вызов сервиса для записи успешной попытки входа (true = успешная)
    }
}