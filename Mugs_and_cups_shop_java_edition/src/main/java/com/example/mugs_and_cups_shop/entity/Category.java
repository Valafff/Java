package com.example.mugs_and_cups_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category_t")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description_f", nullable = false, length = 20)
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Good> goods;
}
