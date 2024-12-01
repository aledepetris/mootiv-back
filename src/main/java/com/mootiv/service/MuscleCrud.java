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
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mootiv.error.ApiMootivErrors.MUSCLE_ALREADY_CREATED;
import static com.mootiv.error.ApiMootivErrors.MUSCLE_NOT_FOUND;
import static java.util.Objects.nonNull;

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

        List<Exercise> exercises = null;
        List<Muscle> muscles = null;

        muscleRepository.findByName(bodyRequest.getName())
                .orElseThrow(BusinessException.of(MUSCLE_ALREADY_CREATED));

        if (nonNull(bodyRequest.getIdExcersices()))
            exercises = exersiceRepository.findListByIds(bodyRequest.getIdExcersices());

        if (nonNull(bodyRequest.getIdMuscles()))
            muscles = muscleRepository.findListByIds(bodyRequest.getIdMuscles());

        var muscleSaved = muscleRepository.save(Muscle.with(bodyRequest.getName(), muscles, exercises));

        return MuscleResponse.mapFromMuscle(muscleSaved);

    }

    @Override
    public MuscleResponse updateMuscle(Integer id, MuscleRequest bodyRequest) {
        return null;
    }

    @Override
    public MuscleResponse getMuscle(Integer id) {

        return muscleRepository.findById(id)
                .map(MuscleResponse::mapFromMuscle)
                .orElseThrow(NotFoundException.of(MUSCLE_NOT_FOUND));
    }

    @Override
    public void deleteMuscle(Integer id) {
        muscleRepository.deleteById(id);
    }
}
