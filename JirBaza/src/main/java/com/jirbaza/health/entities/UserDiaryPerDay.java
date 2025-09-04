package com.jirbaza.health.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_diary_per_day_t")
public class UserDiaryPerDay
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    //Связь с юзером-владельцем
    @ManyToOne
    @JoinColumn(name = "user_id_f", nullable = false)
    private User userOwner;

    //Связь со съеденной едой
    @OneToMany(mappedBy = "userDiaryPerDay")
    private Set<FoodEaten> foodEaten = new HashSet<>();

    //Связь с активностями юзера
    @OneToMany(mappedBy = "userDiaryPerDay")
    private Set<UserPerDayAdditionalActivities> userDiaryPerDayAdditionalActivities = new  HashSet<>();

    @Column(name = "date_f")
    private Date date;
    @Column(name = "calories_budget_per_day_f", nullable = false)
    private Double caloriesBudgetPerDay;
    @Column(name = "calories_received_per_day_f", nullable = false)
    private Double caloriesReceivedPerDay;
    @Column(name = "current_weight_start_f")
    private Double currentWeightStart;
    @Column(name = "calculated_weight_start_f", nullable = false)
    private Double calculatedWeightStart;
    @Column(name = "current_weight_end_f")
    private Double currentWeightEnd;
    @Column(name = "calculated_weight_end_f", nullable = false)
    private Double calculatedWeightEnd;
    @Column(name = "weight_delta_f", nullable = false)
    private Double weightDelta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public Set<FoodEaten> getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Set<FoodEaten> foodEaten) {
        this.foodEaten = foodEaten;
    }

    public Set<UserPerDayAdditionalActivities> getUserDiaryPerDayAdditionalActivities() {
        return userDiaryPerDayAdditionalActivities;
    }

    public void setUserDiaryPerDayAdditionalActivities(Set<UserPerDayAdditionalActivities> userDiaryPerDayAdditionalActivities) {
        this.userDiaryPerDayAdditionalActivities = userDiaryPerDayAdditionalActivities;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCaloriesBudgetPerDay() {
        return caloriesBudgetPerDay;
    }

    public void setCaloriesBudgetPerDay(Double caloriesBudgetPerDay) {
        this.caloriesBudgetPerDay = caloriesBudgetPerDay;
    }

    public Double getCaloriesReceivedPerDay() {
        return caloriesReceivedPerDay;
    }

    public void setCaloriesReceivedPerDay(Double caloriesReceivedPerDay) {
        this.caloriesReceivedPerDay = caloriesReceivedPerDay;
    }

    public Double getCurrentWeightStart() {
        return currentWeightStart;
    }

    public void setCurrentWeightStart(Double currentWeightStart) {
        this.currentWeightStart = currentWeightStart;
    }

    public Double getCalculatedWeightStart() {
        return calculatedWeightStart;
    }

    public void setCalculatedWeightStart(Double calculatedWeightStart) {
        this.calculatedWeightStart = calculatedWeightStart;
    }

    public Double getCurrentWeightEnd() {
        return currentWeightEnd;
    }

    public void setCurrentWeightEnd(Double currentWeightEnd) {
        this.currentWeightEnd = currentWeightEnd;
    }

    public Double getCalculatedWeightEnd() {
        return calculatedWeightEnd;
    }

    public void setCalculatedWeightEnd(Double calculatedWeightEnd) {
        this.calculatedWeightEnd = calculatedWeightEnd;
    }

    public Double getWeightDelta() {
        return weightDelta;
    }

    public void setWeightDelta(Double weightDelta) {
        this.weightDelta = weightDelta;
    }

    public UserDiaryPerDay() {
    }

    public UserDiaryPerDay(Long id, User userOwner, Set<FoodEaten> foodEaten, Set<UserPerDayAdditionalActivities> userDiaryPerDayAdditionalActivities, Date date, Double caloriesBudgetPerDay, Double caloriesReceivedPerDay, Double currentWeightStart, Double calculatedWeightStart, Double currentWeightEnd, Double calculatedWeightEnd, Double weightDelta) {
        this.id = id;
        this.userOwner = userOwner;
        this.foodEaten = foodEaten;
        this.userDiaryPerDayAdditionalActivities = userDiaryPerDayAdditionalActivities;
        this.date = date;
        this.caloriesBudgetPerDay = caloriesBudgetPerDay;
        this.caloriesReceivedPerDay = caloriesReceivedPerDay;
        this.currentWeightStart = currentWeightStart;
        this.calculatedWeightStart = calculatedWeightStart;
        this.currentWeightEnd = currentWeightEnd;
        this.calculatedWeightEnd = calculatedWeightEnd;
        this.weightDelta = weightDelta;
    }
}
