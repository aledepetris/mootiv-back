package com.mootiv.shared;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ScheduleGoalRequest {

    @NotNull
    private Integer day;

    @NotEmpty
    private List<Integer> idsTrainingTypes;

}
