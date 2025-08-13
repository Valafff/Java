package com.data.TestFullWepApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для главной страницы приложения.
 */
@Controller
public class IndexController {

    /**
     * Отображает главную страницу (index.html).
     * @return Название HTML-шаблона для главной страницы.
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
