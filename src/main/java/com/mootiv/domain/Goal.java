package com.mootiv.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Goal {

    private String name;
    private String descripcion;
    private Integer minDaysOfTraining;
    private Integer maxDaysOfTraining;
    private Set<TrainingType> trainingTypes;

}
