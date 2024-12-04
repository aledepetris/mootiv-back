package com.mootiv.service.impl;

import com.mootiv.domain.persona.Student;
import com.mootiv.domain.persona.Trainer;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.StudentRepository;
import com.mootiv.repository.TrainerRepository;
import com.mootiv.service.TrainerCrudService;
import com.mootiv.shared.TrainerRequest;
import com.mootiv.shared.TrainerResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.nonNull;

@Service
public class TrainerCrud implements TrainerCrudService {

    private final TrainerRepository trainerRepository;
    private final StudentRepository studentRepository;

    public TrainerCrud(TrainerRepository trainerRepository, StudentRepository studentRepository) {
        this.trainerRepository = trainerRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<TrainerResponse> getTrainers() {
        var trainers = trainerRepository.findAll();
        return trainers.stream()
                .map(TrainerResponse::mapFrom)
                .toList();
    }

    @Override
    public TrainerResponse createTrainer(TrainerRequest request) {
        Set<Student> students = null;

        var trainer = trainerRepository.findByDni(request.getDni());
        if (trainer.isPresent()) {
            throw new BusinessException(TRAINER_ALREADY_CREATED);
        }

        if (nonNull(request.getIdsStudents()))
            students = studentRepository.findListByIds(request.getIdsStudents());

        var trainerSaved = trainerRepository.save(Trainer.createFrom(request, students));

        return TrainerResponse.mapFrom(trainerSaved);

    }

    @Override
    public TrainerResponse updateTrainer(Integer id, TrainerRequest request) {
        Set<Student> students = null;

        var trainerToUpdate = trainerRepository.findById(id)
                .orElseThrow(BusinessException.of(TRAINER_NOT_FOUND));

        trainerRepository.findByDni(request.getDni())
                .filter(existintTrainer -> !existintTrainer.getId().equals(id))
                .ifPresent(trainer -> { throw new BusinessException(TRAINER_ALREADY_CREATED);});


        if (nonNull(request.getIdsStudents()))
            students = studentRepository.findListByIds(request.getIdsStudents());

        trainerToUpdate.updateFrom(request, students);

        var trainerSaved = trainerRepository.save(trainerToUpdate);

        return TrainerResponse.mapFrom(trainerSaved);
    }

    @Override
    public TrainerResponse getTrainer(Integer id) {
        return trainerRepository.findById(id)
                .map(TrainerResponse::mapFrom)
                .orElseThrow(NotFoundException.of(AFFECTION_NOT_FOUND));
    }

}
