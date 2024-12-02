package com.mootiv.domain.cycle;

import com.mootiv.domain.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ExerciseRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Exercise exercise;
    private Integer sets;
    private Integer repetitions;
    private Float weight;
    private Integer rest;
    private String notes;

}
