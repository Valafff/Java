package com.example.mugs_and_cups_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "goods_t")
@Data
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title_f", nullable = false, length = 200)
    private String title;

    @Column(name = "description_f", nullable = false, length = 250)
    private String description;

    @Column(name = "price_f", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(mappedBy = "goods")
    private List<Order> orders;
}
