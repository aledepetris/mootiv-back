package com.mootiv.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Affection {

    private String name;
    private String description;
    private Set<Exercise> exercisesExcluded;

}
