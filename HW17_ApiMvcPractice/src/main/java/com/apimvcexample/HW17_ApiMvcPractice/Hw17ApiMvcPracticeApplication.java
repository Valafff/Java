package com.apimvcexample.HW17_ApiMvcPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Аннотация @SpringBootApplication объединяет:
// @Configuration, @EnableAutoConfiguration и @ComponentScan
@SpringBootApplication
public class Hw17ApiMvcPracticeApplication {


	public static void main(String[] args)
	{
		// Запуск Spring Boot приложения
		SpringApplication.run(Hw17ApiMvcPracticeApplication.class, args);
	}

}
