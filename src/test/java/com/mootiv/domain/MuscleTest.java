package com.mootiv.domain;

import com.mootiv.domain.muscle.Muscle;
import com.mootiv.domain.muscle.MuscleGroup;
import com.mootiv.domain.muscle.SingleMuscle;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MuscleTest {



    @Test
    void testGetExcercisesSimpleMuscle() {

        Exercise bicepsConMancuerna = new Exercise("Biceps con mancuerna");
        Exercise pressBanco = new Exercise("Press banco");

        Muscle biceps = new SingleMuscle("Biceps");
        biceps.addExcercise(bicepsConMancuerna);
        biceps.addExcercise(pressBanco);

        // run test
        assertThat(biceps.getAssociatedExcercise())
                .contains(bicepsConMancuerna, pressBanco);

    }

    @Test
    void testGetExcercisesMuscleGroup() {

        Exercise bicepsConMancuerna = new Exercise("Biceps con mancuerna");
        Exercise pressBanco = new Exercise("Press banco");
        Exercise tricepsConPolea = new Exercise("Triceps con polea");

        Muscle biceps = new SingleMuscle("Biceps");
        biceps.addExcercise(bicepsConMancuerna);
        biceps.addExcercise(pressBanco);

        Muscle triceps = new SingleMuscle("Triceps");
        triceps.addExcercise(tricepsConPolea);

        Muscle brazo = new MuscleGroup("Brazo");
        brazo.associateMuscles(List.of(biceps, triceps));

        System.out.println(brazo);
        // run test
        assertThat(brazo.getAssociatedExcercise())
                .contains(bicepsConMancuerna, pressBanco, tricepsConPolea);

    }

}
