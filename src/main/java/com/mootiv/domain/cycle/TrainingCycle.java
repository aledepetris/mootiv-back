package com.mootiv.domain.cycle;

import com.mootiv.domain.Goal;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class TrainingCycle {

    private LocalDate startDate;
    private TrainingWeek weeks;
    private Goal goal;
    @Enumerated(EnumType.STRING)
    private CycleStatus status;
    private Integer daysOfTraining;

}
