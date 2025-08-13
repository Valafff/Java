package com.data.TestFullWepApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Главный класс приложения Spring Boot.
 */
@SpringBootApplication
// Указываем пакеты для сканирования компонентов (контроллеры, сервисы, конфигурации)
@ComponentScan(basePackages = {
        "com.data.TestFullWepApp.controller",
        "com.data.TestFullWepApp.service",
        "com.data.TestFullWepApp.config",
        "com.data.TestFullWepApp.rest"
})
// Включаем поддержку JPA репозиториев и указываем пакет, где они находятся
@EnableJpaRepositories(basePackages = "com.data.TestFullWepApp.repository")
// Указываем пакеты для сканирования сущностей (моделей)
@EntityScan(basePackages = "com.data.TestFullWepApp.model")
public class TestFullWepAppApplication {

    /**
     * Точка входа в приложение.
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        SpringApplication.run(TestFullWepAppApplication.class, args);
    }

}