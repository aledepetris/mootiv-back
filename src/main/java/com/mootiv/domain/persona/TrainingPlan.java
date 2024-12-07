package com.mootiv.domain.persona;

import com.mootiv.domain.TrainingType;
import com.mootiv.domain.cycle.TrainingCycle;
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

        trainingCycles.add(TrainingCycle.with(startDate, numberOfWeeks, numberOfDays, goal, trainingType));

    }
}
