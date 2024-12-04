package com.mootiv.shared;

import com.mootiv.domain.TrainingType;
import com.mootiv.domain.goal.Goal;
import lombok.*;

import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class GoalResponse {

    private Integer id;
    private String name;
    private String description;
    private List<ScheduleGoalResponse> scheduleGoals;

    public static GoalResponse mapFrom(Goal goal) {
        return GoalResponse.builder()
                .id(goal.getId())
                .name(goal.getName())
                .description(goal.getDescription())
                .scheduleGoals(
                        goal.getScheduleGoals().stream()
                                .map(scheduleGoal -> ScheduleGoalResponse.builder()
                                        .day(scheduleGoal.getDayOfTraining())
                                        .trainingTypes(scheduleGoal.getTrainingTypes().stream()
                                                .map(TrainingType::getName).toList())
                                        .build())
                                .toList()
                ).build();
    }

}
