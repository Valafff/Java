package com.jirbaza.health.repository;

import com.jirbaza.health.entities.AdditionalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdditionalActivityRepository   extends JpaRepository<AdditionalActivity, String>
{

}
