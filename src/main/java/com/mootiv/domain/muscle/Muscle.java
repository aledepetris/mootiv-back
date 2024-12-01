package com.mootiv.domain.muscle;

import com.mootiv.domain.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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
    protected Set<Exercise> exercises;


    public abstract Set<Exercise> getAssociatedExcercise();
    public abstract boolean isAMuscleGroup();
    public abstract void update(String name, Set<Muscle> muscles, Set<Exercise> exercises);

    protected Muscle(String name) {
        this.name = name;
    }

    public void addExcercise(Exercise exercise) {
        if (isNull(exercises)) exercises = new HashSet<>();
        if (this.exercises.stream().noneMatch(exerc -> exerc.getName().equals(exercise.getName()))) {
            exercises.add(exercise);
        }
    }

    public static Muscle with(String name, Set<Muscle> musclesAssociated, Set<Exercise> exercisesAssociated) {
        if (nonNull(musclesAssociated) && !musclesAssociated.isEmpty()) {
            var groupMuscle = new MuscleGroup(name);
            groupMuscle.associateMuscles(musclesAssociated);
            exercisesAssociated.forEach(groupMuscle::addExcercise);
            return groupMuscle;
        } else {
            var muscle = new SingleMuscle(name);
            exercisesAssociated.forEach(muscle::addExcercise);
            return muscle;
        }
    }

}
