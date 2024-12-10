package com.mootiv.domain.persona;

import com.mootiv.domain.*;
import com.mootiv.domain.plan.TrainingPlan;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.shared.ConditionRequest;
import com.mootiv.shared.MeasureRequest;
import com.mootiv.shared.StudentRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.isNull;

@Entity
@Getter @Setter
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected Long dni;

    protected String name;

    protected String lastName;

    protected String email;

    protected String telephone;

    protected LocalDate birthdate;

    private LocalDate startDate;

    private boolean active;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Trainer trainer;

    @Embedded
    private TrainingPlan trainingPlan;

    @Embedded
    private ClinicalHistory clinicalHistory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set<Measure> measures;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set<TrainingPlace> trainingPlaces;

    public static Student createFrom(StudentRequest request, Trainer trainer) {
        Student student = new Student();
        student.setDni(request.getDni());
        student.setName(request.getName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setTelephone(request.getTelephone());
        student.setBirthdate(request.getBirthdate());
        student.setStartDate(request.getStartDate());
        student.setActive(request.getActive());
        student.setTrainer(trainer);
        return student;
    }

    public void updateFrom(StudentRequest request, Trainer trainer) {
        this.dni = request.getDni();
        this.name = request.getName();
        this.lastName = request.getLastName();
        this.email = request.getEmail();
        this.telephone = request.getTelephone();
        this.birthdate = request.getBirthdate();
        this.startDate = request.getStartDate();
        this.active = request.getActive();
        this.trainer = trainer;
    }

    @Override
    public Integer getAge() {
        if (birthdate == null) {
            throw new IllegalStateException("Birthdate is not set");
        }
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public void addMeasure(MeasureRequest request) {
        if (isNull(this.measures)) {
            this.measures = new HashSet<>();
        }
        var measure = new Measure();
        measure.setDate(isNull(request.getDate()) ? LocalDate.now() : request.getDate());
        measure.setHeight(request.getHeight());
        measure.setWeight(request.getWeight());
        measure.setShoulder(request.getShoulder());
        measure.setChest(request.getChest());
        measure.setArm(request.getArm());
        measure.setWaist(request.getWaist());
        measure.setHip(request.getHip());
        measure.setLeg(request.getLeg());
        measures.add(measure);
    }

    public void updateMeasure(Integer idMeasure, MeasureRequest request) {

        var measureToUpdate = this.measures.stream().filter(measure -> measure.getId().equals(idMeasure))
                        .findAny()
                                .orElseThrow(NotFoundException.of(MEASURE_NOT_FOUND));

        measureToUpdate.setDate(isNull(request.getDate()) ? LocalDate.now() : request.getDate());
        measureToUpdate.setHeight(request.getHeight());
        measureToUpdate.setWeight(request.getWeight());
        measureToUpdate.setShoulder(request.getShoulder());
        measureToUpdate.setChest(request.getChest());
        measureToUpdate.setArm(request.getArm());
        measureToUpdate.setWaist(request.getWaist());
        measureToUpdate.setHip(request.getHip());
        measureToUpdate.setLeg(request.getLeg());

    }

    public Measure getMeasure(Integer idMeasure) {
        return this.measures.stream().filter(measure -> measure.getId().equals(idMeasure))
                .findAny()
                .orElseThrow(NotFoundException.of(MEASURE_NOT_FOUND));
    }

    public void deleteMeasure(Integer idMeasure) {
        if (!this.measures.removeIf(measure -> measure.getId().equals(idMeasure))) {
            throw new NotFoundException(MEASURE_NOT_FOUND);
        }
    }

    public void addTrainingPlace(String name, Set<Equipment> equipments) {

        if (isNull(this.trainingPlaces)) {
            this.trainingPlaces = new HashSet<>();
        }
        var trainingPlace = new TrainingPlace();
        trainingPlace.setName(name);
        trainingPlace.setEquipments(equipments);
        trainingPlaces.add(trainingPlace);

    }

    public void updateTrainingPlace(Integer idTrainingPlace, String name, Set<Equipment> equipments) {
        var trainingPlaceToUpdate = this.trainingPlaces.stream().filter(trainingPlace -> trainingPlace.getId().equals(idTrainingPlace))
                .findAny()
                .orElseThrow(NotFoundException.of(TRAINING_PLACE_NOT_FOUND));

        trainingPlaceToUpdate.setName(name);
        trainingPlaceToUpdate.setEquipments(equipments);
    }

    public TrainingPlace getTrainingPlace(Integer idTrainingPlace) {
        return this.trainingPlaces.stream().filter(trainingPlace -> trainingPlace.getId().equals(idTrainingPlace))
                .findAny()
                .orElseThrow(NotFoundException.of(TRAINING_PLACE_NOT_FOUND));
    }

    public void deleteTrainingPlace(Integer idTrainingPlace) {
        if (!this.trainingPlaces.removeIf(trainingPlace -> trainingPlace.getId().equals(idTrainingPlace))) {
            throw new NotFoundException(TRAINING_PLACE_NOT_FOUND);
        }
    }

    public Set<Condition> getAllConditions() {
        return this.clinicalHistory.getConditions();
    }

    public Set<Condition> getConditionsBySeverity(ConditionSeverity severity) {
        return this.clinicalHistory.getConditions().stream()
                .filter(condition -> condition.getSeverity().equals(severity))
                .collect(Collectors.toSet());
    }

    public Set<Condition> getConditionsByStatus(ConditionStatus status) {
        return this.clinicalHistory.getConditions().stream()
                .filter(condition -> condition.getCurrentStatus().equals(status))
                .collect(Collectors.toSet());
    }

    public void addCondition(ConditionRequest request, Affection affection) {
        if (isNull(this.clinicalHistory)) {
            this.clinicalHistory = new ClinicalHistory(new HashSet<>());
        } else {
            var condition = new Condition();
            condition.setAffection(affection);
            condition.setSeverity(ConditionSeverity.valueOf(request.getSeverity()));
            condition.setCurrentStatus(ConditionStatus.valueOf(request.getCurrentStatus()));
            condition.setDiagnosisDate(request.getDiagnosisDate());
            condition.setNotes(request.getNotes());
            this.clinicalHistory.addCondition(condition);
        }
    }

    public void updateCondition(ConditionRequest request, Integer idCondition, Affection affection) {
        var conditionToUpdate = this.getAllConditions().stream()
                    .filter(measure -> measure.getId().equals(idCondition))
                    .findAny()
                .orElseThrow(NotFoundException.of(CONDITION_NOT_FOUND));

        conditionToUpdate.setNotes(request.getNotes());
        conditionToUpdate.setAffection(affection);
        conditionToUpdate.setSeverity(ConditionSeverity.valueOf(request.getSeverity()));
        conditionToUpdate.setCurrentStatus(ConditionStatus.valueOf(request.getCurrentStatus()));
        conditionToUpdate.setDiagnosisDate(request.getDiagnosisDate());
    }

    public Condition getCondition(Integer idCondition) {
        return this.getAllConditions().stream()
                    .filter(condition -> condition.getId().equals(idCondition))
                    .findAny()
                .orElseThrow(NotFoundException.of(CONDITION_NOT_FOUND));
    }


    public void deleteCondition(Integer idCondition) {
        this.clinicalHistory.removeCondition(idCondition);
    }
}
