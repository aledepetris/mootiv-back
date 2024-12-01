package com.mootiv.domain.muscle;

import com.mootiv.domain.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Getter
@Entity
@NoArgsConstructor
public class MuscleGroup extends Muscle {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    Set<Muscle> muscles;

    public MuscleGroup(String name) {
        super(name);
    }

    @Override
    public Set<Exercise> getAssociatedExcercise() {
        return muscles.stream()
                .flatMap(muscle -> muscle.getAssociatedExcercise().stream())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isAMuscleGroup() {
        return true;
    }

    @Override
    public void update(String name, Set<Muscle> muscles, Set<Exercise> exercises) {
        this.name = name;
        this.muscles = muscles;
        this.exercises = exercises;
    }

    public void associateMuscles(Set<Muscle> muscles) {
        if (isNull(this.muscles)) {
            this.muscles = muscles;
        } else {
            this.muscles.addAll(muscles);
        }
    }

}
