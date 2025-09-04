package com.jirbaza.health.entities;

import jakarta.persistence.*;

//Расшивочная таблица
@Entity
@Table(name = "user_food_t", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id_f", "food_id_f"}))
public class UsersFood
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_f", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id_f", nullable = false)
    private Food food;

    public UsersFood() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
