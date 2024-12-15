package com.mootiv.domain;

import com.mootiv.domain.muscle.Muscle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;
    private String alt_img;
    private boolean isForTime;

    private boolean isTotal;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "exercise_muscle",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id")
    )
    Set<Muscle> muscles;

    @ManyToMany(fetch = FetchType.LAZY)
    Set<ExerciseType> exercisesType;

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Equipment> equipments;


    public static Exercise with(String name, String altImg, String description, boolean isForTime, boolean isTotal,
                                Set<Muscle> muscles, Set<ExerciseType> exercisesType, Set<Equipment> equipments) {

        Exercise exercise = new Exercise();
        exercise.setName(name);
        exercise.setAlt_img(altImg);
        exercise.setDescription(description);
        exercise.setExercisesType(exercisesType);
        exercise.setMuscles(muscles);
        exercise.setEquipments(equipments);
        exercise.setForTime(isForTime);
        exercise.setTotal(isTotal);

        return exercise;

    }

    public void update(@NotBlank String name, String altImg, String description, @NotNull Boolean isTotal, @NotNull Boolean isForTime,
                       Set<Muscle> muscles, Set<ExerciseType> exerciseTypes, Set<Equipment> equipments) {
        this.name = name;
        this.alt_img = altImg;
        this.description = description;
        this.isTotal = isTotal;
        this.isForTime = isForTime;
        this.muscles = muscles;
        this.exercisesType = exerciseTypes;
        this.equipments = equipments;
    }
}


