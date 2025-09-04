package com.jirbaza.health.api;

import com.jirbaza.health.entities.AdditionalActivity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jirbaza.health.repository.AdditionalActivityRepository;

import java.util.List;

@RestController
@RequestMapping("activity")
public class AdditionalActivityController
{
    private final AdditionalActivityRepository aaRepository;

    public AdditionalActivityController(AdditionalActivityRepository aaRepository) {
        this.aaRepository = aaRepository;
    }

    @GetMapping("all")
    public List<AdditionalActivity> getactivities()
    {
        return aaRepository.findAll();
    }

}
