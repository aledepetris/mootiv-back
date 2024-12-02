package com.mootiv.service;


import com.mootiv.domain.Equipment;
import com.mootiv.domain.Exercise;
import com.mootiv.domain.ExerciseType;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.repository.EquipmentRepository;
import com.mootiv.repository.ExerciseRepository;
import com.mootiv.repository.ExerciseTypeRepository;
import com.mootiv.repository.MuscleRepository;
import com.mootiv.service.contract.ExerciseCrudService;
import com.mootiv.shared.ExerciseRequest;
import com.mootiv.shared.ExerciseResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.MUSCLE_ALREADY_CREATED;
import static java.util.Objects.nonNull;

@Service
public class ExerciseCrud implements ExerciseCrudService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseTypeRepository exerciseTypeRepository;
    private final MuscleRepository muscleRepository;
    private final EquipmentRepository equipmentRepository;

    public ExerciseCrud(ExerciseRepository exerciseRepository, ExerciseTypeRepository exerciseTypeRepository, MuscleRepository muscleRepository, EquipmentRepository equipmentRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseTypeRepository = exerciseTypeRepository;
        this.muscleRepository = muscleRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<ExerciseResponse> getExercise() {
        return exerciseRepository.findAll().stream()
                .map(exercise -> ExerciseResponse.mapFrom(exercise))
                .toList();
    }

    @Override
    public ExerciseResponse createExercise(ExerciseRequest request) {

        Set<Muscle> muscles = null;
        Set<ExerciseType> types = null;
        Set<Equipment> equipment = null;


        var exercise = exerciseRepository.findByName(request.getName());
        if (exercise.isPresent()) {
            throw new BusinessException(MUSCLE_ALREADY_CREATED);
        }

        if (nonNull(request.getIdMuscles()))
            muscles = muscleRepository.findListByIds(request.getIdMuscles());

        if (nonNull(request.getIdExercisesType()))
            types = exerciseTypeRepository.findListByIds(request.getIdExercisesType());

        if (nonNull(request.getIdEquipments()))
            equipment = equipmentRepository.findListByIds(request.getIdEquipments());


        var ex = Exercise.with(request.getName(), request.getIsTotal(), request.getIsForTime(), muscles, types, equipment);

        exerciseRepository.save(ex);

        return ExerciseResponse.mapFrom(ex);

    }

    @Override
    public ExerciseResponse updateExercise(Integer id, ExerciseRequest bodyRequest) {
        return null;
    }

    @Override
    public ExerciseResponse getExercise(Integer id) {
        return null;
    }

    @Override
    public void deleteExercise(Integer id) {
    }

}
