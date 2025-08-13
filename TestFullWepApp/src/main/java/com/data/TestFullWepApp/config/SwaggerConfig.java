package com.data.TestFullWepApp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс для Swagger (OpenAPI).
 * Настраивает основную информацию для генерируемой документации API.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Создает и настраивает бин OpenAPI.
     * @return Сконфигурированный объект OpenAPI с информацией о приложении.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TestFullWepApp API")
                        .version("1.0")
                        .description("Документация API для приложения TestFullWepApp"));
    }
}