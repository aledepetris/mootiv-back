package com.mootiv.domain.goal;

import com.mootiv.domain.TrainingType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class ScheduleGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer dayOfTraining;

    @ManyToMany
    private Set<TrainingType> trainingTypes;
}
