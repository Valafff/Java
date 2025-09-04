package org.top.springwithdbexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.top.springwithdbexample.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserId(Integer userId);

        @Transactional
        @Modifying
        @Query("  UPDATE User u SET u.discountPoints = COALESCE(u.discountPoints, 0) + 10 WHERE u.id = :userId")
        void addDiscountPoints(@Param("userId") Long userId);
}
