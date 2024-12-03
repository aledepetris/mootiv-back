package com.mootiv.shared;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MuscleRequest {

    @NotBlank
    private String name;

    private List<Integer> idsExercises;

    private List<Integer> idsMuscles;

}
