package com.apimvcexample.HW17_ApiMvcPractice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Practice HW17 MVC API")
                        .version("1.0")
                        .description("Документация API для приложения HW17"));
        }
}
