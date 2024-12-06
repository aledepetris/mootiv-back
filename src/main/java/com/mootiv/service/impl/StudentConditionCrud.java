package com.mootiv.service.impl;

import com.mootiv.domain.Affection;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.AffectionRepository;
import com.mootiv.repository.StudentRepository;
import com.mootiv.service.StudentConditionService;
import com.mootiv.shared.ConditionRequest;
import com.mootiv.shared.ConditionResponse;
import com.mootiv.shared.MeasureResponse;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mootiv.error.ApiMootivErrors.AFFECTION_NOT_FOUND;
import static com.mootiv.error.ApiMootivErrors.STUDENT_NOT_FOUND;

@Service
public class StudentConditionCrud implements StudentConditionService {

    private final StudentRepository studentRepository;
    private final AffectionRepository affectionRepository;

    public StudentConditionCrud(StudentRepository studentRepository, AffectionRepository affectionRepository) {
        this.studentRepository = studentRepository;
        this.affectionRepository = affectionRepository;
    }

    @Override
    public List<ConditionResponse> getConditions(Integer idStudent) {
        return studentRepository.findById(idStudent)
                .map(student -> student.getAllConditions().stream()
                        .map(ConditionResponse::mapFrom)
                        .toList())
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));
    }

    @Override
    public void createCondition(Integer idStudent, ConditionRequest request) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        var affection = affectionRepository.findById(request.getIdAffection())
                        .orElseThrow(NotFoundException.of(AFFECTION_NOT_FOUND));

        student.addCondition(request, affection);
        studentRepository.save(student);
    }

    @Override
    public void updateCondition(Integer idStudent, Integer idCondition, ConditionRequest request) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        var affection = affectionRepository.findById(request.getIdAffection())
                .orElseThrow(NotFoundException.of(AFFECTION_NOT_FOUND));

        student.updateCondition(request, idCondition, affection);
        studentRepository.save(student);
    }

    @Override
    public ConditionResponse getCondition(Integer idStudent, Integer idCondition) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        return ConditionResponse.mapFrom(student.getCondition(idCondition));
    }

    @Override
    public void deleteCondition(Integer idStudent, Integer idCondition) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        student.deleteCondition(idCondition);
        studentRepository.save(student);
    }
}
