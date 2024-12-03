package com.mootiv.shared;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ExerciseRequest {

    @NotBlank
    private String name;

    @NotNull
    private Boolean isForTime;

    @NotNull
    private Boolean isTotal;

    private List<Integer> idsMuscles;

    private List<Integer> idsExercisesType;

    private List<Integer> idsEquipments;

}
