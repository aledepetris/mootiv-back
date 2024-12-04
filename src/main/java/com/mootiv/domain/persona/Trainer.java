package com.mootiv.domain.persona;

import com.mootiv.shared.TrainerRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.aspectj.apache.bcel.generic.RET;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Trainer extends Person {

    @OneToMany
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
}
