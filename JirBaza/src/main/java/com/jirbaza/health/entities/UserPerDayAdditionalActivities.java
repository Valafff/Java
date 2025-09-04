package com.jirbaza.health.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_per_day_additional_activities_t")
public class UserPerDayAdditionalActivities
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(name = "activity_time_minute_f")
    private Double activityTimeMinute;
    @Column(name = "note_f")
    private String note;

    //Связь с AdditionalActivity (список активностей)
    @OneToMany(mappedBy = "userPerDayActivity")
    @JsonManagedReference //Защита от циклического вызова (для родительской стороны)
    private Set<AdditionalActivity> activities = new HashSet<>();

    //Связь с ежедневником
    @ManyToOne()
    @JoinColumn(name = "user_diary_per_day_id")
    private UserDiaryPerDay userDiaryPerDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getActivityTimeMinute() {
        return activityTimeMinute;
    }

    public void setActivityTimeMinute(Double activityTimeMinute) {
        this.activityTimeMinute = activityTimeMinute;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<AdditionalActivity> getActivities() {
        return activities;
    }

    public void setActivities(Set<AdditionalActivity> activities) {
        this.activities = activities;
    }

    public UserDiaryPerDay getUserDiaryPerDay() {
        return userDiaryPerDay;
    }

    public void setUserDiaryPerDay(UserDiaryPerDay userDiaryPerDay) {
        this.userDiaryPerDay = userDiaryPerDay;
    }

    public UserPerDayAdditionalActivities() {
    }

    public UserPerDayAdditionalActivities(Long id, Double activityTimeMinute, String note, Set<AdditionalActivity> activities, UserDiaryPerDay userDiaryPerDay) {
        this.id = id;
        this.activityTimeMinute = activityTimeMinute;
        this.note = note;
        this.activities = activities;
        this.userDiaryPerDay = userDiaryPerDay;
    }
}

