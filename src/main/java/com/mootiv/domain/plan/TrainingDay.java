package com.mootiv.domain.plan;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static java.util.Objects.isNull;

@Entity
@Getter @Setter
public class TrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate finishDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_day_id")
    private List<ExerciseRoutine> exercises;

    public boolean isCompleted() {
        return isNull(this.finishDate);
    }

}
