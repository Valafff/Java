package com.data.TestFullWepApp.rest;

import com.data.TestFullWepApp.dto.AuthRequest;
import com.data.TestFullWepApp.model.User;
import com.data.TestFullWepApp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST-контроллер для аутентификации.
 * Предоставляет API для регистрации, входа и выхода пользователей.
 */
@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication API", description = "API для регистрации и аутентификации пользователей")
public class AuthRestController {

    @Autowired
    private UserService userService;

    /**
     * API для регистрации нового пользователя.
     * @param authRequest DTO с именем пользователя и паролем.
     * @return Ответ с сообщением об успехе или ошибке.
     */
    @PostMapping("/register")
    @Operation(summary = "Регистрация нового пользователя")
    public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) {
        if (authRequest.getUsername() == null || authRequest.getPassword() == null) {
            return ResponseEntity.badRequest().body("Имя пользователя и пароль не могут быть пустыми");
        }
        userService.register(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

    /**
     * API для входа пользователя в систему.
     * @param authRequest DTO с именем пользователя и паролем.
     * @param session HTTP-сессия для сохранения состояния пользователя.
     * @return Ответ с сообщением об успехе или ошибке.
     */
    @PostMapping("/login")
    @Operation(summary = "Вход пользователя в систему")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest, HttpSession session) {
        User user = userService.login(authRequest.getUsername(), authRequest.getPassword());
        if (user != null) {
            session.setAttribute("user", user);
            return ResponseEntity.ok("Вход выполнен успешно");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверное имя пользователя или пароль");
    }

    /**
     * API для выхода пользователя из системы.
     * @param session HTTP-сессия, которая будет завершена.
     * @return Ответ с сообщением об успехе.
     */
    @PostMapping("/logout")
    @Operation(summary = "Выход пользователя из системы")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Выход выполнен успешно");
    }
}
