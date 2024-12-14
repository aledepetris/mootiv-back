package com.mootiv.service.impl;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.domain.muscle.MuscleGroup;
import com.mootiv.error.ApiError;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.ExerciseRepository;
import com.mootiv.repository.MuscleRepository;
import com.mootiv.service.MuscleCrudService;
import com.mootiv.shared.MuscleRequest;
import com.mootiv.shared.MuscleResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.mootiv.error.ApiMootivErrors.MUSCLE_ALREADY_CREATED;
import static com.mootiv.error.ApiMootivErrors.MUSCLE_NOT_FOUND;
import static java.util.Objects.nonNull;

@Log4j2
@Service
public class MuscleCrud implements MuscleCrudService {

    private final MuscleRepository muscleRepository;
    private final ExerciseRepository exerciseRepository;

    public MuscleCrud(MuscleRepository muscleRepository, ExerciseRepository exerciseRepository) {
        this.muscleRepository = muscleRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Set<MuscleResponse> getMuscles() {
        List<Muscle> muscles = muscleRepository.findAll();

        // Identificar los nodos raíz (ancianos)
        Set<Muscle> rootMuscles = findRoots(muscles);

        // Convertir los nodos raíz en MuscleResponse
        return rootMuscles.stream()
                .map(muscle -> MuscleResponse.mapFromMuscleHierarchy(muscle, new HashSet<>()))
                .collect(Collectors.toSet());
    }

    private Set<Muscle> findRoots(List<Muscle> muscles) {
        // Los nodos raíz son aquellos que no están en la lista de hijos de ningún grupo
        Set<Muscle> allChildren = muscles.stream()
                .filter(Muscle::isAMuscleGroup)
                .map(muscle -> ((MuscleGroup) muscle).getMuscles())
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        return muscles.stream()
                .filter(muscle -> !allChildren.contains(muscle))
                .collect(Collectors.toSet());
    }

    @Override
    public MuscleResponse createMuscle(MuscleRequest request) {

        Set<Exercise> exercises = null;
        Set<Muscle> muscles = null;
        Muscle parentMuscle = null;

        var muscle = muscleRepository.findByName(request.getName());
        if (muscle.isPresent()) {
            throw new BusinessException(MUSCLE_ALREADY_CREATED);
        }

        if (nonNull(request.getIdParentMuscle()))
            parentMuscle = muscleRepository.findById(request.getIdParentMuscle())
                    .orElseThrow(() -> new BusinessException(new ApiError("errorParentId", "No existe el musculo padre")));

        if (nonNull(request.getIdsMuscles()))
            muscles = muscleRepository.findListByIds(request.getIdsMuscles());

        if (nonNull(request.getIdsExercises()))
            exercises = exerciseRepository.findListByIds(request.getIdsExercises());

        var muscleSaved = muscleRepository.save(Muscle.with(request.getName(), muscles, exercises));

        if (nonNull(parentMuscle) && parentMuscle.isAMuscleGroup()) {{
            var parent = (MuscleGroup) parentMuscle;
            parent.getMuscles().add(muscleSaved);
            muscleRepository.save(parent);
        }} else {
            var parent = new MuscleGroup();
            parent.setId(parentMuscle.getId());
            parent.setName(parentMuscle.getName());
            muscleRepository.save(parent);
        }

        return MuscleResponse.mapFromMuscle(muscleSaved);

    }

    @Override
    public MuscleResponse updateMuscle(Integer id, MuscleRequest bodyRequest) {
        Set<Exercise> exercises = null;
        Set<Muscle> muscles = null;
        Muscle parentMuscle = null;

        if (nonNull(bodyRequest.getIdsMuscles())) {
            muscles = muscleRepository.findListByIds(bodyRequest.getIdsMuscles());
            if (bodyRequest.getIdsMuscles().contains(id))
                throw new RuntimeException("No es posible asociar el musculo a si mismo.");
        }

        if (nonNull(bodyRequest.getIdParentMuscle()))
            parentMuscle = muscleRepository.findById(bodyRequest.getIdParentMuscle())
                    .orElseThrow(() -> new BusinessException(new ApiError("errorParentId", "No existe el musculo padre")));


        var muscleToUpdate = muscleRepository.findById(id)
                .orElseThrow(BusinessException.of(MUSCLE_NOT_FOUND));

        muscleRepository.findByName(bodyRequest.getName())
                .filter(existingMuscle -> !existingMuscle.getId().equals(id))
                .ifPresent(muscle -> { throw new BusinessException(MUSCLE_ALREADY_CREATED);});


        if (nonNull(bodyRequest.getIdsExercises()))
            exercises = exerciseRepository.findListByIds(bodyRequest.getIdsExercises());

        muscleToUpdate.update(bodyRequest.getName(), muscles, exercises);
        var muscleSaved = muscleRepository.save(muscleToUpdate);

        if (nonNull(parentMuscle) && parentMuscle.isAMuscleGroup()) {{
            var parent = (MuscleGroup) parentMuscle;
            parent.getMuscles().add(muscleSaved);
            muscleRepository.save(parent);
        }} else {
            var parent = new MuscleGroup();
            parent.setId(parentMuscle.getId());
            parent.setName(parentMuscle.getName());
            muscleRepository.save(parent);
        }

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
