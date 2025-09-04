package org.top.airportdirectoryapp.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.top.airportdirectoryapp.api.message.CommonApiMessages.StringMessage;

// StatusController - контроллер с обработчиками проверки статуса приложения
@RestController
@RequestMapping("api")
public class StatusController {

    @GetMapping
    public StringMessage status() {
        return new StringMessage("server is running");
    }

    @GetMapping("ping")
    public StringMessage ping() {
        return new StringMessage("pong");
    }
}
