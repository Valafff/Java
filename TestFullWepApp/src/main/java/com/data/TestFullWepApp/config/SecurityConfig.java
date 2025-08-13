package com.data.TestFullWepApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Конфигурационный класс для Spring Security.
 * Настраивает правила безопасности, кодировщик паролей и т.д.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Создает бин PasswordEncoder, который будет использоваться для хэширования паролей.
     * @return Экземпляр BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Настраивает цепочку фильтров безопасности.
     * Отключает CSRF и разрешает все HTTP-запросы, чтобы не нарушать текущую функциональность.
     * @param http Объект HttpSecurity для конфигурации.
     * @return Сконфигурированный объект SecurityFilterChain.
     * @throws Exception Если при конфигурации возникает ошибка.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Отключаем CSRF для простоты
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // Разрешаем все запросы
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
