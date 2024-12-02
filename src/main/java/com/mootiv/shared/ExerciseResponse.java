package com.mootiv.shared;


import com.mootiv.domain.Equipment;
import com.mootiv.domain.Exercise;
import com.mootiv.domain.ExerciseType;
import com.mootiv.domain.muscle.Muscle;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Builder
@Getter @Setter
public class ExerciseResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private String name;

    private boolean isForTime;

    private boolean isTotal;

    private List<String> muscles;

    private List<String> exercisesType;

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Equipment> equipment;

    public static ExerciseResponse mapFrom(Exercise exercise) {
        return ExerciseResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .isForTime(exercise.isForTime())
                .isTotal(exercise.isTotal())
                .equipment(nonNull(exercise.getEquipments())
                        ? exercise.getEquipments()
                        : emptySet())
                .muscles(nonNull(exercise.getMuscles())
                        ? exercise.getMuscles().stream().map(Muscle::getName).toList()
                        : emptyList())
                .exercisesType(nonNull(exercise.getExercisesType())
                        ? exercise.getExercisesType().stream().map(ExerciseType::getName).toList()
                        : emptyList())
                .build();
    }

}
