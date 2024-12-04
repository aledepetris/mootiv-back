package com.mootiv.shared;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ScheduleGoalResponse {

    @NotNull
    private Integer day;

    @NotEmpty
    private List<String> trainingTypes;

}
