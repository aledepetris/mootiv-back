package com.mootiv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Affection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Set<Exercise> exercisesExcluded;

    public void update(String name, String description, Set<Exercise> excludedExercises) {
        this.name = name;
        this.description = description;
        this.exercisesExcluded = excludedExercises;
    }

    public static Affection with(String name, String description, Set<Exercise> exercisesExcluded) {
        var affection = new Affection();
        affection.setName(name);
        affection.setDescription(description);
        affection.setExercisesExcluded(exercisesExcluded);
        return affection;
    }

}
