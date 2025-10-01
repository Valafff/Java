package com.example.mugs_and_cups_shop.repository;

import com.example.mugs_and_cups_shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
