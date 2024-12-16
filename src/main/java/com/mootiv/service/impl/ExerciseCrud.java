package com.mootiv.service.impl;


import com.mootiv.domain.Equipment;
import com.mootiv.domain.Exercise;
import com.mootiv.domain.ExerciseType;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.domain.plan.ExerciseRoutine;
import com.mootiv.domain.templates.TemplateExercises;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.*;
import com.mootiv.service.ExerciseCrudService;
import com.mootiv.shared.ExerciseRequest;
import com.mootiv.shared.ExerciseResponse;
import com.mootiv.shared.ExerciseTemplateWrap;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.nonNull;

@Service
public class ExerciseCrud implements ExerciseCrudService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseTypeRepository exerciseTypeRepository;
    private final MuscleRepository muscleRepository;
    private final EquipmentRepository equipmentRepository;
    private final TemplateExerciseRepository templateExerciseRepository;
    private final TemplateWeekRepository templateWeekRepository;

    public ExerciseCrud(ExerciseRepository exerciseRepository, ExerciseTypeRepository exerciseTypeRepository, MuscleRepository muscleRepository, EquipmentRepository equipmentRepository, TemplateExerciseRepository templateExerciseRepository, TemplateWeekRepository templateWeekRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseTypeRepository = exerciseTypeRepository;
        this.muscleRepository = muscleRepository;
        this.equipmentRepository = equipmentRepository;
        this.templateExerciseRepository = templateExerciseRepository;
        this.templateWeekRepository = templateWeekRepository;
    }

    @Override
    public List<ExerciseResponse> getExercise() {
        return exerciseRepository.findAll().stream()
                .map(ExerciseResponse::mapFrom)
                .toList();
    }

    @Override
    public ExerciseResponse createExercise(ExerciseRequest request) {

        Set<Muscle> muscles = null;
        Set<ExerciseType> exerciseTypes = null;
        Set<Equipment> equipment = null;

        var exercise = exerciseRepository.findByName(request.getName());
        if (exercise.isPresent()) {
            throw new BusinessException(MUSCLE_ALREADY_CREATED);
        }

        if (nonNull(request.getIdsMuscles()))
            muscles = muscleRepository.findListByIds(request.getIdsMuscles());

        if (nonNull(request.getIdsExercisesType()))
            exerciseTypes = exerciseTypeRepository.findListByIds(request.getIdsExercisesType());

        if (nonNull(request.getIdsEquipments()))
            equipment = equipmentRepository.findListByIds(request.getIdsEquipments());


        var ex = Exercise.with(request.getName(), request.getAlt_img(), request.getDescription(), request.getIsTotal(), request.getIsForTime(), muscles, exerciseTypes, equipment);

        exerciseRepository.save(ex);

        return ExerciseResponse.mapFrom(ex);

    }

    @Override
    public ExerciseResponse updateExercise(Integer id, ExerciseRequest request) {
        Set<Muscle> muscles = null;
        Set<ExerciseType> exerciseTypes = null;
        Set<Equipment> equipments = null;

        var exerciseToUpdate = exerciseRepository.findById(id)
                .orElseThrow(BusinessException.of(EXERCISE_NOT_FOUND));


        exerciseRepository.findByName(request.getName())
                .filter(existingExercise -> !existingExercise.getId().equals(id))
                .ifPresent(exercise -> { throw new BusinessException(EXERCISE_ALREADY_CREATED);});

        if (nonNull(request.getIdsMuscles()))
            muscles = muscleRepository.findListByIds(request.getIdsMuscles());

        if (nonNull(request.getIdsExercisesType()))
            exerciseTypes = exerciseTypeRepository.findListByIds(request.getIdsExercisesType());

        if (nonNull(request.getIdsEquipments()))
            equipments = equipmentRepository.findListByIds(request.getIdsEquipments());


        exerciseToUpdate.update(request.getName(), request.getAlt_img(), request.getDescription(), request.getIsTotal(), request.getIsForTime(), muscles, exerciseTypes, equipments);

        exerciseRepository.save(exerciseToUpdate);

        return ExerciseResponse.mapFrom(exerciseToUpdate);
    }

    @Override
    public ExerciseResponse getExercise(Integer id) {
        return exerciseRepository.findById(id)
                .map(ExerciseResponse::mapFrom)
                .orElseThrow(NotFoundException.of(EXERCISE_NOT_FOUND));
    }

    @Override
    public void deleteExercise(Integer id) {
        try {
            exerciseRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es posible eliminar este ejercicio ya que se encuentra asociado a otra entidad.");
        }
    }

    @Override
    public  List<ExerciseTemplateWrap>  getTemplateWeek() {
        return null;
    }

    @Override
    public List<ExerciseTemplateWrap> getTemplateExercises() {
        return templateExerciseRepository.findAll()
                .stream()
                .map(template -> ExerciseTemplateWrap.mapFrom(template, false))
                .toList();
    }

    @Override
    public List<ExerciseTemplateWrap> getTemplateExercisesList() {
        return templateExerciseRepository.findAll()
                .stream()
                .map(template -> ExerciseTemplateWrap.mapFrom(template, true))
                .toList();
    }

    @Override
    public ExerciseTemplateWrap createTemplate(ExerciseTemplateWrap requestBody) {
        TemplateExercises templateExercises = new TemplateExercises();
        templateExercises.setCreationDate(LocalDate.now());
        templateExercises.setName(requestBody.getName());
        templateExercises.setDescription(requestBody.getDescription());

        Set<ExerciseRoutine> listExercises = requestBody.getExercises().stream()
                .map(exerciseTemplate -> {
                    var exRoutine = new ExerciseRoutine();
                    exRoutine.setExercise(exerciseTemplate.getExercise());
                    exRoutine.setRest(exerciseTemplate.getRest());
                    exRoutine.setRepetitions(exerciseTemplate.getRepetitions());
                    exRoutine.setSets(exerciseTemplate.getSets());
                    exRoutine.setNotes(exerciseTemplate.getNotes());
                    exRoutine.setWeight(exerciseTemplate.getWeight());
                    return exRoutine;
                })
                .collect(Collectors.toSet());

        templateExercises.setExercises(listExercises);

        templateExerciseRepository.save(templateExercises);
        return null;
    }

    @Override
    public ExerciseTemplateWrap updateTemplate(Integer idTemplate, ExerciseTemplateWrap requestBody) {

        TemplateExercises templateExercises = templateExerciseRepository.findById(idTemplate)
                .orElseThrow(NotFoundException.of(EXERCISE_NOT_FOUND));

        templateExercises.setName(requestBody.getName());
        templateExercises.setDescription(requestBody.getDescription());

        Set<ExerciseRoutine> listExercises = requestBody.getExercises().stream()
                .map(exerciseTemplate -> {
                    var exRoutine = new ExerciseRoutine();
                    exRoutine.setId(exerciseTemplate.getId());
                    exRoutine.setExercise(exerciseTemplate.getExercise());
                    exRoutine.setRest(exerciseTemplate.getRest());
                    exRoutine.setRepetitions(exerciseTemplate.getRepetitions());
                    exRoutine.setSets(exerciseTemplate.getSets());
                    exRoutine.setNotes(exerciseTemplate.getNotes());
                    exRoutine.setWeight(exerciseTemplate.getWeight());
                    return exRoutine;
                })
                .collect(Collectors.toSet());

        templateExercises.setExercises(listExercises);

        templateExerciseRepository.save(templateExercises);
        return null;

    }

    @Override
    public ExerciseTemplateWrap getExerciseTemplate(Integer idTemplate) {
        return ExerciseTemplateWrap.mapFrom(
                templateExerciseRepository.findById(idTemplate)
                .orElseThrow(NotFoundException.of(EXERCISE_NOT_FOUND)), true);

    }

    @Override
    public void deleteExerciseTemplate(Integer idTemplate) {
        templateExerciseRepository.deleteById(idTemplate);
    }

}
