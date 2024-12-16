package com.mootiv.shared;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class TrainingCycleRequest {

    @NotNull
    private LocalDate startDate;

    @NotNull
    private Integer numberOfWeeks;

    @NotNull
    private Integer numberOfDays;

    @NotNull
    private Integer idTrainingType;

    @NotNull
    private Integer idGoal;

    private String status;

}
