package com.mootiv.domain.muscle;

import com.mootiv.domain.Exercise;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.Set;

import static java.util.Objects.nonNull;

@Entity
@NoArgsConstructor
public class SingleMuscle extends Muscle {

    public SingleMuscle(String name) {
        super(name);
    }

    @Override
    public Set<Exercise> getAssociatedExcercise() {
        return exercises;
    }


    @Override
    public void update(String name, Set<Muscle> muscles, Set<Exercise> exercises) {
        if (nonNull(muscles) && !muscles.isEmpty())
            throw new RuntimeException("No es posible transformar este musculo en un grupo de musculo");
        this.name = name;
        this.exercises = exercises;
    }

}
