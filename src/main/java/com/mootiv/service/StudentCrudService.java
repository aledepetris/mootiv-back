package com.mootiv.service;

import com.mootiv.shared.StudentRequest;
import com.mootiv.shared.StudentResponse;

import java.util.List;

public interface StudentCrudService {

    List<StudentResponse> getStudents();
    StudentResponse createStudent(StudentRequest request);
    StudentResponse updateStudent(Integer id, StudentRequest request);
    StudentResponse getStudent(Integer id);

}
