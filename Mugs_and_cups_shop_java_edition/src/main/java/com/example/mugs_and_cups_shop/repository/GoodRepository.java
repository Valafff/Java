package com.example.mugs_and_cups_shop.repository;

import com.example.mugs_and_cups_shop.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodRepository extends JpaRepository<Good, Long> {
    List<Good> findByCategoryId(Long categoryId);
}
