package com.data.TestFullWepApp.controller;

import com.data.TestFullWepApp.model.User;
import com.data.TestFullWepApp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер для аутентификации пользователей (веб-интерфейс).
 * Обрабатывает запросы, связанные с регистрацией, входом и выходом из системы через HTML-страницы.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    /**
     * Отображает страницу с формой регистрации.
     * @return Название HTML-шаблона для страницы регистрации.
     */
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    /**
     * Регистрирует нового пользователя в системе.
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     * @return Редирект на страницу входа.
     */
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        userService.register(username, password);
        return "redirect:/auth/login";
    }

    /**
     * Отображает страницу с формой входа.
     * @return Название HTML-шаблона для страницы входа.
     */
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    /**
     * Выполняет вход пользователя в систему.
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     * @param session HTTP-сессия для хранения данных пользователя.
     * @return Редирект на страницу калькулятора в случае успеха, иначе обратно на страницу входа с ошибкой.
     */
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/calculate";
        }
        return "redirect:/auth/login?error";
    }

    /**
     * Выполняет выход пользователя из системы.
     * @param session HTTP-сессия, которая будет завершена.
     * @return Редирект на страницу входа.
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
