package com.testSecure1.secure1.controller;

import com.testSecure1.secure1.entity.SignInAttempt;
import com.testSecure1.secure1.entity.User;
import com.testSecure1.secure1.repository.SignInAttemptRepository;
import com.testSecure1.secure1.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller // Помечает класс как Spring MVC Controller
public class UserController {

    @Autowired // Внедрение зависимости UserService
    private UserService userService;

    @Autowired // Внедрение зависимости SignInAttemptRepository
    private SignInAttemptRepository signInAttemptRepository;

    @GetMapping("/") // Обрабатывает GET запросы на корневой URL
    public String index() {
        return "index"; // Возвращает имя представления index.html
    }

    @GetMapping("/register") // Обрабатывает GET запросы на /register
    public String showRegistrationForm() {
        return "register"; // Возвращает имя представления register.html
    }

    @PostMapping("/register") // Обрабатывает POST запросы на /register
    public String registerUser(@RequestParam String username, // Получает параметр username из формы
                               @RequestParam String password, // Получает параметр password из формы
                               Model model) { // Model для передачи данных в представление
        User user = userService.registerUser(username, password); // Вызов сервиса для регистрации пользователя
        if (user == null) { // Если пользователь уже существует
            model.addAttribute("error", "User with this username already exists."); // Добавляем сообщение об ошибке
            return "register"; // Возвращаем на страницу регистрации
        }
        // Добавлен параметр для отображения сообщения об успешной регистрации
        return "redirect:/login?registered"; // Перенаправляем на страницу логина с параметром
    }

    @GetMapping("/login") // Обрабатывает GET запросы на /login
    public String showLoginForm(@RequestParam(value = "error", required = false) String error, // Опциональный параметр error
                                @RequestParam(value = "registered", required = false) String registered, // Опциональный параметр registered
                                Model model) { // Model для передачи данных в представление
        if (error != null) { // Если был передан параметр error
            model.addAttribute("error", "Invalid username or password"); // Добавляем сообщение об ошибке
        }
        if (registered != null) { // Если был передан параметр registered
            model.addAttribute("message", "Registration successful! Please login."); // Добавляем сообщение об успехе
        }

        return "login"; // Возвращает имя представления login.html
    }

    @GetMapping("/user-data") // Обрабатывает GET запросы на /user-data
    public String userData(Model model, // Model для передачи данных в представление
                           Principal principal, // Объект Principal с информацией об аутентифицированном пользователе
                           @RequestParam(defaultValue = "0") int page) { // Параметр пагинации, по умолчанию 0
        // Проверка на аутентификацию
        if (principal == null) { // Если пользователь не аутентифицирован
            return "redirect:/login"; // Перенаправляем на страницу логина
        }

        Optional<User> userOptional = userService.findByUsername(principal.getName()); // Ищем пользователя по имени
        if (userOptional.isPresent()) { // Если пользователь найден
            User user = userOptional.get(); // Получаем объект пользователя
            model.addAttribute("user", user); // Добавляем пользователя в модель
            Pageable pageable = PageRequest.of(page, 10); // Создаем объект пагинации (10 записей на страницу)
            Page<SignInAttempt> signInAttempts = signInAttemptRepository.findByUser(user, pageable); // Получаем страницу попыток входа
            model.addAttribute("signInAttempts", signInAttempts); // Добавляем попытки входа в модель
        } else {
            // Если пользователь не найден в БД, но Principal существует
            return "redirect:/login?error"; // Перенаправляем с ошибкой
        }
        return "user-data"; // Возвращает имя представления user-data.html
    }

    @PostMapping("/delete-account") // Обрабатывает POST запросы на /delete-account
    public String deleteAccount(Principal principal, // Объект Principal с информацией об пользователе
                                HttpServletRequest request) { // HttpServletRequest для работы с сессией
        if (principal == null) { // Если пользователь не аутентифицирован
            return "redirect:/login"; // Перенаправляем на страницу логина
        }

        Optional<User> userOptional = userService.findByUsername(principal.getName()); // Ищем пользователя по имени
        if (userOptional.isPresent()) { // Если пользователь найден
            userService.deleteUser(userOptional.get().getId()); // Удаляем пользователя через сервис
            HttpSession session = request.getSession(false); // Получаем текущую сессию (без создания новой)
            if (session != null) { // Если сессия существует
                session.invalidate(); // Инвалидируем сессию
            }
            SecurityContextHolder.clearContext(); // Очищаем контекст безопасности Spring
        }
        return "redirect:/"; // Перенаправляем на главную страницу
    }
}