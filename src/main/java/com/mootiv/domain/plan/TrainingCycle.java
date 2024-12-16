package com.mootiv.domain.plan;

import com.mootiv.domain.TrainingType;
import com.mootiv.domain.goal.Goal;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@Entity
@Getter @Setter
@NoArgsConstructor
@Log4j2
public class TrainingCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "training_cycle_id")
    private List<TrainingWeek> weeks;
    @ManyToOne
    private Goal goal;
    @ManyToOne
    private TrainingType trainingType;
    @Enumerated(EnumType.STRING)
    private CycleStatus status;
    private Integer daysOfTraining;

    public LocalDate endDate() {
        return startDate.plusWeeks(getNumberOfWeeks());
    }

    public boolean canBeEdited() {
        return this.status.equals(CycleStatus.BORRADOR) || this.status.equals(CycleStatus.PENDIENTE);
    }

    public boolean canBeDeleted() {
        return this.status.equals(CycleStatus.BORRADOR) || this.status.equals(CycleStatus.PENDIENTE);
    }

    public void changeToPending() {
        if (this.status.equals(CycleStatus.BORRADOR)) {
            this.status = CycleStatus.PENDIENTE;
        } else {
            throw new RuntimeException("No es posible pasar a PENDING desde " + this.status.name());
        }
    }

    public void changeToCanceled() {
        if (this.status.equals(CycleStatus.COMPLETADO)) {
            throw new RuntimeException("No es posible cancelar un cyclo completado");
        }
        weeks.forEach(TrainingWeek::changeToCanceled);
        this.status = CycleStatus.CANCELADO;
    }

    public void changeToInProgress() {
        if (this.status.equals(CycleStatus.PENDIENTE) && this.startDate.isBefore(LocalDate.now().plusDays(1))) {
            this.status = CycleStatus.EN_PROGRESO;
        } else {
            log.info("No es posible pasar a EN_PROGRESO desde {} ya que su fecha es {}", this.status.name(), this.startDate.toString());
        }
    }

    public void changeToCompleted() {
       if (weeks.stream().allMatch(TrainingWeek::inFinalState))
           this.status = CycleStatus.COMPLETADO;
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
        if (!goal.validNumberOfDaysAndTraining(numberOfDays, trainingType)) {
            throw new RuntimeException("No se encontro el tipo de entrenamiento para la combinacion de dias y objetivos");
        }
        trainingCycle.setGoal(goal);
        trainingCycle.setDaysOfTraining(numberOfDays);
        trainingCycle.setTrainingType(trainingType);
        trainingCycle.setStatus(CycleStatus.BORRADOR);
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
                : updatedWeeks.get(updatedWeeks.size() - 1).getStartDate();

        TrainingWeek newWeek = TrainingWeek.with(lastStartDate.plusDays(7), week.getDays().size());
        this.weeks.add(newWeek);

        this.weeks.sort(Comparator.comparing(TrainingWeek::getStartDate));
    }


    public boolean overlapsWith(LocalDate newStartDate, int newNumberOfWeeks) {

        LocalDate newEndDate = newStartDate.plusWeeks(newNumberOfWeeks - 1);

        LocalDate currentStartDate = this.getStartDate();
        LocalDate currentEndDate = currentStartDate.plusWeeks(this.getNumberOfWeeks() - 1);

        return !(newEndDate.isBefore(currentStartDate) || newStartDate.isAfter(currentEndDate));
    }

    public Integer getNumberOfWeeks() {
        return this.weeks.size();
    }

    public boolean isCanceled() {
        return this.status.equals(CycleStatus.CANCELADO);
    }
}
