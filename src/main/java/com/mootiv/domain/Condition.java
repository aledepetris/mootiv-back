package com.mootiv.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Affection affection;
    private LocalDate diagnosisDate;
    @Enumerated(EnumType.STRING)
    private ConditionSeverity severity;
    @Enumerated(EnumType.STRING)
    private ConditionStatus currentStatus;
    private String notes;

}
