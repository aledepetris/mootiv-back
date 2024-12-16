package com.mootiv.shared;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.plan.ExerciseRoutine;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExerciseRoutineRequest {

    private Integer id;
    private Integer idExercise;
    private Integer sets;
    private Integer repetitions;
    private Float weight;
    private Integer rest;
    private String notes;

    public ExerciseRoutine toEntity(Exercise ex) {
        var entity = new ExerciseRoutine();
        entity.setSets(this.getSets());
        entity.setRest(this.getRest());
        entity.setNotes(this.getNotes());
        entity.setWeight(this.getWeight());
        entity.setRepetitions(this.getRepetitions());
        entity.setExercise(ex);
        return entity;
    }

}
