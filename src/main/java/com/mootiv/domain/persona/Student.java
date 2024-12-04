package com.mootiv.domain.persona;

import com.mootiv.domain.Condition;
import com.mootiv.domain.Measurement;
import com.mootiv.domain.TrainingPlace;
import com.mootiv.domain.cycle.TrainingCycle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected Long dni;

    protected String name;

    protected String lastName;

    protected String email;

    protected String telephone;

    protected LocalDate birthdate;

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

    @Override
    public Integer getAge() {
        if (birthdate == null) {
            throw new IllegalStateException("Birthdate is not set");
        }
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
