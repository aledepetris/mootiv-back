package com.mootiv.domain.plan;

import com.mootiv.domain.TrainingType;
import com.mootiv.domain.goal.Goal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TrainingPlan {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private List<TrainingCycle> trainingCycles;

    public void createNewCycle(LocalDate startDate, Integer numberOfWeeks, Integer numberOfDays, Goal goal, TrainingType trainingType) {

        if (isNull(trainingCycles)) {
            trainingCycles = new ArrayList<>();
        }

        // Validar que la fecha de inicio no esté en el pasado
        if (startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("El inicio del ciclo no puede ser una fecha pasada.");
        }

        // Validar que no haya superposición de fechas con otros ciclos vigentes
        boolean hasOverlap = trainingCycles.stream()
                .filter(cycle -> !cycle.isCanceled())
                .anyMatch(cycle -> cycle.overlapsWith(startDate, numberOfWeeks));

        if (hasOverlap) {
            throw new IllegalStateException("El nuevo ciclo se superpone con otro ciclo vigente.");
        }

        trainingCycles.add(TrainingCycle.with(startDate, numberOfWeeks, numberOfDays, goal, trainingType));

    }
}
