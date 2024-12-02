package com.mootiv.domain.cycle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class TrainingWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TrainingDay> days;
    private TrainingWeekStatus status;

}
