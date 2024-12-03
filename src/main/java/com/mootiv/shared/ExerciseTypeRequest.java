package com.mootiv.shared;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExerciseTypeRequest {

    @NotBlank
    private String name;

}
