package com.mootiv.service.impl;

import com.mootiv.domain.TrainingType;
import com.mootiv.domain.ExerciseType;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.TrainingTypeRepository;
import com.mootiv.repository.ExerciseTypeRepository;
import com.mootiv.service.TrainingTypeCrudService;
import com.mootiv.shared.TrainingTypeRequest;
import com.mootiv.shared.TrainingTypeResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.nonNull;

@Service
public class TrainingTypeCrud implements TrainingTypeCrudService {

    private final TrainingTypeRepository trainingTypeRepository;
    private final ExerciseTypeRepository exerciseRepository;

    public TrainingTypeCrud(TrainingTypeRepository trainingTypeRepository, ExerciseTypeRepository exerciseRepository) {
        this.trainingTypeRepository = trainingTypeRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<TrainingTypeResponse> getTrainingTypes() {
        return trainingTypeRepository.findAll().stream()
                .map(TrainingTypeResponse::mapFrom)
                .toList();
    }

    @Override
    public TrainingTypeResponse createTrainingType(TrainingTypeRequest request) {

        Set<ExerciseType> exerciseTypes = null;

        var trainingType = trainingTypeRepository.findByName(request.getName());
        if (trainingType.isPresent()) {
            throw new BusinessException(TRAINING_TYPE_ALREADY_CREATED);
        }

        if (nonNull(request.getIdsExerciseTypes()))
            exerciseTypes = exerciseRepository.findListByIds(request.getIdsExerciseTypes());

        var trainingTypeSaved = trainingTypeRepository.save(TrainingType.with(request.getName(), request.getDescription(), exerciseTypes));

        return TrainingTypeResponse.mapFrom(trainingTypeSaved);

    }

    @Override
    public TrainingTypeResponse updateTrainingType(Integer id, TrainingTypeRequest request) {

        Set<ExerciseType> exerciseTypes = null;
        var trainingTypeToUpdate = trainingTypeRepository.findById(id)
                .orElseThrow(BusinessException.of(TRAINING_TYPE_NOT_FOUND));

        trainingTypeRepository.findByName(request.getName())
                .filter(existintTrainingType -> !existintTrainingType.getId().equals(id))
                .ifPresent(trainingType -> { throw new BusinessException(TRAINING_TYPE_ALREADY_CREATED);});


        if (nonNull(request.getIdsExerciseTypes()))
            exerciseTypes = exerciseRepository.findListByIds(request.getIdsExerciseTypes());

        trainingTypeToUpdate.update(request.getName(), request.getDescription(), exerciseTypes);

        var trainingTypeSaved = trainingTypeRepository.save(trainingTypeToUpdate);

        return TrainingTypeResponse.mapFrom(trainingTypeSaved);
    }

    @Override
    public TrainingTypeResponse getTrainingType(Integer id) {
        return trainingTypeRepository.findById(id)
                .map(TrainingTypeResponse::mapFrom)
                .orElseThrow(NotFoundException.of(TRAINING_TYPE_NOT_FOUND));
    }

    @Override
    public void deleteTrainingType(Integer id) {
        try {
            trainingTypeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es posible eliminar este recurso ya que se encuentra asociado a otra entidad.");
        }
    }
}
