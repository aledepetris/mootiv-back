package com.mootiv.controller.student;

import com.mootiv.service.StudentConditionService;
import com.mootiv.shared.ConditionRequest;
import com.mootiv.shared.ConditionResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/bff/v1/student/{idStudent}/condition")
public class StudentConditionController {

    private final StudentConditionService studentConditionService;

    public StudentConditionController(StudentConditionService studentConditionService) {
        this.studentConditionService = studentConditionService;
    }

    @GetMapping
    public ResponseEntity<List<ConditionResponse>> getAllConditions(@PathVariable Integer idStudent) {
        return ResponseEntity
                .ok(studentConditionService.getConditions(idStudent));
    }

    @PostMapping
    public ResponseEntity<ConditionResponse> addCondition(@PathVariable Integer idStudent, @RequestBody @Valid ConditionRequest requestBody) {
        studentConditionService.createCondition(idStudent, requestBody);
        return ResponseEntity
                .created(URI.create("/bff/v1/student/"+ idStudent +"/training-place"))
                .build();
    }

    @PutMapping("/{idCondition}")
    public ResponseEntity<ConditionResponse> updateCondition(@PathVariable Integer idStudent, @PathVariable Integer idCondition,
                                                                     @RequestBody @Valid ConditionRequest requestBody) {
        studentConditionService.updateCondition(idStudent, idCondition, requestBody);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{idCondition}")
    public ResponseEntity<ConditionResponse> getCondition(@PathVariable Integer idStudent, @PathVariable Integer idCondition) {
        return ResponseEntity.ok(studentConditionService.getCondition(idStudent, idCondition));
    }

    @DeleteMapping("/{idCondition}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer idStudent, @PathVariable Integer idCondition) {
        studentConditionService.deleteCondition(idStudent, idCondition);
        return ResponseEntity.noContent()
                .build();
    }

}
