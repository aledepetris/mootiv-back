package com.mootiv.shared;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.domain.muscle.MuscleGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.nonNull;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
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

    public static MuscleResponse mapFromMuscleHierarchy(Muscle muscle, Set<Integer> processedIds) {
        // Evitar procesar el mismo músculo más de una vez
        if (processedIds.contains(muscle.getId())) {
            return null;
        }
        processedIds.add(muscle.getId());

        // Construir el DTO básico
        var builder = MuscleResponse.builder()
                .id(muscle.getId())
                .name(muscle.getName())
                .exercises(nonNull(muscle.getAssociatedExcercise())
                        ? muscle.getAssociatedExcercise().stream()
                        .map(Exercise::getName)
                        .toList()
                        : emptyList());

        // Si es un grupo de músculos, procesar recursivamente sus hijos
        if (muscle.isAMuscleGroup()) {
            MuscleGroup group = (MuscleGroup) muscle;
            builder.muscles(nonNull(group.getMuscles())
                    ? group.getMuscles().stream()
                    .map(child -> mapFromMuscleHierarchy(child, processedIds))
                    .filter(Objects::nonNull) // Eliminar nodos ya procesados
                    .collect(Collectors.toSet())
                    : emptySet());
        }

        return builder.build();
    }


}
