package com.jirbaza.health.dto;

import java.util.Set;
import java.util.stream.Collectors;

public class FoodDTO {
    private Long id;
    private String title;
    private String imagePath;
    private Double calorieBy100gr;
    private Double glycemicIndex;
    private Set<Long> usersFoodIds; // Только ID связанных сущностей

    public FoodDTO() {
    }

    public FoodDTO(Long id, String title, String imagePath, Double calorieBy100gr,
                   Double glycemicIndex, Set<Long> usersFoodIds) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.calorieBy100gr = calorieBy100gr;
        this.glycemicIndex = glycemicIndex;
        this.usersFoodIds = usersFoodIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Double getCalorieBy100gr() {
        return calorieBy100gr;
    }

    public void setCalorieBy100gr(Double calorieBy100gr) {
        this.calorieBy100gr = calorieBy100gr;
    }

    public Double getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setGlycemicIndex(Double glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public Set<Long> getUsersFoodIds() {
        return usersFoodIds;
    }

    public void setUsersFoodIds(Set<Long> usersFoodIds) {
        this.usersFoodIds = usersFoodIds;
    }
}