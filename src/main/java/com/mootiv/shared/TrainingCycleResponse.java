package com.mootiv.shared;

import com.mootiv.domain.plan.TrainingCycle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter @Setter
public class TrainingCycleResponse {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numberOfWeeks;
    private Integer numberOfDays;
    private String status;
    private Integer idGoal;
    private Integer idTrainingType;

    public static TrainingCycleResponse mapFrom(TrainingCycle trainingCycle) {
        return TrainingCycleResponse.builder()
                .id(trainingCycle.getId())
                .startDate(trainingCycle.getStartDate())
                .endDate(trainingCycle.endDate())
                .numberOfWeeks(trainingCycle.getNumberOfWeeks())
                .numberOfDays(trainingCycle.getDaysOfTraining())
                .status(trainingCycle.getStatus().name())
                .idGoal(trainingCycle.getGoal().getId())
                .idTrainingType(trainingCycle.getTrainingType().getId())
                .build();
    }

}
