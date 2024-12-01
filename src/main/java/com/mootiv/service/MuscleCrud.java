package com.mootiv.service;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.ExersiceRepository;
import com.mootiv.repository.MuscleRepository;
import com.mootiv.service.contract.MuscleCrudService;
import com.mootiv.shared.MuscleRequest;
import com.mootiv.shared.MuscleResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.MUSCLE_ALREADY_CREATED;
import static com.mootiv.error.ApiMootivErrors.MUSCLE_NOT_FOUND;
import static java.util.Objects.nonNull;

@Log4j2
@Service
public class MuscleCrud implements MuscleCrudService {

    private final MuscleRepository muscleRepository;
    private final ExersiceRepository exersiceRepository;

    public MuscleCrud(MuscleRepository muscleRepository, ExersiceRepository exersiceRepository) {
        this.muscleRepository = muscleRepository;
        this.exersiceRepository = exersiceRepository;
    }

    @Override
    public List<MuscleResponse> getMuscles() {
        return muscleRepository.findAll().stream()
                .map(MuscleResponse::mapFromMuscle)
                .toList();
    }

    @Override
    public MuscleResponse createMuscle(MuscleRequest bodyRequest) {

        Set<Exercise> exercises = null;
        Set<Muscle> muscles = null;

        var muscle = muscleRepository.findByName(bodyRequest.getName());
        if (muscle.isPresent()) {
            throw new BusinessException(MUSCLE_ALREADY_CREATED);
        }

        if (nonNull(bodyRequest.getIdMuscles()))
            muscles = muscleRepository.findListByIds(bodyRequest.getIdMuscles());

        if (nonNull(bodyRequest.getIdExcersices()))
            exercises = exersiceRepository.findListByIds(bodyRequest.getIdExcersices());

        var muscleSaved = muscleRepository.save(Muscle.with(bodyRequest.getName(), muscles, exercises));

        return MuscleResponse.mapFromMuscle(muscleSaved);

    }

    @Override
    public MuscleResponse updateMuscle(Integer id, MuscleRequest bodyRequest) {
        Set<Exercise> exercises = null;
        Set<Muscle> muscles = null;

        if (bodyRequest.getIdMuscles().contains(id))
            throw new RuntimeException("No es posible asociar el musculo a si mismo.");

        var muscleToUpdate = muscleRepository.findById(id)
                .orElseThrow(BusinessException.of(MUSCLE_NOT_FOUND));

        muscleRepository.findByName(bodyRequest.getName())
                .filter(existingMuscle -> !existingMuscle.getId().equals(id))
                .ifPresent(muscle -> { throw new BusinessException(MUSCLE_ALREADY_CREATED); });

        if (nonNull(bodyRequest.getIdMuscles()))
            muscles = muscleRepository.findListByIds(bodyRequest.getIdMuscles());

        if (nonNull(bodyRequest.getIdExcersices()))
            exercises = exersiceRepository.findListByIds(bodyRequest.getIdExcersices());

        muscleToUpdate.update(bodyRequest.getName(), muscles, exercises);

        var muscleSaved = muscleRepository.save(muscleToUpdate);

        return MuscleResponse.mapFromMuscle(muscleSaved);

    }

    @Override
    public MuscleResponse getMuscle(Integer id) {
        return muscleRepository.findById(id)
                .map(MuscleResponse::mapFromMuscle)
                .orElseThrow(NotFoundException.of(MUSCLE_NOT_FOUND));
    }

    @Override
    public void deleteMuscle(Integer id) {
        try {
            muscleRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es posible eliminar este musculo ya que se encuentra asociado a otra entidad.");
        }
    }

}
