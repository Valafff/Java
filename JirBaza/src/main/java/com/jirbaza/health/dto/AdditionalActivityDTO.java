package com.jirbaza.health.dto;

import com.jirbaza.health.entities.UserPerDayAdditionalActivities;


public class AdditionalActivityDTO
{
    private Long id;
    private Long userPerDayActivityId;
    private String activityType;
    private String imagePath;
    private Double calorieConsumptionBy60kg30yearMalePerHour;
    private Double calorieConsumptionBy60kg30yearFemalePerHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserPerDayActivityId() {
        return userPerDayActivityId;
    }

    public void setUserPerDayActivityId(Long userPerDayActivityId) {
        this.userPerDayActivityId = userPerDayActivityId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Double getCalorieConsumptionBy60kg30yearMalePerHour() {
        return calorieConsumptionBy60kg30yearMalePerHour;
    }

    public void setCalorieConsumptionBy60kg30yearMalePerHour(Double calorieConsumptionBy60kg30yearMalePerHour) {
        this.calorieConsumptionBy60kg30yearMalePerHour = calorieConsumptionBy60kg30yearMalePerHour;
    }

    public Double getCalorieConsumptionBy60kg30yearFemalePerHour() {
        return calorieConsumptionBy60kg30yearFemalePerHour;
    }

    public void setCalorieConsumptionBy60kg30yearFemalePerHour(Double calorieConsumptionBy60kg30yearFemalePerHour) {
        this.calorieConsumptionBy60kg30yearFemalePerHour = calorieConsumptionBy60kg30yearFemalePerHour;
    }

    public AdditionalActivityDTO() {
    }

    public AdditionalActivityDTO(Long id, Long userPerDayActivityId, String activityType, String imagePath, Double calorieConsumptionBy60kg30yearMalePerHour, Double calorieConsumptionBy60kg30yearFemalePerHour) {
        this.id = id;
        this.userPerDayActivityId = userPerDayActivityId;
        this.activityType = activityType;
        this.imagePath = imagePath;
        this.calorieConsumptionBy60kg30yearMalePerHour = calorieConsumptionBy60kg30yearMalePerHour;
        this.calorieConsumptionBy60kg30yearFemalePerHour = calorieConsumptionBy60kg30yearFemalePerHour;
    }
}
