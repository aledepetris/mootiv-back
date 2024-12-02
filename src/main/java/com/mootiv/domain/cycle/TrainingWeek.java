package com.mootiv.domain.cycle;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class TrainingWeek {

    private List<TrainingDay> days;
    private TrainingWeekStatus status;

}
