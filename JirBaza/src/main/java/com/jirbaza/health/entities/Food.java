package com.jirbaza.health.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food_t")
public class Food
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    //Связь через промежуточную таблицу user_food_t
    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsersFood> usersFood = new HashSet<>();

    @Column(name = "title_f", nullable = false, unique = true)
    private String title;
    @Column(name = "image_path_f", nullable = true, unique = false)
    private String imagePath;
    @Column(name = "calorie_by_100gr_f", nullable = false, unique = false)
    private Double calorieBy100gr;
    @Column(name = "glycemic_index_f", nullable = true, unique = false)
    private Double glycemicIndex;



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

    public Food() {
    }

    public Food(Long id, Set<UsersFood> usersFood, String title, String imagePath, Double calorieBy100gr, Double glycemicIndex) {
        this.id = id;
        this.usersFood = usersFood;
        this.title = title;
        this.imagePath = imagePath;
        this.calorieBy100gr = calorieBy100gr;
        this.glycemicIndex = glycemicIndex;
    }

    public Set<UsersFood> getUsersFood() {
        return usersFood;
    }

    public void setUsersFood(Set<UsersFood> usersFood) {
        this.usersFood = usersFood;
    }
}
