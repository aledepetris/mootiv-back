package com.mootiv.service.impl;

import com.mootiv.service.StudentCrudService;
import com.mootiv.shared.StudentRequest;
import com.mootiv.shared.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCrud implements StudentCrudService {

    @Override
    public List<StudentResponse> getStudents() {
        return List.of();
    }

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        return null;
    }

    @Override
    public StudentResponse updateStudent(Integer id, StudentRequest request) {
        return null;
    }

    @Override
    public StudentResponse getStudent(Integer id) {
        return null;
    }

}
