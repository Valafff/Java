package com.apimvcexample.HW17_ApiMvcPractice.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class IndexController
{
    @GetMapping("/")
    public String index()
    {
        return "index";
    }

//    //Эндпоинт на конвертер, если разместит в другом контроллере тоже будет работать
//    @GetMapping("converter")
//    public String converter()
//    {
//        return "converter";
//    }
}
