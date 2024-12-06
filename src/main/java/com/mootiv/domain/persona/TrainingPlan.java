package com.mootiv.domain.persona;

import com.mootiv.domain.cycle.TrainingCycle;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TrainingPlan {

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<TrainingCycle> trainingCycles;

}
