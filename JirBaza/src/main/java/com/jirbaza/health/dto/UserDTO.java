package com.jirbaza.health.dto;

import java.sql.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {
    private Long id;
    private String nickName;
    private String password; // Осторожно: обычно пароль не возвращается в DTO
    private Date registrationDate;
    private String imagePath;
    private Integer age;
    private Double height;
    private String gender;
    private Double startWeight;
    private Double currentWeight;
    private Double targetWeight;
    private Set<Long> usersFoodIds; // Только ID связанных записей UsersFood
    private Set<Long> userDiaryPerDayIds; // Только ID связанных дневников

    public UserDTO() {
    }

    public UserDTO(Long id, String nickName, String password, Date registrationDate,
                   String imagePath, Integer age, Double height, String gender,
                   Double startWeight, Double currentWeight, Double targetWeight,
                   Set<Long> usersFoodIds, Set<Long> userDiaryPerDayIds) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.registrationDate = registrationDate;
        this.imagePath = imagePath;
        this.age = age;
        this.height = height;
        this.gender = gender;
        this.startWeight = startWeight;
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.usersFoodIds = usersFoodIds;
        this.userDiaryPerDayIds = userDiaryPerDayIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(Double startWeight) {
        this.startWeight = startWeight;
    }

    public Double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public Set<Long> getUsersFoodIds() {
        return usersFoodIds;
    }

    public void setUsersFoodIds(Set<Long> usersFoodIds) {
        this.usersFoodIds = usersFoodIds;
    }

    public Set<Long> getUserDiaryPerDayIds() {
        return userDiaryPerDayIds;
    }

    public void setUserDiaryPerDayIds(Set<Long> userDiaryPerDayIds) {
        this.userDiaryPerDayIds = userDiaryPerDayIds;
    }
}