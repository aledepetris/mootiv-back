package com.mootiv.repository;

import com.mootiv.domain.templates.TemplateExercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateExerciseRepository extends JpaRepository<TemplateExercises, Integer> {

}
