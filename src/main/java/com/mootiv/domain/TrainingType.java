package com.mootiv.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class TrainingType {

    private String name;
    private String description;
    private Set<ExerciseType> exerciseTypes;

}
