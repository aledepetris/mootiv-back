package com.mootiv.shared;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class ConditionRequest {

    @NotNull
    private Integer idAffection;
    @NotNull
    private LocalDate diagnosisDate;
    @NotBlank
    private String severity;
    @NotBlank
    private String currentStatus;
    private String notes;

}
