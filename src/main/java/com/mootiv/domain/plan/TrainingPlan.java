package com.mootiv.domain.plan;

import com.mootiv.domain.TrainingType;
import com.mootiv.domain.goal.Goal;
import com.mootiv.error.exception.NotFoundException;
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

import static com.mootiv.error.ApiMootivErrors.CONDITION_NOT_FOUND;
import static java.util.Objects.isNull;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TrainingPlan {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "student_id")
    private List<TrainingCycle> trainingCycles;

    public void createNewCycle(LocalDate startDate, Integer numberOfWeeks, Integer numberOfDays,
                               Goal goal, TrainingType trainingType) {

        if (isNull(trainingCycles)) {
            trainingCycles = new ArrayList<>();
        }

        if (startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("El inicio del ciclo no puede ser una fecha pasada.");
        }

        boolean hasOverlap = trainingCycles.stream()
                .filter(cycle -> !cycle.isCanceled())
                .anyMatch(cycle -> cycle.overlapsWith(startDate, numberOfWeeks));

        if (hasOverlap) {
            throw new IllegalStateException("El nuevo ciclo se superpone con otro ciclo vigente.");
        }

        trainingCycles.add(TrainingCycle.with(startDate, numberOfWeeks, numberOfDays, goal, trainingType));

    }

    public void deleteCycleById(Integer idCycle) {
        var cycle = this.trainingCycles.stream().filter(x -> x.getId().equals(idCycle)).findFirst()
                .orElseThrow(NotFoundException.of(CONDITION_NOT_FOUND));

        if (cycle.canBeDeleted()) {
            this.trainingCycles.remove(cycle);
        } else {
            throw new RuntimeException("No es posible borrar el ciclo en el estado actual");
        }

    }

    public TrainingCycle getCycleById(Integer idCycle) {
        return this.trainingCycles.stream().filter(x -> x.getId().equals(idCycle)).findFirst()
                .orElseThrow(NotFoundException.of(CONDITION_NOT_FOUND));

    }


}
