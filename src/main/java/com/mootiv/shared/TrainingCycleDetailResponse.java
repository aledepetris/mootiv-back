package com.mootiv.shared;

import com.mootiv.domain.plan.TrainingCycle;
import com.mootiv.domain.plan.TrainingWeek;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter @Setter
public class TrainingCycleDetailResponse {

    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numberOfWeeks;
    private Integer numberOfDays;
    private String status;
    private Integer idGoal;
    private Integer idTrainingType;
    private List<TrainingWeek> trainingWeeks;


    public static TrainingCycleDetailResponse mapFrom(TrainingCycle trainingCycle) {
        return TrainingCycleDetailResponse.builder()
                .id(trainingCycle.getId())
                .startDate(trainingCycle.getStartDate())
                .endDate(trainingCycle.endDate())
                .numberOfWeeks(trainingCycle.getNumberOfWeeks())
                .numberOfDays(trainingCycle.getDaysOfTraining())
                .status(trainingCycle.getStatus().name())
                .idGoal(trainingCycle.getGoal().getId())
                .idTrainingType(trainingCycle.getTrainingType().getId())
                .trainingWeeks(trainingCycle.getWeeks())
                .build();
    }

}
