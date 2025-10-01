package com.example.mugs_and_cups_shop.service;

import com.example.mugs_and_cups_shop.dto.CartItemDto;
import com.example.mugs_and_cups_shop.entity.Good;
import com.example.mugs_and_cups_shop.entity.Order;
import com.example.mugs_and_cups_shop.repository.GoodRepository;
import com.example.mugs_and_cups_shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final GoodRepository goodRepository;
    private final CartService cartService;

    @Autowired
    public OrderService(OrderRepository orderRepository, GoodRepository goodRepository, CartService cartService) {
        this.orderRepository = orderRepository;
        this.goodRepository = goodRepository;
        this.cartService = cartService;
    }

    public void createOrder(String clientContacts) {
        Order order = new Order();
        order.setClientContacts(clientContacts);

        Map<Long, CartItemDto> cart = cartService.getCart();
        List<Good> goods = goodRepository.findAllById(cart.keySet());
        order.setGoods(goods);

        orderRepository.save(order);
        cart.clear();
    }
}
