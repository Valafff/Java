package com.thymeleafexample.thymeleafTutorial.controller;

import java.math.BigDecimal;

public record Product
        (
       String name,
       String category,
       Double price
) { }
