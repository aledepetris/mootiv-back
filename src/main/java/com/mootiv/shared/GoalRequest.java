package com.mootiv.shared;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class GoalRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotEmpty
    private Set<ScheduleGoalRequest> goalTrainingTypes;

}
