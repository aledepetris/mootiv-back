package com.mootiv.shared;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.domain.muscle.MuscleGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter @Setter
public class MuscleResponse {

    private Integer id;

    @NotBlank
    private String name;

    private List<Exercise> exercises;

    private List<MuscleResponse> muscles;

    public static MuscleResponse mapFromMuscle(Muscle muscle) {
        var builder = MuscleResponse.builder()
                .id(muscle.getId())
                .name(muscle.getName())
                .exercises(muscle.getAssociatedExcercise());

        if (muscle.isAMuscleGroup()) {
            MuscleGroup group = (MuscleGroup) muscle;
            builder.muscles(group.getMuscles().stream()
                    .map(MuscleResponse::mapFromMuscle)
                    .toList());

        }

        return builder.build();

    }

}
