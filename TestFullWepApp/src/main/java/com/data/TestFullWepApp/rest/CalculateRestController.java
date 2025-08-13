package com.data.TestFullWepApp.rest;

import com.data.TestFullWepApp.dto.CalculationRequest;
import com.data.TestFullWepApp.model.Calculation;
import com.data.TestFullWepApp.model.User;
import com.data.TestFullWepApp.service.CalculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-контроллер для выполнения вычислений.
 * Предоставляет API для вычисления выражений и получения истории.
 */
@RestController
@RequestMapping("/api/v1/calculate")
@Tag(name = "Calculation API", description = "API для выполнения вычислений")
public class CalculateRestController {

    @Autowired
    private CalculationService calculationService;

    /**
     * API для выполнения вычисления.
     * @param request DTO с математическим выражением.
     * @param session HTTP-сессия для идентификации пользователя.
     * @return Ответ с сообщением об успехе или ошибке.
     */
    @PostMapping
    @Operation(summary = "Выполнить вычисление")
    public ResponseEntity<String> calculate(@RequestBody CalculationRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Пользователь не авторизован");
        }
        calculationService.calculateAndSave(request.getExpression(), user);
        return ResponseEntity.ok("Вычисление выполнено и сохранено");
    }

    /**
     * API для получения истории вычислений пользователя.
     * @param session HTTP-сессия для идентификации пользователя.
     * @return Список вычислений или ответ с ошибкой.
     */
    @GetMapping("/history")
    @Operation(summary = "Получить историю вычислений")
    public ResponseEntity<List<Calculation>> getHistory(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Calculation> history = calculationService.getCalculationsForUser(user.getId());
        return ResponseEntity.ok(history);
    }
}
