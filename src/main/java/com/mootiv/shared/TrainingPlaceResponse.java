package com.mootiv.shared;


import com.mootiv.domain.Equipment;
import com.mootiv.domain.Exercise;
import com.mootiv.domain.ExerciseType;
import com.mootiv.domain.TrainingPlace;
import com.mootiv.domain.muscle.Muscle;
import jakarta.persistence.*;
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
public class TrainingPlaceResponse {

    private Integer id;

    private String name;

    Set<Equipment> equipment;

    public static TrainingPlaceResponse mapFrom(TrainingPlace trainingPlace) {
        return TrainingPlaceResponse.builder()
                .id(trainingPlace.getId())
                .name(trainingPlace.getName())
                .equipment(nonNull(trainingPlace.getEquipments())
                        ? trainingPlace.getEquipments()
                        : emptySet())
                .build();
    }

}
