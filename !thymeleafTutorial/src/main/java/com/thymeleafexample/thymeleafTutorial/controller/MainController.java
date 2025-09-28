package com.thymeleafexample.thymeleafTutorial.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class MainController
{
    @GetMapping("/simple-text")
    public String simpleText(Model model)
    {

        model.addAttribute("text", "Hello World");
        double value = Math.E;
        model.addAttribute("E", value);
        return "page_one";
    }

    @GetMapping("/say-hello")
    public String sayHello(@RequestParam String name, @RequestParam String secondName, Model model)
    {
        model.addAttribute("name", name);
        model.addAttribute("secondName", secondName);
        return "page_two";
    }

    @GetMapping ("/html-block")
    public  String htmlBlock(Model model)
    {
        String htmlList = """
                <ul>
                <li>World</li>
                <li>Wide</li>
                <li>Web</li>
                </ul>
                """;
        model.addAttribute("block", htmlList);
        return  "page_three";
    }

    final String password = "123";

    @GetMapping("/check-pass")
    public  String checkPassword(Model model)
    {
        model.addAttribute("isGiven", false);
        return "page_four";
    }
    @PostMapping("/check-pass")
    public  String checkPassword(@RequestParam String password, Model model)
    {
        boolean result = false;
        if (this.password.equals(password))
        {
            result = true;
        }
        model.addAttribute("isCorrect", result);
        model.addAttribute("isGiven", true);
        return "page_four";
    }

    @GetMapping("/products")
    public String findAllProducts(Model model)
    {
        List<Product> products = List.of(
        new Product("Computer", "Technical", 500.99),
        new Product("Car", "Auto", 100500.99),
        new Product("House", "Commerce", 500500.99)
        );
        model.addAttribute("products", products);
        return "page_five";
    }

    @GetMapping("/attributes")
    public String changeImage(Model model)
    {
        model.addAttribute("isGiven", false);
        model.addAttribute("imageId", "");
        return "page_six";
    }

    @PostMapping("/attributes")
    public String changeImage(@RequestParam Integer check,  Model model)
    {
        model.addAttribute("imageId", "/images/" + String.valueOf(check) + ".jpg");
        model.addAttribute("isGiven", true);
        return "page_six";
    }

}
