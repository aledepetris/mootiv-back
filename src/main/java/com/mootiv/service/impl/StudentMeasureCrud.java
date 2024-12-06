package com.mootiv.service.impl;

import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.StudentRepository;
import com.mootiv.service.StudentMeasureService;
import com.mootiv.shared.MeasureRequest;
import com.mootiv.shared.MeasureResponse;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mootiv.error.ApiMootivErrors.STUDENT_NOT_FOUND;

@Service
public class StudentMeasureCrud implements StudentMeasureService {

    private final StudentRepository studentRepository;

    public StudentMeasureCrud(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<MeasureResponse> getMeasures(Integer idStudent) {
        return studentRepository.findById(idStudent)
                .map(student -> student.getMeasures().stream()
                        .map(MeasureResponse::mapFrom)
                        .toList())
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));
    }

    @Override
    public void createMeasure(Integer idStudent, MeasureRequest request) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        student.addMeasure(request);
        studentRepository.save(student);
    }

    @Override
    public void updateMeasure(Integer idStudent, Integer idMeasure, MeasureRequest request) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        student.updateMeasure(idMeasure, request);
        studentRepository.save(student);
    }

    @Override
    public MeasureResponse getMeasure(Integer idStudent, Integer idMeasure) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        return MeasureResponse.mapFrom(student.getMeasure(idMeasure));
    }

    @Override
    public void deleteMeasure(Integer idStudent, Integer idMeasure) {
        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        student.deleteMeasure(idMeasure);
        studentRepository.save(student);
    }

}
