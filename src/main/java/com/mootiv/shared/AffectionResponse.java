package com.mootiv.shared;

import com.mootiv.domain.Affection;
import com.mootiv.domain.Exercise;
import lombok.*;

import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AffectionResponse {

    private Integer id;
    private String name;
    private String description;
    private List<String> exercisesExcluded;

    public static AffectionResponse mapFrom(Affection affection) {
        return AffectionResponse.builder()
                .id(affection.getId())
                .name(affection.getName())
                .description(affection.getDescription())
                .exercisesExcluded(affection.getExercisesExcluded().stream()
                        .map(Exercise::getName)
                        .toList()
                )
                .build();
    }

}
