package com.mootiv.domain.persona;

import com.mootiv.shared.TrainerRequest;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.apache.bcel.generic.RET;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Trainer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected Long dni;

    protected String name;

    protected String lastName;

    protected String email;

    protected String telephone;

    protected LocalDate birthdate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Set<Student> students;

    private boolean active;

    public static Trainer createFrom(TrainerRequest request, Set<Student> students) {
        Trainer trainer = new Trainer();
        trainer.setDni(request.getDni());
        trainer.setName(request.getName());
        trainer.setLastName(request.getLastName());
        trainer.setEmail(request.getEmail());
        trainer.setTelephone(request.getTelephone());
        trainer.setBirthdate(request.getBirthdate());
        trainer.setActive(request.getActive());
        trainer.setStudents(students);
        return trainer;
    }

    public void updateFrom(TrainerRequest request, Set<Student> students) {
        this.dni = request.getDni();
        this.name = request.getName();
        this.lastName = request.getLastName();
        this.email = request.getEmail();
        this.telephone = request.getTelephone();
        this.birthdate = request.getBirthdate();
        this.active = request.getActive();
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public Integer getAge() {
        if (birthdate == null) {
            throw new IllegalStateException("Birthdate is not set");
        }
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
