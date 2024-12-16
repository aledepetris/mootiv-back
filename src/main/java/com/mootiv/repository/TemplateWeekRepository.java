package com.mootiv.repository;

import com.mootiv.domain.templates.TemplateExercises;
import com.mootiv.domain.templates.TemplateWeek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateWeekRepository extends JpaRepository<TemplateWeek, Integer> {
    
}
