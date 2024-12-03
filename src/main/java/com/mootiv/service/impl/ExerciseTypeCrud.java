package com.mootiv.service.impl;

import com.mootiv.domain.ExerciseType;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.ExerciseTypeRepository;
import com.mootiv.service.ExerciseTypeCrudService;
import com.mootiv.shared.ExerciseTypeRequest;
import com.mootiv.shared.ExerciseTypeResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mootiv.error.ApiMootivErrors.*;

@Service
public class ExerciseTypeCrud implements ExerciseTypeCrudService {

    private final ExerciseTypeRepository exerciseTypeRepository;

    public ExerciseTypeCrud(ExerciseTypeRepository exerciseTypeRepository) {
        this.exerciseTypeRepository = exerciseTypeRepository;
    }

    @Override
    public List<ExerciseTypeResponse> getExerciseTypes() {
        return exerciseTypeRepository.findAll().stream()
                .map(ExerciseTypeResponse::mapFrom)
                .toList();
    }

    @Override
    public ExerciseTypeResponse createExerciseType(ExerciseTypeRequest request) {

        var exerciseType = exerciseTypeRepository.findByName(request.getName());
        if (exerciseType.isPresent()) {
            throw new BusinessException(EQUIPMENT_ALREADY_CREATED);
        }
        var exerciseTypeSaved = exerciseTypeRepository.save(new ExerciseType(request.getName()));

        return ExerciseTypeResponse.mapFrom(exerciseTypeSaved);

    }

    @Override
    public ExerciseTypeResponse updateExerciseType(Integer id, ExerciseTypeRequest request) {

        var exerciseTypeToUpdate = exerciseTypeRepository.findById(id)
                .orElseThrow(BusinessException.of(EXERCISE_TYPE_NOT_FOUND));

        exerciseTypeRepository.findByName(request.getName())
                .filter(existingExerciseType -> !existingExerciseType.getId().equals(id))
                .ifPresent(exerciseType -> { throw new BusinessException(EXERCISE_TYPE_ALREADY_CREATED);});

        exerciseTypeToUpdate.setName(request.getName());
        var muscleSaved = exerciseTypeRepository.save(exerciseTypeToUpdate);

        return ExerciseTypeResponse.mapFrom(muscleSaved);

    }

    @Override
    public ExerciseTypeResponse getExerciseType(Integer id) {
        return exerciseTypeRepository.findById(id)
                .map(ExerciseTypeResponse::mapFrom)
                .orElseThrow(NotFoundException.of(EXERCISE_TYPE_NOT_FOUND));
    }

    @Override
    public void deleteExerciseType(Integer id) {
        try {
            exerciseTypeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es posible eliminar este equipo ya que se encuentra asociado a otra entidad.");
        }
    }

}
