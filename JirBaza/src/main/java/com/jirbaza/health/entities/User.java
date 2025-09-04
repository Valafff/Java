package com.jirbaza.health.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_t")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    //Связь чрез промежуточную таблицу UsersFood (Любимая еда) - много ко многим через расшивочную таблицу
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsersFood> usersFood = new HashSet<>();
    //Связь с ежедневником
    @OneToMany(mappedBy = "userOwner")
    private  Set<UserDiaryPerDay> userDiaryPerDays = new HashSet<>();

    @Column(name = "nickname_f", nullable = false, unique = true)
    private String nickName;
    @Column(name = "password_f", nullable = false)
    private String password;
    @Column(name = "registration_date_f", nullable = false)
    private Date registrationDate;
    @Column(name = "image_path_f")
    private String imagePath;
    @Column(name = "age_f", nullable = false)
    private Integer age;
    @Column(name = "height_f", nullable = false)
    private Double height;
    @Column(name = "gender_f", nullable = false)
    private String gender;
    @Column(name = "start_weight", nullable = false)
    private Double startWeight;
    @Column(name = "current_weight", nullable = false)
    private Double currentWeight;
    @Column(name = "target_weight", nullable = false)
    private Double targetWeight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<UsersFood> getUsersFood() {
        return usersFood;
    }

    public void setUsersFood(Set<UsersFood> usersFood) {
        this.usersFood = usersFood;
    }

    public Set<UserDiaryPerDay> getUserDiaryPerDays() {
        return userDiaryPerDays;
    }

    public void setUserDiaryPerDays(Set<UserDiaryPerDay> userDiaryPerDays) {
        this.userDiaryPerDays = userDiaryPerDays;
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

    public User() {
    }

    public User(Long id, Set<UsersFood> usersFood, Set<UserDiaryPerDay> userDiaryPerDays, String nickName, String password, Date registrationDate, String imagePath, Integer age, Double height, String gender, Double startWeight, Double currentWeight, Double targetWeight) {
        this.id = id;
        this.usersFood = usersFood;
        this.userDiaryPerDays = userDiaryPerDays;
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
    }
}
