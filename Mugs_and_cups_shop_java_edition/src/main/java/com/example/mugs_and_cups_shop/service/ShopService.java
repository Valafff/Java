package com.example.mugs_and_cups_shop.service;

import com.example.mugs_and_cups_shop.entity.Category;
import com.example.mugs_and_cups_shop.entity.Good;
import com.example.mugs_and_cups_shop.repository.CategoryRepository;
import com.example.mugs_and_cups_shop.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final GoodRepository goodRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ShopService(GoodRepository goodRepository, CategoryRepository categoryRepository) {
        this.goodRepository = goodRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Good> getGoodsByCategoryId(Long categoryId) {
        if (categoryId == null || categoryId == 0) {
            return getAllGoods();
        }
        return goodRepository.findByCategoryId(categoryId);
    }
}
