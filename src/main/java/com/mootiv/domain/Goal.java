package com.mootiv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String descripcion;
    private Integer minDaysOfTraining;
    private Integer maxDaysOfTraining;
    @ManyToMany
    private Set<TrainingType> trainingTypes;

}
