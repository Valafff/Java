package com.example.Lesson16_Practice_MVC.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class StatusController {

    @GetMapping
    public ApiMessages.StringMessage serverStatus() {
        return new ApiMessages.StringMessage("server is running");
    }

    @GetMapping("ping")
    public ApiMessages.StringMessage ping() {
        return new ApiMessages.StringMessage("pong");
    }
}