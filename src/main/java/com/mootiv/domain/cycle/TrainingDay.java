package com.mootiv.domain.cycle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class TrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate completedOn;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_day_id")
    private List<ExerciseRoutine> exercises;

}
