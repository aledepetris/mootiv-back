package com.mootiv.shared;

import com.mootiv.domain.goal.ScheduleGoal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GoalRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotEmpty
    private List<ScheduleGoalDto> goalTrainingTypes;

    @Getter @Setter
    static class ScheduleGoalDto {

        @NotNull
        private Integer day;
        @NotNull
        private Integer idTrainingType;

    }

}
