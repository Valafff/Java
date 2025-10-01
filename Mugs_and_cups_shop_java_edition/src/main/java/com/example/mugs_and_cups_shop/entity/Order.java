package com.example.mugs_and_cups_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "order_t")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_contacts_t", nullable = false, length = 250)
    private String clientContacts;

    @ManyToMany
    @JoinTable(
            name = "goods_order_t",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id")
    )
    private List<Good> goods;
}
