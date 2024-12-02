package com.mootiv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Condition {

    private Affection affection;
    private LocalDate diagnosisDate;
    @Enumerated(EnumType.STRING)
    private ConditionSeverity severity;
    @Enumerated(EnumType.STRING)
    private ConditionStatus currentStatus;
    private String notes;

}
