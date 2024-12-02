package com.mootiv.service.contract;

import com.mootiv.domain.Affection;
import com.mootiv.domain.Exercise;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.AffectionRepository;
import com.mootiv.repository.ExerciseRepository;
import com.mootiv.shared.AffectionRequest;
import com.mootiv.shared.AffectionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.nonNull;

@Service
public class AffectionCrud implements AffectionCrudService {

    private final AffectionRepository affectionRepository;
    private final ExerciseRepository exerciseRepository;

    public AffectionCrud(AffectionRepository affectionRepository, ExerciseRepository exerciseRepository) {
        this.affectionRepository = affectionRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<AffectionResponse> getAffections() {
        return affectionRepository.findAll().stream()
                .map(AffectionResponse::mapFrom)
                .toList();
    }

    @Override
    public AffectionResponse createAffection(AffectionRequest request) {
        Set<Exercise> excludedExercises = null;

        var affection = affectionRepository.findByName(request.getName());
        if (affection.isPresent()) {
            throw new BusinessException(AFFECTION_ALREADY_CREATED);
        }

        if (nonNull(request.getIdExercisesExcluded()))
            excludedExercises = exerciseRepository.findListByIds(request.getIdExercisesExcluded());

        var affectionSaved = affectionRepository.save(Affection.with(request.getName(), request.getDescription(), excludedExercises));

        return AffectionResponse.mapFrom(affectionSaved);

    }

    @Override
    public AffectionResponse updateAffection(Integer id, AffectionRequest request) {
        Set<Exercise> excludedExercises = null;

        var affectionToUpdate = affectionRepository.findById(id)
                .orElseThrow(BusinessException.of(AFFECTION_NOT_FOUND));

        affectionRepository.findByName(request.getName())
                .filter(existintAffection -> !existintAffection.getId().equals(id))
                .ifPresent(affection -> { throw new BusinessException(MUSCLE_ALREADY_CREATED);});


        if (nonNull(request.getIdExercisesExcluded()))
            excludedExercises = exerciseRepository.findListByIds(request.getIdExercisesExcluded());

        affectionToUpdate.update(request.getName(), request.getDescription(), excludedExercises);

        var affectionSaved = affectionRepository.save(affectionToUpdate);

        return AffectionResponse.mapFrom(affectionSaved);
    }

    @Override
    public AffectionResponse getAffection(Integer id) {
        return affectionRepository.findById(id)
                .map(AffectionResponse::mapFrom)
                .orElseThrow(NotFoundException.of(AFFECTION_NOT_FOUND));
    }

    @Override
    public void deleteAffection(Integer id) {
        try {
            affectionRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es posible eliminar este recurso ya que se encuentra asociado a otra entidad.");
        }
    }
}
