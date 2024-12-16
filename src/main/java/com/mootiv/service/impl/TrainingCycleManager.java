package com.mootiv.service.impl;


import com.mootiv.domain.Exercise;
import com.mootiv.domain.plan.CycleStatus;
import com.mootiv.domain.plan.ExerciseRoutine;
import com.mootiv.domain.plan.TrainingWeekStatus;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.*;
import com.mootiv.service.TrainingCycleService;
import com.mootiv.shared.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.nonNull;

@Service
public class TrainingCycleManager implements TrainingCycleService {

    private final StudentRepository studentRepository;
    private final TrainingTypeRepository trainingTypeRepository;
    private final GoalRepository goalRepository;
    private final ExerciseRepository exerciseRepository;
    private final TrainingDayRepository trainingDayRepository;
    private final TrainingWeekRepository trainingWeekRepository;

    public TrainingCycleManager(StudentRepository studentRepository,
                                TrainingTypeRepository trainingTypeRepository,
                                GoalRepository goalRepository, ExerciseRepository exerciseRepository, TrainingDayRepository trainingDayRepository, TrainingWeekRepository trainingWeekRepository) {
        this.studentRepository = studentRepository;
        this.trainingTypeRepository = trainingTypeRepository;
        this.goalRepository = goalRepository;
        this.exerciseRepository = exerciseRepository;
        this.trainingDayRepository = trainingDayRepository;
        this.trainingWeekRepository = trainingWeekRepository;
    }

    @Override
    public void createTrainingCycle(Integer idStudent, TrainingCycleRequest trainingCycleRequest) {

        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        var trainingType = trainingTypeRepository.findById(trainingCycleRequest.getIdTrainingType())
                .orElseThrow(NotFoundException.of(TRAINING_TYPE_NOT_FOUND));

        var goal = goalRepository.findById(trainingCycleRequest.getIdGoal())
                .orElseThrow(NotFoundException.of(GOAL_NOT_FOUND));

        var trainingPlan = student.getTrainingPlan();

        trainingPlan.createNewCycle(trainingCycleRequest.getStartDate(), trainingCycleRequest.getNumberOfWeeks(), trainingCycleRequest.getNumberOfDays(), goal, trainingType);

        studentRepository.save(student);

    }

    @Override
    public List<TrainingCycleResponse> getTrainingCycles(Integer idStudent) {

        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        if (nonNull(student.getTrainingPlan())) {
            return student.getTrainingPlan()
                    .getTrainingCycles()
                    .stream().map(TrainingCycleResponse::mapFrom)
                    .toList();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public void updateTrainingCycle(Integer idStudent, Integer idTrainingCycle, TrainingCycleRequest bodyRequest) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

    }

    @Override
    public TrainingCycleResponse getTrainingCycle(Integer idStudent, Integer idTrainingCycle) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        var cycle = student.getTrainingPlan().getCycleById(idTrainingCycle);
        return TrainingCycleResponse.mapFrom(cycle);
    }

    @Override
    public void deleteTrainingCycle(Integer idStudent, Integer idTrainingCycle) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        student.getTrainingPlan().deleteCycleById(idTrainingCycle);
        studentRepository.save(student);

    }

    @Override
    public void cambiarAEstado(Integer idStudent, Integer idTrainingCycle, CycleStatus status) {

        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        var cycle = student.getTrainingPlan().getCycleById(idTrainingCycle);

        if (status.equals(CycleStatus.BORRADOR)) {
            throw new RuntimeException("No es posible volver al estado BORRADOR");
        } else if (status.equals(CycleStatus.PENDIENTE)) {
            cycle.changeToPending();
        }  else if (status.equals(CycleStatus.EN_PROGRESO)) {
            throw new RuntimeException("El estado EN_PROGRESO se cambia automaticamente cuando arranca el ciclo");
        } else if (status.equals(CycleStatus.CANCELADO)) {
            cycle.changeToCanceled();
        } else if (status.equals(CycleStatus.COMPLETADO)) {
            throw new RuntimeException("El estado COMPLETADO se cambia automaticamente cuando se completan todas las semanas de entrenamiento");
        }

        studentRepository.save(student);

    }

    @Override
    public TrainingCycleDetailResponse getTrainingCycleDetail(Integer idStudent, Integer idTrainingCycle) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        var cycle = student.getTrainingPlan().getCycleById(idTrainingCycle);
        return TrainingCycleDetailResponse.mapFrom(cycle);
    }

    @Override
    public List<Exercise> getTrainingCycleAvailableExercise(Integer idStudent, Integer idTrainingCycle) {
        return exerciseRepository.findAll();
    }

    @Override
    public void updateDay(Integer idStudent, Integer idDay, RequestDayOfTraining request) {
        var day = trainingDayRepository.findById(idDay)
                .orElseThrow(NotFoundException.of(GOAL_NOT_FOUND));

        List<ExerciseRoutine> listEx = new ArrayList<>();

        for (ExerciseRoutineRequest ex : request.getExercises()) {
            var exer = exerciseRepository.findById(ex.getIdExercise()).get();
            listEx.add(ex.toEntity(exer));
        }

        day.setExercises(listEx);
        trainingDayRepository.save(day);
    }

    @Override
    public void finishDay(Integer idStudent, Integer idDay) {
        var day = trainingDayRepository.findById(idDay)
                .orElseThrow(NotFoundException.of(GOAL_NOT_FOUND));

        day.setFinishDate(LocalDate.now());
        trainingDayRepository.save(day);
    }

    @Override
    public void cambiarSemanaEstado(Integer idStudent, Integer idWeek, TrainingWeekStatus cycleStatus) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        var week = trainingWeekRepository.findById(idWeek)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        if (cycleStatus.equals(TrainingWeekStatus.PENDIENTE)) {
            week.changeToPending();
        } else
            throw new RuntimeException("El estado al que intenta cambiar no es posible transicionar");

        trainingWeekRepository.save(week);
    }

}
