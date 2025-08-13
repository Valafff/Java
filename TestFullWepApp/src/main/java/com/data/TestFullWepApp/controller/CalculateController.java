package com.data.TestFullWepApp.controller;

import com.data.TestFullWepApp.model.Calculation;
import com.data.TestFullWepApp.model.User;
import com.data.TestFullWepApp.service.CalculationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Контроллер для выполнения математических вычислений (веб-интерфейс).
 * Обрабатывает запросы от HTML-страницы калькулятора.
 */
@Controller
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private CalculationService calculationService;

    /**
     * Отображает страницу с формой калькулятора и историей вычислений.
     * @param session HTTP-сессия для получения данных о текущем пользователе.
     * @param model Модель для передачи данных в HTML-шаблон.
     * @return Название HTML-шаблона или редирект на страницу входа.
     */
    @GetMapping
    public String showCalculateForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        List<Calculation> calculations = calculationService.getCalculationsForUser(user.getId());
        model.addAttribute("calculations", calculations);
        return "calculate";
    }

    /**
     * Выполняет вычисление на основе переданного выражения и перезагружает страницу.
     * @param expression Математическое выражение для вычисления.
     * @param session HTTP-сессия для получения данных о текущем пользователе.
     * @return Редирект на страницу калькулятора.
     */
    @PostMapping
    public String calculate(@RequestParam String expression, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        calculationService.calculateAndSave(expression, user);
        return "redirect:/calculate";
    }
}
