package com.mootiv.domain.muscle;

import com.mootiv.domain.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


@Entity
@Getter @Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    protected String name;

    @ManyToMany(mappedBy = "muscles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected Set<Exercise> exercises;

    public abstract Set<Exercise> getAssociatedExcercise();
    public abstract void update(String name, Set<Muscle> muscles, Set<Exercise> exercises);

    protected Muscle(String name) {
        this.name = name;
    }

    public void addExcercise(Exercise exercise) {
        if (isNull(exercises)) exercises = new HashSet<>();
        if (this.exercises.stream().noneMatch(exerc -> exerc.getName().equals(exercise.getName()))) {
            exercises.add(exercise);
            exercise.getMuscles().add(this);
        }
    }

    public static Muscle with(String name, Set<Muscle> musclesAssociated, Set<Exercise> exercisesAssociated) {
        if (nonNull(musclesAssociated) && !musclesAssociated.isEmpty()) {
            var groupMuscle = new MuscleGroup(name);
            groupMuscle.associateMuscles(musclesAssociated);
            if (nonNull(exercisesAssociated) && !exercisesAssociated.isEmpty())
                exercisesAssociated.forEach(groupMuscle::addExcercise);
            return groupMuscle;
        } else {
            var muscle = new SingleMuscle(name);
            if (nonNull(exercisesAssociated) && !exercisesAssociated.isEmpty())
                exercisesAssociated.forEach(muscle::addExcercise);
            return muscle;
        }
    }

}
