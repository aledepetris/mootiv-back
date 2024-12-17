package com.mootiv.service.impl;


import com.mootiv.domain.*;
import com.mootiv.domain.exporter.CsvRutinaExporter;
import com.mootiv.domain.exporter.PdfRutinaExporter;
import com.mootiv.domain.exporter.RutinaExporter;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.domain.persona.ClinicalHistory;
import com.mootiv.domain.plan.CycleStatus;
import com.mootiv.domain.plan.ExerciseRoutine;
import com.mootiv.domain.plan.TrainingWeekStatus;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.*;
import com.mootiv.service.TrainingCycleService;
import com.mootiv.shared.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.nonNull;

@Service
public class TrainingCycleManager implements TrainingCycleService {

    private final StudentRepository studentRepository;
    private final TrainingTypeRepository trainingTypeRepository;
    private final GoalRepository goalRepository;
    private final ExerciseRepository exerciseRepository;
    private final TrainingCycleRepository trainingCycleRepository;
    private final TrainingDayRepository trainingDayRepository;
    private final TrainingWeekRepository trainingWeekRepository;

    public TrainingCycleManager(StudentRepository studentRepository,
                                TrainingTypeRepository trainingTypeRepository,
                                GoalRepository goalRepository, ExerciseRepository exerciseRepository, TrainingCycleRepository trainingCycleRepository, TrainingDayRepository trainingDayRepository, TrainingWeekRepository trainingWeekRepository) {
        this.studentRepository = studentRepository;
        this.trainingTypeRepository = trainingTypeRepository;
        this.goalRepository = goalRepository;
        this.exerciseRepository = exerciseRepository;
        this.trainingCycleRepository = trainingCycleRepository;
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

        var ciclo = trainingCycleRepository.findById(idTrainingCycle)
                .orElseThrow(() -> new RuntimeException("No se encontro el ciclo"));
        var student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new RuntimeException("No se encontro el estudiante"));

        Set<Muscle> affectedMuscles = Optional.ofNullable(student.getClinicalHistory())
                .map(ClinicalHistory::getConditions)
                .orElse(Collections.emptySet()) // Si no hay condiciones, devuelve un conjunto vacío
                .stream()
                .filter(Condition::isActive) // Solo condiciones activas
                .map(condition -> condition.getAffection()) // Obtener la afección de cada condición
                .filter(Objects::nonNull) // Asegurarse de que la afección no sea null
                .flatMap(affection -> affection.getMusclesAffected().stream()) // Obtener los músculos afectados
                .collect(Collectors.toSet());

        Set<ExerciseType> validExerciseTypes = ciclo.getTrainingType().getExerciseTypes();

        // Equipamientos disponibles en el lugar de entrenamiento del estudiante
        Set<Equipment> availableEquipments = Optional.ofNullable(student.getTrainingPlaces())
                .orElse(Collections.emptySet()) // Si no hay lugares, devuelve una lista vacía
                .stream()
                .map(TrainingPlace::getEquipments)
                .filter(Objects::nonNull) // Evitar equipamientos nulos
                .flatMap(Set::stream)
                .collect(Collectors.toSet());


        return exerciseRepository.findAll()
                .stream()
                // 1. Filtrar por tipos de ejercicios válidos
                .filter(exercise -> exercise.getExercisesType()
                        .stream()
                        .anyMatch(validExerciseTypes::contains))
                // 2. Excluir ejercicios que tienen músculos afectados
                .filter(exercise -> exercise.getMuscles()
                        .stream()
                        .noneMatch(affectedMuscles::contains))
                // 3. Incluir ejercicios con equipamiento necesario o sin equipamiento
                .filter(exercise -> {
                    Set<Equipment> requiredEquipments = exercise.getEquipments();
                    return requiredEquipments == null || requiredEquipments.isEmpty() ||
                            availableEquipments.containsAll(requiredEquipments);
                })
                .toList();

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

    @Override
    public String generateWeekFile(Integer cycleId, Integer weekId, String fileType) {

        var ciclo = trainingCycleRepository.getReferenceById(cycleId);

        if (fileType.equals("pdf")) {
            RutinaExporter pdfExporter = new PdfRutinaExporter(ciclo);
            return pdfExporter.generateRoutineFile(weekId);
        }

        RutinaExporter csvExporter = new CsvRutinaExporter(ciclo);
        return csvExporter.generateRoutineFile(weekId);

    }

}
