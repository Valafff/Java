package com.example.mugs_and_cups_shop.controller;

import com.example.mugs_and_cups_shop.entity.Category;
import com.example.mugs_and_cups_shop.entity.Good;
import com.example.mugs_and_cups_shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/shop";
    }

    @GetMapping("/shop")
    public String shop(@RequestParam(name = "category_id", required = false) Long categoryId, Model model) {
        List<Good> goods = shopService.getGoodsByCategoryId(categoryId);
        List<Category> categories = shopService.getAllCategories();

        model.addAttribute("goods", goods);
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategoryId", categoryId);

        return "shop";
    }
}
