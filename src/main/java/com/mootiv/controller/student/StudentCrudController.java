package com.mootiv.controller.student;

import com.mootiv.service.StudentCrudService;
import com.mootiv.shared.StudentRequest;
import com.mootiv.shared.StudentResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/student")
public class StudentCrudController {

    private final StudentCrudService studentCrudService;

    public StudentCrudController(StudentCrudService studentCrudService) {
        this.studentCrudService = studentCrudService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity
                .ok(studentCrudService.getStudents());
    }

    @PostMapping
    public ResponseEntity<StudentResponse> addStudent(@RequestBody @Valid StudentRequest requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/student"))
                .body(studentCrudService.createStudent(requestBody));
    }

    @PutMapping("/{idStudent}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Integer idStudent, @RequestBody @Valid StudentRequest requestBody) {
        return ResponseEntity.ok(studentCrudService.updateStudent(idStudent, requestBody));
    }

    @GetMapping("/{idStudent}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Integer idStudent) {
        return ResponseEntity.ok(studentCrudService.getStudent(idStudent));
    }


}
