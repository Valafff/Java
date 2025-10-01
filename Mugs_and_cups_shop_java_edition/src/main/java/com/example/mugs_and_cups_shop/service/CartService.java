package com.example.mugs_and_cups_shop.service;

import com.example.mugs_and_cups_shop.dto.CartItemDto;
import com.example.mugs_and_cups_shop.entity.Good;
import com.example.mugs_and_cups_shop.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartService {

    private final Map<Long, CartItemDto> cart = new HashMap<>();

    @Autowired
    private GoodRepository goodRepository;

    public void addProduct(Long productId) {
        Good good = goodRepository.findById(productId).orElse(null);
        if (good != null) {
            if (cart.containsKey(productId)) {
                cart.get(productId).setQuantity(cart.get(productId).getQuantity() + 1);
            } else {
                cart.put(productId, new CartItemDto(good));
            }
        }
    }

    public void removeProduct(Long productId) {
        cart.remove(productId);
    }

    public Map<Long, CartItemDto> getCart() {
        return cart;
    }

    public BigDecimal getTotal() {
        return cart.values().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
