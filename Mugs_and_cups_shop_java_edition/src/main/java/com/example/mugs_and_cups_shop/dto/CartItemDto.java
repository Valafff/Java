package com.example.mugs_and_cups_shop.dto;

import com.example.mugs_and_cups_shop.entity.Good;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal price;

    public CartItemDto(Good good) {
        this.productId = good.getId();
        this.productName = good.getTitle();
        this.price = good.getPrice();
        this.quantity = 1;
    }
}
