package com.testSecure1.secure1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component // Помечает класс как компонент Spring (управляемый бин)
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> { // Реализует интерфейс слушателя событий

    @Autowired // Внедрение зависимости UserService через автосвязывание
    private UserService userService; // Сервис для работы с пользователями

    @Override // Переопределение метода родительского интерфейса
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) { // Обработчик события неудачной аутентификации
        String username = (String) event.getAuthentication().getPrincipal(); // Извлечение имени пользователя из события
        userService.recordLoginAttempt(username, false); // Вызов сервиса для записи неудачной попытки входа
    }
}