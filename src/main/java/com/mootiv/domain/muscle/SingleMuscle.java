package com.mootiv.domain.muscle;

import com.mootiv.domain.Exercise;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class SingleMuscle extends Muscle {

    public SingleMuscle(String name) {
        super(name);
    }

    @Override
    public List<Exercise> getAssociatedExcercise() {
        return exercises;
    }

    @Override
    public boolean isAMuscleGroup() {
        return false;
    }

}
