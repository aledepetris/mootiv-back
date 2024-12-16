package com.mootiv.domain.templates;

import com.mootiv.domain.plan.ExerciseRoutine;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class TemplateExercises extends Template{

    @ManyToMany
    List<ExerciseRoutine> exercises;

}
