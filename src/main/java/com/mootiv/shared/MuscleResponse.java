package com.mootiv.shared;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.domain.muscle.MuscleGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.nonNull;

@Builder
@Getter @Setter
public class MuscleResponse {

    private Integer id;

    @NotBlank
    private String name;

    private List<String> exercises;

    private Set<MuscleResponse> muscles;

    public static MuscleResponse mapFromMuscle(Muscle muscle) {
        var builder = MuscleResponse.builder()
                .id(muscle.getId())
                .name(muscle.getName())
                .exercises(nonNull(muscle.getAssociatedExcercise())
                        ? muscle.getAssociatedExcercise().stream()
                            .map(Exercise::getName)
                            .toList()
                        : emptyList());


        if (muscle.isAMuscleGroup()) {
            MuscleGroup group = (MuscleGroup) muscle;
            builder.muscles(nonNull(group)
                    ? group.getMuscles().stream()
                        .map(MuscleResponse::mapFromMuscle)
                        .collect(Collectors.toSet())
                    : emptySet());
        }

        return builder.build();

    }

}
