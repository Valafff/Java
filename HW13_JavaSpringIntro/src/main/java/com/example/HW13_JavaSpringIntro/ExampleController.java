package com.example.HW13_JavaSpringIntro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController
{
    @GetMapping
    public String serverStatus()
    {
        return  "server is running";
    }

    @GetMapping("ping")
    public String ping()
    {
        return  "pong";
    }
}
