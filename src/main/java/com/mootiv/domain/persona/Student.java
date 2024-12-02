package com.mootiv.domain.persona;

import com.mootiv.domain.Condition;
import com.mootiv.domain.Measurement;
import com.mootiv.domain.TrainingPlace;
import com.mootiv.domain.cycle.TrainingCycle;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Student extends Person {

    private LocalDate startDate;

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<TrainingCycle> trainingCycles;

    private boolean active;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<Measurement> measurements;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<Condition> medicalHistory;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<TrainingPlace> trainingPlaces;

}
