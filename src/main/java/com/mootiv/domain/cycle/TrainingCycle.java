package com.mootiv.domain.cycle;

import com.mootiv.domain.TrainingType;
import com.mootiv.domain.goal.Goal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public boolean canBeEdited() {
        return this.status.equals(CycleStatus.DRAFT) || this.status.equals(CycleStatus.PENDING);
    }

    public boolean canBeDeleted() {
        return this.status.equals(CycleStatus.DRAFT) || this.status.equals(CycleStatus.PENDING);
    }

    public void changeToPending() {
        if (this.status.equals(CycleStatus.DRAFT)) {
            this.status = CycleStatus.PENDING;
        } else {
            throw new RuntimeException("No es posible pasar a PENDING desde " + this.status.name());
        }
    }

    public void changeToCanceled() {
        if (this.status.equals(CycleStatus.COMPLETED)) {
            throw new RuntimeException("No es posible cancelar un cyclo completad");
        }
        weeks.forEach(TrainingWeek::changeToCanceled);
        this.status = CycleStatus.CANCELED;
    }

    public void changeToInProgress() {
        if (this.status.equals(CycleStatus.PENDING) && this.startDate.isAfter(LocalDate.now())) {
            this.status = CycleStatus.IN_PROGRESS;
        } else {
            throw new RuntimeException("No es posible pasar a IN_PROGRESS desde " + this.status.name() + "y la fecha " + this.startDate.toString());
        }
    }

    public void changeToCompleted() {
       if (weeks.stream().allMatch(TrainingWeek::isInFinalState))
           this.status = CycleStatus.COMPLETED;
       else
           throw new RuntimeException("No es posible completar la el ciclo ya que algunos de las semanas no estan en estados finales.");

    }

    public void createWeeksOfTraining(LocalDate startDate, Integer weeks, Integer numberOfDays) {
        this.weeks = IntStream.range(0, weeks)
                .mapToObj(week -> {
                    LocalDate currentStartDate = startDate.plusDays(week * 7L);
                    return TrainingWeek.with(currentStartDate, numberOfDays);
                })
                .toList();

    }

    public static TrainingCycle with(LocalDate startDate, Integer numberOfWeeks, Integer numberOfDays, Goal goal, TrainingType trainingType) {
        TrainingCycle trainingCycle = new TrainingCycle();
        trainingCycle.setStartDate(startDate);
        if (goal.validNumberOfDaysAndTraining(numberOfDays, trainingType)) {
            throw new RuntimeException("No se encontro el tipo de entrenamiento para la combinacion de dias y objetivos");
        }
        trainingCycle.setGoal(goal);
        trainingCycle.setStatus(CycleStatus.DRAFT);
        trainingCycle.createWeeksOfTraining(startDate, numberOfWeeks, numberOfDays);
        return trainingCycle;
    }

    public void postponeWeek(TrainingWeek week) {
        week.changeToPostponed();

        List<TrainingWeek> updatedWeeks = this.weeks.stream()
                .filter(w -> w.getStartDate().isAfter(week.getStartDate()))
                .sorted(Comparator.comparing(TrainingWeek::getStartDate))
                .toList();

        updatedWeeks.forEach(w -> w.setStartDate(w.getStartDate().plusDays(14)));

        LocalDate lastStartDate = updatedWeeks.isEmpty()
                ? week.getStartDate()
                : updatedWeeks.getLast().getStartDate();

        TrainingWeek newWeek = TrainingWeek.with(lastStartDate.plusDays(7), week.getDays().size());
        this.weeks.add(newWeek);

        this.weeks.sort(Comparator.comparing(TrainingWeek::getStartDate));
    }


}
