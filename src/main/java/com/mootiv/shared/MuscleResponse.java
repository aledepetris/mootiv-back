package com.mootiv.shared;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.domain.muscle.MuscleGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Getter @Setter
public class MuscleResponse {

    private Integer id;

    @NotBlank
    private String name;

    private Set<Exercise> exercises;

    private Set<MuscleResponse> muscles;

    public static MuscleResponse mapFromMuscle(Muscle muscle) {
        var builder = MuscleResponse.builder()
                .id(muscle.getId())
                .name(muscle.getName())
                .exercises(muscle.getAssociatedExcercise());

        if (muscle.isAMuscleGroup()) {
            MuscleGroup group = (MuscleGroup) muscle;
            builder.muscles(group.getMuscles().stream()
                    .map(MuscleResponse::mapFromMuscle)
                    .collect(Collectors.toSet()));

        }

        return builder.build();

    }

}
