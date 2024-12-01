package com.mootiv.domain.muscle;

import com.mootiv.domain.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
public abstract class Muscle {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    protected String name;

    @ManyToMany(fetch = FetchType.LAZY)
    protected List<Exercise> exercises;


    public abstract List<Exercise> getAssociatedExcercise();

    public abstract boolean isAMuscleGroup();

    public abstract void associateMuscles(List<Muscle> muscles);

    protected Muscle(String name) {
        this.name = name;
    }

    public void addExcercise(Exercise exercise) {
        if (isNull(exercises)) exercises = new ArrayList<>();
        if (this.exercises.stream().noneMatch(exerc -> exerc.getName().equals(exercise.getName()))) {
            exercises.add(exercise);
        }
    }

    public static Muscle with(String name, List<Muscle> musclesAssociated, List<Exercise> exercisesAssociated) {

        Muscle muscle;
        if (nonNull(musclesAssociated) && !musclesAssociated.isEmpty()) {
            muscle = new MuscleGroup(name);
            muscle.associateMuscles(musclesAssociated);
        } else {
            muscle = new SingleMuscle(name);
        }

        if (nonNull(exercisesAssociated))
            exercisesAssociated.forEach(muscle::addExcercise);

        return muscle;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Muscle muscle = (Muscle) o;
        return Objects.equals(name, muscle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
