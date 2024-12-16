package com.mootiv.domain.plan;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@Entity
@Getter @Setter
@NoArgsConstructor
public class TrainingWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_week_id")
    private List<TrainingDay> days;
    @Enumerated(EnumType.STRING)
    private TrainingWeekStatus status;

    public boolean canBeEdited() {
        return this.status.equals(TrainingWeekStatus.COMPLETEDA)
                || this.status.equals(TrainingWeekStatus.POSPUESTA)
                || this.status.equals(TrainingWeekStatus.CANCELEDA);
    }

    public void changeToPending() {
        if (this.status.equals(TrainingWeekStatus.BORRADOR)) {
            this.status = TrainingWeekStatus.PENDIENTE;
        } else {
            throw new RuntimeException("No es posible pasar a PENDIENTE desde " + this.status.name());
        }
    }

    public void changeToInProgress() {
        if (this.status.equals(TrainingWeekStatus.PENDIENTE) && this.startDate.isBefore(LocalDate.now().plusDays(1))) {
            this.status = TrainingWeekStatus.EN_PROGRESO;
        } else {
            throw new RuntimeException("No es posible pasar a EN_PROGRESO desde " + this.status.name());
        }
    }

    public void changeToCanceled() {
        if (!this.status.equals(TrainingWeekStatus.COMPLETEDA) && !this.status.equals(TrainingWeekStatus.POSPUESTA)) {
            this.status = TrainingWeekStatus.CANCELEDA;
            this.days.stream().forEach(trainingDay -> trainingDay.setFinishDate(LocalDate.now()));
        }
    }

    public void changeToPostponed() {
        if (this.status.equals(TrainingWeekStatus.EN_PROGRESO) || this.status.equals(TrainingWeekStatus.PENDIENTE)) {
            this.status = TrainingWeekStatus.POSPUESTA;
        } else {
            throw new RuntimeException("No es posible pasar a POSTPONED desde " + this.status.name());
        }
    }

    public void changeToComplete() {
        if (completed() || LocalDate.now().isAfter(this.startDate.plusDays(7))) {
            this.status = TrainingWeekStatus.COMPLETEDA;
        }
    }

    public TrainingDay lastDayTrained() {
        if (days == null || days.isEmpty()) {
            throw new RuntimeException("No training days available.");
        }

        return days.stream()
                .filter(TrainingDay::isCompleted)
                .max(Comparator.comparing(TrainingDay::getFinishDate))
                .orElseThrow(() -> new RuntimeException("No completed training days found."));
    }

    public LocalDate dateOfFinish() {
        if (days == null || days.isEmpty()) {
            throw new RuntimeException("No training days available.");
        }
        return days.stream()
                .filter(TrainingDay::isCompleted)
                .max(Comparator.comparing(TrainingDay::getFinishDate))
                .map(TrainingDay::getFinishDate)
                .orElseThrow(() -> new RuntimeException("No completed training days found."));
    }

    public Float getProgress() {
        if (days == null || days.isEmpty()) {
            return 0F;
        }
        return Float.valueOf (days.stream()
                        .filter(TrainingDay::isCompleted)
                        .count() * days.size() * 100);

    }

    public boolean completed() {
        return this.days.stream().allMatch(TrainingDay::isCompleted);
    }

    public boolean inFinalState() {
        return this.status.equals(TrainingWeekStatus.COMPLETEDA) || this.status.equals(TrainingWeekStatus.POSPUESTA);
    }

    public void createDaysOfTraining(Integer daysOfTraining) {
        this.days = IntStream.range(0, daysOfTraining)
                .mapToObj(day -> new TrainingDay())
                .toList();
    }

    public static TrainingWeek with(LocalDate weekStartDate, Integer daysOfTraining) {
        var trainingWeek = new TrainingWeek();
        trainingWeek.setStartDate(weekStartDate);
        trainingWeek.setStatus(TrainingWeekStatus.BORRADOR);
        trainingWeek.createDaysOfTraining(daysOfTraining);
        return trainingWeek;
    }

}
