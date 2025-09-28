package com.testSecure1.secure1.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;

@Configuration // Помечает класс как класс конфигурации Spring
@EnableWebSecurity // Включает поддержку веб-безопасности Spring Security
public class SecurityConfig {

    @Bean // Создает бин SecurityFilterChain для настройки безопасности
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize // Настройка авторизации запросов
                        .requestMatchers("/", "/register", "/login", "/css/**", "/error").permitAll() // Разрешаем доступ к указанным URL без аутентификации
                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
                )
                .formLogin(form -> form // Настройка формы логина
                        .loginPage("/login") // Указываем кастомную страницу логина
                        .failureHandler(authenticationFailureHandler()) // Используем кастомный обработчик неудачных аутентификаций
                        .defaultSuccessUrl("/user-data", true) // URL для перенаправления после успешного логина
                        .permitAll() // Разрешаем доступ к форме логина всем
                )
                .logout(logout -> logout // Настройка выхода из системы
                        .logoutUrl("/logout") // URL для выхода
                        .logoutSuccessUrl("/") // URL для перенаправления после выхода
                        .invalidateHttpSession(true) // Инвалидируем сессию при выходе
                        .deleteCookies("JSESSIONID") // Удаляем JSESSIONID cookie при выходе
                        .permitAll() // Разрешаем выход всем
                );
        return http.build(); // Собираем и возвращаем конфигурацию безопасности
    }

    @Bean // Создает бин для кодирования паролей
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Используем BCrypt для хеширования паролей
    }

    @Bean // Создает кастомный обработчик неудачной аутентификации
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler("/login?error") { // Наследуемся от стандартного обработчика
            @Override
            public void onAuthenticationFailure(HttpServletRequest request,
                                                HttpServletResponse response,
                                                AuthenticationException exception) throws IOException, ServletException {

                // Сохраняем исключение в сессии для отображения на странице логина
                if (exception instanceof LockedException) {
                    request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception);
                } else {
                    // Для других ошибок тоже сохраняем, но с общим сообщением
                    request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION",
                            new LockedException("Invalid username or password"));
                }

                super.onAuthenticationFailure(request, response, exception); // Вызываем родительский метод
            }
        };
    }
}