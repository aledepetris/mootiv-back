package com.mootiv.domain.cycle;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class TrainingDay {

    private LocalDate completedOn;
    private List<ExerciseRoutine> exercises;

}
