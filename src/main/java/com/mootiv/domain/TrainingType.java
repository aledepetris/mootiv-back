package com.mootiv.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class TrainingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToMany
    private Set<ExerciseType> exerciseTypes;

    public void update(String name, String description, Set<ExerciseType> exerciseTypes) {
        this.name = name;
        this.description = description;
        this.exerciseTypes = exerciseTypes;
    }

    public static TrainingType with(String name, String description, Set<ExerciseType> exerciseTypes) {
        var trainingType = new TrainingType();
        trainingType.setName(name);
        trainingType.setDescription(description);
        trainingType.setExerciseTypes(exerciseTypes);
        return trainingType;
    }
}
