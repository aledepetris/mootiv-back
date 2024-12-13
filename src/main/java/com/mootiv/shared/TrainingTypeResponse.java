package com.mootiv.shared;

import com.mootiv.domain.ExerciseType;
import com.mootiv.domain.TrainingType;
import lombok.*;

import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TrainingTypeResponse {

    private Integer id;
    private String name;
    private String description;
    private List<Integer> idsExerciseTypes;

    public static TrainingTypeResponse mapFrom(TrainingType trainingType) {
        return TrainingTypeResponse.builder()
                .id(trainingType.getId())
                .name(trainingType.getName())
                .description(trainingType.getDescription())
                .idsExerciseTypes(trainingType.getExerciseTypes().stream()
                        .map(ExerciseType::getId)
                        .toList()
                )
                .build();
    }

}
