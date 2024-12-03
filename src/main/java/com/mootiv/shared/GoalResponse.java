package com.mootiv.shared;

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
    private List<String> exercisesExcluded;

    // TODO take when is finished TrainingType CRUD
    public static GoalResponse mapFrom(Goal goal) {
        return GoalResponse.builder()
                .id(goal.getId())
                .name(goal.getName())
                .build();
    }

}
