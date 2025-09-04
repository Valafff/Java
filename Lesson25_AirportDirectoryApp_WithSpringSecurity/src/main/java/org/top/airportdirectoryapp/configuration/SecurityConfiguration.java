package org.top.airportdirectoryapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // настройка конфига защиты
        http.authorizeHttpRequests(r ->
            r.requestMatchers("/", "/api/**", "/webjars/**", "/login/**").permitAll()
                .requestMatchers("/airport").authenticated()
                .requestMatchers("/airport/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        ).formLogin(form -> form.permitAll().defaultSuccessUrl("/"));

        // сборка конфига защиты
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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

}
