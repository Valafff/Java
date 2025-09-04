package com.jirbaza.health.entities;

import jakarta.persistence.*;

@Entity
public class FoodEaten
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(name = "mass_netto_f")
    private Double massNetto;
    @Column(name = "total_calories_f", nullable = false)
    private Double totalCalories;

    //Связь с едой - один к одному
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

    //Связь с ежедневником
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_diary_per_day_id", nullable = false)
    private UserDiaryPerDay userDiaryPerDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMassNetto() {
        return massNetto;
    }

    public void setMassNetto(Double massNetto) {
        this.massNetto = massNetto;
    }

    public Double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public UserDiaryPerDay getUserDiaryPerDay() {
        return userDiaryPerDay;
    }

    public void setUserDiaryPerDay(UserDiaryPerDay userDiaryPerDay) {
        this.userDiaryPerDay = userDiaryPerDay;
    }

    public FoodEaten() {
    }

    public FoodEaten(Long id, Double massNetto, Double totalCalories, Food food, UserDiaryPerDay userDiaryPerDay) {
        this.id = id;
        this.massNetto = massNetto;
        this.totalCalories = totalCalories;
        this.food = food;
        this.userDiaryPerDay = userDiaryPerDay;
    }
}
