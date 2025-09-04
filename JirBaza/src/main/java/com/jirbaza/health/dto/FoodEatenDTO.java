package com.jirbaza.health.dto;

public class FoodEatenDTO {
    private Long id;
    private Double massNetto;
    private Double totalCalories;
    private Long foodId; // ID связанной еды вместо полного объекта
    private Long userDiaryPerDayId; // ID связанного дневника вместо полного объекта

    public FoodEatenDTO() {
    }

    public FoodEatenDTO(Long id, Double massNetto, Double totalCalories,
                        Long foodId, Long userDiaryPerDayId) {
        this.id = id;
        this.massNetto = massNetto;
        this.totalCalories = totalCalories;
        this.foodId = foodId;
        this.userDiaryPerDayId = userDiaryPerDayId;
    }

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

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Long getUserDiaryPerDayId() {
        return userDiaryPerDayId;
    }

    public void setUserDiaryPerDayId(Long userDiaryPerDayId) {
        this.userDiaryPerDayId = userDiaryPerDayId;
    }

    // Методы для преобразования
    public static FoodEatenDTO fromEntity(com.jirbaza.health.entities.FoodEaten entity) {
        if (entity == null) {
            return null;
        }

        FoodEatenDTO dto = new FoodEatenDTO();
        dto.setId(entity.getId());
        dto.setMassNetto(entity.getMassNetto());
        dto.setTotalCalories(entity.getTotalCalories());

        // Преобразование связей в ID
        if (entity.getFood() != null) {
            dto.setFoodId(entity.getFood().getId());
        }
        if (entity.getUserDiaryPerDay() != null) {
            dto.setUserDiaryPerDayId(entity.getUserDiaryPerDay().getId());
        }

        return dto;
    }

    public com.jirbaza.health.entities.FoodEaten toEntity() {
        com.jirbaza.health.entities.FoodEaten entity = new com.jirbaza.health.entities.FoodEaten();
        entity.setId(this.id);
        entity.setMassNetto(this.massNetto);
        entity.setTotalCalories(this.totalCalories);

        // Создание заглушек для связанных сущностей (только ID)
        if (this.foodId != null) {
            com.jirbaza.health.entities.Food food = new com.jirbaza.health.entities.Food();
            food.setId(this.foodId);
            entity.setFood(food);
        }

        if (this.userDiaryPerDayId != null) {
            com.jirbaza.health.entities.UserDiaryPerDay userDiaryPerDay = new com.jirbaza.health.entities.UserDiaryPerDay();
            userDiaryPerDay.setId(this.userDiaryPerDayId);
            entity.setUserDiaryPerDay(userDiaryPerDay);
        }

        return entity;
    }
}