package com.mootiv.domain.muscle;

import com.mootiv.domain.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.Objects.isNull;

@Getter
@Entity
@NoArgsConstructor
public class MuscleGroup extends Muscle {

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    List<Muscle> muscles;

    public MuscleGroup(String name) {
        super(name);
    }

    @Override
    public List<Exercise> getAssociatedExcercise() {
        return muscles.stream()
                .flatMap(muscle -> muscle.getAssociatedExcercise().stream())
                .toList();
    }

    @Override
    public boolean isAMuscleGroup() {
        return true;
    }

    @Override
    public void associateMuscles(List<Muscle> muscles) {
        if (isNull(this.muscles)) {
            this.muscles = muscles;
        } else {
            this.muscles.addAll(muscles);
        }
    }

}
