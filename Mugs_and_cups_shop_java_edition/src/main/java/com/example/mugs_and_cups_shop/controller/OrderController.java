package com.example.mugs_and_cups_shop.controller;

import com.example.mugs_and_cups_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public String createOrder(@RequestParam("contacts") String contacts) {
        orderService.createOrder(contacts);
        return "redirect:/order/success";
    }

    @GetMapping("/order/success")
    public String orderSuccess() {
        return "order-success";
    }
}
