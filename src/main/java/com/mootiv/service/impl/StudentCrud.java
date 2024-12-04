package com.mootiv.service.impl;

import com.mootiv.domain.persona.Student;
import com.mootiv.domain.persona.Trainer;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.StudentRepository;
import com.mootiv.repository.TrainerRepository;
import com.mootiv.service.StudentCrudService;
import com.mootiv.shared.StudentRequest;
import com.mootiv.shared.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mootiv.error.ApiMootivErrors.*;
import static java.util.Objects.nonNull;

@Service
public class StudentCrud implements StudentCrudService {

    private final TrainerRepository trainerRepository;
    private final StudentRepository studentRepository;

    public StudentCrud(TrainerRepository trainerRepository, StudentRepository studentRepository) {
        this.trainerRepository = trainerRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentResponse> getStudents() {
        return studentRepository.findAll().stream()
                .map(StudentResponse::mapFrom)
                .toList();
    }

    @Override
    public StudentResponse createStudent(StudentRequest request) {

        var student = studentRepository.findByDni(request.getDni());
        if (student.isPresent()) {
            throw new BusinessException(STUDENT_ALREADY_CREATED);
        }

        Trainer trainer = null;
        if (nonNull(request.getIdTrainer())) {
            trainer = trainerRepository.findById(request.getIdTrainer())
                    .orElseThrow(BusinessException.of(TRAINER_NOT_FOUND));
        }
        var studentSaved = studentRepository.save(Student.createFrom(request, trainer));

        return StudentResponse.mapFrom(studentSaved);

    }

    @Override
    public StudentResponse updateStudent(Integer id, StudentRequest request) {

        var studentToUpdate = studentRepository.findById(id)
                .orElseThrow(BusinessException.of(STUDENT_NOT_FOUND));


        studentRepository.findByDni(request.getDni())
                .filter(existingStudent -> !existingStudent.getId().equals(id))
                .ifPresent(student -> { throw new BusinessException(STUDENT_ALREADY_CREATED);});

        Trainer trainer = null;
        if (nonNull(request.getIdTrainer())) {
            trainer = trainerRepository.findById(request.getIdTrainer())
                    .orElseThrow(BusinessException.of(TRAINER_NOT_FOUND));
        }

        studentToUpdate.updateFrom(request, trainer);
        var studentSaved = studentRepository.save(studentToUpdate);

        return StudentResponse.mapFrom(studentSaved);

    }

    @Override
    public StudentResponse getStudent(Integer id) {
        return studentRepository.findById(id)
                .map(StudentResponse::mapFrom)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));
    }

}
