package com.mootiv.domain.cycle;

import com.mootiv.domain.Goal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class TrainingCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_cycle_id")
    private List<TrainingWeek> weeks;
    @ManyToOne
    private Goal goal;
    @Enumerated(EnumType.STRING)
    private CycleStatus status;
    private Integer daysOfTraining;

}
