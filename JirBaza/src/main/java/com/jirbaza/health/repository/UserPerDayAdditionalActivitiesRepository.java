package com.jirbaza.health.repository;

import com.jirbaza.health.entities.UserPerDayAdditionalActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPerDayAdditionalActivitiesRepository extends JpaRepository<UserPerDayAdditionalActivities, String>
{

}
