package com.jirbaza.health.repository;

import com.jirbaza.health.entities.UserDiaryPerDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDiaryPerDayRepository extends JpaRepository<UserDiaryPerDay, String>
{

}
