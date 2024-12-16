package com.mootiv.domain.templates;

import com.mootiv.domain.plan.ExerciseRoutine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class TemplateExercises extends Template{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String description;
    private LocalDate creationDate;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ExerciseRoutine> exercises;

}
