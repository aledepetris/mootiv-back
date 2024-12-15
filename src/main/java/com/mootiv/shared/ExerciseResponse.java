package com.mootiv.shared;


import com.mootiv.domain.Equipment;
import com.mootiv.domain.Exercise;
import com.mootiv.domain.ExerciseType;
import com.mootiv.domain.muscle.Muscle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.nonNull;

@Builder
@Getter @Setter
public class ExerciseResponse {

    private Integer id;

    private String name;

    private String description;

    private String alt_img;

    private boolean isForTime;

    private boolean isTotal;

    private List<Integer> idsMuscles;

    private List<Integer> idsExercisesType;

    private List<Integer> idsEquipments;

    public static ExerciseResponse mapFrom(Exercise exercise) {
        return ExerciseResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .description(exercise.getDescription())
                .isForTime(exercise.isForTime())
                .isTotal(exercise.isTotal())
                .alt_img(exercise.getAlt_img())
                .idsEquipments(nonNull(exercise.getEquipments())
                        ? exercise.getEquipments().stream().map(Equipment::getId).toList()
                        : emptyList())
                .idsMuscles(nonNull(exercise.getMuscles())
                        ? exercise.getMuscles().stream().map(Muscle::getId).toList()
                        : emptyList())
                .idsExercisesType(nonNull(exercise.getExercisesType())
                        ? exercise.getExercisesType().stream().map(ExerciseType::getId).toList()
                        : emptyList())
                .build();
    }

}
