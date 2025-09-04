package com.jirbaza.health.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "additional_activity_t")
public class AdditionalActivity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //Связь с UserPerDayAdditionalActivities
    @ManyToOne()
    @JoinColumn(name = "user_per_day_additional_activity_id_f")
    @JsonBackReference //Защита от циклического вызова (для дочерней стороны)
    private UserPerDayAdditionalActivities userPerDayActivity;

    @Column(name = "activity_type_f", nullable = false)
    private String activityType;
    @Column(name = "image_path_f")
    private String imagePath;
    @Column(name = "calorie_consumption_male_f", nullable = false)
    private Double calorieConsumptionBy60kg30yearMalePerHour;
    @Column(name = "calorie_consumption_female_f", nullable = false)
    private Double calorieConsumptionBy60kg30yearFemalePerHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserPerDayAdditionalActivities getUserPerDayActivity() {
        return userPerDayActivity;
    }

    public void setUserPerDayActivity(UserPerDayAdditionalActivities userPerDayActivity) {
        this.userPerDayActivity = userPerDayActivity;
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

    public AdditionalActivity() {
    }

    public AdditionalActivity(Long id, UserPerDayAdditionalActivities userActivity, String activityType, String imagePath, Double calorieConsumptionBy60kg30yearMale, Double calorieConsumptionBy60kg30yearFemale) {
        this.id = id;
        this.userPerDayActivity = userActivity;
        this.activityType = activityType;
        this.imagePath = imagePath;
        this.calorieConsumptionBy60kg30yearMalePerHour = calorieConsumptionBy60kg30yearMale;
        this.calorieConsumptionBy60kg30yearFemalePerHour = calorieConsumptionBy60kg30yearFemale;
    }
}
