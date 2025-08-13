package org.top.currencysaverwebapp.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.top.currencysaverwebapp.api.ApiMessages.*;

@RestController
@RequestMapping("api")
@Tag(name = "Статус", description = "Проверка состояния сервера")
public class StatusController {

    @GetMapping
    @Operation(summary = "Статус сервера", description = "Возвращает статус работы сервера")
    public StringMessage serverStatus() {
        return new StringMessage("server is running");
    }

    @GetMapping("ping")
    @Operation(summary = "Пинг-понг", description = "Возвращает 'pong' в ответ на 'ping'")
    public StringMessage ping() {
        return new StringMessage("pong");
    }
}
