package com.mootiv.domain.persona;

import com.mootiv.domain.Condition;
import com.mootiv.domain.Measurement;
import com.mootiv.domain.TrainingPlace;
import com.mootiv.domain.cycle.TrainingCycle;
import com.mootiv.shared.StudentRequest;
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

    private boolean active;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Trainer trainer;

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<TrainingCycle> trainingCycles;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<Measurement> measurements;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<Condition> medicalHistory;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<TrainingPlace> trainingPlaces;

    public static Student createFrom(StudentRequest request, Trainer trainer) {
        Student student = new Student();
        student.setDni(request.getDni());
        student.setName(request.getName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setTelephone(request.getTelephone());
        student.setBirthdate(request.getBirthdate());
        student.setStartDate(request.getStartDate());
        student.setActive(request.getActive());
        student.setTrainer(trainer);
        return student;
    }

    public void updateFrom(StudentRequest request, Trainer trainer) {
        this.dni = request.getDni();
        this.name = request.getName();
        this.lastName = request.getLastName();
        this.email = request.getEmail();
        this.telephone = request.getTelephone();
        this.birthdate = request.getBirthdate();
        this.startDate = request.getStartDate();
        this.active = request.getActive();
        this.trainer = trainer;
    }

    @Override
    public Integer getAge() {
        if (birthdate == null) {
            throw new IllegalStateException("Birthdate is not set");
        }
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

}
