package com.mootiv.domain.persona;

import com.mootiv.domain.Condition;
import com.mootiv.domain.Measurement;
import com.mootiv.domain.TrainingPlace;
import com.mootiv.domain.cycle.TrainingCycle;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Student extends Person {

    private LocalDate startDate;

    private List<TrainingCycle> trainingCycles;

    private boolean active;

    private Set<Measurement> measurements;

    private Set<Condition> medicalHistory;

    private Set<TrainingPlace> trainingPlaces;

}
