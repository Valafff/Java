package org.top.airportdirectoryapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.top.airportdirectoryapp.security.DbUserDetailsService;
import org.top.airportdirectoryapp.security.LockoutAuthenticationFailureHandler;
import org.top.airportdirectoryapp.storage.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // Константы для настройки lockout-блокировок
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final int LOCKOUT_DURATION_MINUTES = 15;

    private final UserRepository userRepository;
    private final LockoutAuthenticationFailureHandler lockoutFailureHandler;

    public SecurityConfiguration(UserRepository userRepository, DataSource dataSource, 
                               LockoutAuthenticationFailureHandler lockoutFailureHandler) {
        this.userRepository = userRepository;
        this.dataSource = dataSource;
        this.lockoutFailureHandler = lockoutFailureHandler;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // настройка конфига защиты
        http.authorizeHttpRequests(r ->
            r.requestMatchers("/", "/api/**", "/webjars/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/airport").authenticated()
                .requestMatchers("/airport/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        ).formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/")
                .failureHandler(lockoutFailureHandler)
                .successHandler(authenticationSuccessHandler())
        )
        .csrf(AbstractHttpConfigurer::disable);

        // сборка конфига защиты
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                              org.springframework.security.core.Authentication authentication) 
                                              throws IOException, ServletException {
                // Сбрасываем счетчик неудачных попыток при успешной аутентификации
                String username = authentication.getName();
                if (username != null) {
                    userRepository.resetFailedAttempts(username);
                }
                response.sendRedirect("/");
            }
        };
    }

    // СЕРВИСЫ ДЛЯ ВНЕДРЕНИЯ КОМПОНЕНТОВ БД-СЕРВИСОВ В ИСПОЛЬЗОВАНИЕ SPRING SECURITY

    @Bean
    public UserDetailsService userDetailsService() {
        return new DbUserDetailsService(userRepository);
    }

    // Зависимости, необходимые для работы Spring Security
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    private final DataSource dataSource;

    @Bean
    public UserDetailsManager users(HttpSecurity http) throws Exception {
        // Создаем AuthenticationManagerBuilder без использования deprecated .and()
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
        
        // Добавляем authentication provider отдельно
        authBuilder.authenticationProvider(daoAuthenticationProvider());
        
        AuthenticationManager authenticationManager = authBuilder.build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setAuthenticationManager(authenticationManager);
        return jdbcUserDetailsManager;
    }


    /*
    // сервис для работы с пользователями
    // реализованный в виде in-memory заглушки
    @Bean
    public UserDetailsService userDetailsService() {
        // подготовим тестовых пользователей через встроенные типы
        UserDetails user = User.builder()
            .username("user")
            .password("qwerty")
            .passwordEncoder(passwordEncoder()::encode)
            .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("qwerty")
                .passwordEncoder(passwordEncoder()::encode)
                .roles("ADMIN")
                .build();

        // подготовка тестовой имплементации UserDetailsService
        return new InMemoryUserDetailsManager(user, admin);
    }
    */
}
