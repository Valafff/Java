package com.example.mugs_and_cups_shop.controller;

import com.example.mugs_and_cups_shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        model.addAttribute("total", cartService.getTotal());
        return "cart";
    }

    @PostMapping("/cart")
    public String addToCart(@RequestParam("id") Long productId) {
        cartService.addProduct(productId);
        return "redirect:/shop";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam("id") Long productId) {
        cartService.removeProduct(productId);
        return "redirect:/cart";
    }
}
