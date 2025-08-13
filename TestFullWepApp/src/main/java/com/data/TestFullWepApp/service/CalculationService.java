package com.data.TestFullWepApp.service;

import com.data.TestFullWepApp.model.Calculation;
import com.data.TestFullWepApp.model.User;
import com.data.TestFullWepApp.repository.CalculationRepository;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для выполнения вычислений.
 * Предоставляет методы для вычисления выражений и получения истории операций.
 */
@Service
public class CalculationService {

    @Autowired
    private CalculationRepository calculationRepository;

    /**
     * Возвращает список всех вычислений для указанного пользователя.
     * @param userId Идентификатор пользователя.
     * @return Список вычислений.
     */
    public List<Calculation> getCalculationsForUser(Long userId) {
        return calculationRepository.findByUserId(userId);
    }

    /**
     * Вычисляет математическое выражение и сохраняет результат в базе данных.
     * @param expression Строка с математическим выражением.
     * @param user Пользователь, выполняющий вычисление.
     */
    public void calculateAndSave(String expression, User user) {
        try {
            // Используем библиотеку exp4j для вычисления выражения
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();

            // Создаем и сохраняем объект вычисления
            Calculation calculation = new Calculation();
            calculation.setExpression(expression);
            calculation.setResult(result);
            calculation.setUser(user);
            calculationRepository.save(calculation);
        } catch (Exception e) {
            // Обработка исключений, например, если выражение некорректно
            System.err.println("Error evaluating expression: " + expression);
        }
    }
}
