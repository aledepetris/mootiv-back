package com.mootiv.shared;

import com.mootiv.domain.Exercise;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ExerciseTemplateDto {

    private Integer id;
    private Exercise exercise;
    private Integer sets;
    private Integer repetitions;
    private Float weight;
    private Integer rest;
    private String notes;

}
