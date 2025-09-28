package com.testSecure1.secure1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Основная аннотация Spring Boot, объединяющая три аннотации:
// 1. @Configuration - помечает класс как источник конфигурации бинов
// 2. @ComponentScan - включает сканирование компонентов в текущем пакете и подпакетах
// 3. @EnableAutoConfiguration - включает автоматическую конфигурацию Spring Boot
public class Secure1Application { // Основной класс приложения Spring Boot

	public static void main(String[] args) { // Главный метод, точка входа в приложение
		SpringApplication.run(Secure1Application.class, args); // Запуск Spring Boot приложения:
		// - Secure1Application.class: основной класс конфигурации
		// - args: аргументы командной строки
		// Метод создает ApplicationContext и запускает приложение
	}

}