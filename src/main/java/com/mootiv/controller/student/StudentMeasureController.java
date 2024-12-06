package com.mootiv.controller.student;

import com.mootiv.service.StudentMeasureService;
import com.mootiv.shared.MeasureRequest;
import com.mootiv.shared.MeasureResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/student/{idStudent}/measure")
public class StudentMeasureController {

    private final StudentMeasureService studentMeasureService;

    public StudentMeasureController(StudentMeasureService studentMeasureService) {
        this.studentMeasureService = studentMeasureService;
    }

    @GetMapping
    public ResponseEntity<List<MeasureResponse>> getAllMeasures(@PathVariable Integer idStudent) {
        return ResponseEntity
                .ok(studentMeasureService.getMeasures(idStudent));
    }

    @PostMapping
    public ResponseEntity<MeasureResponse> addMeasure(@PathVariable Integer idStudent, @RequestBody @Valid MeasureRequest requestBody) {
        studentMeasureService.createMeasure(idStudent, requestBody);
        return ResponseEntity
                .created(URI.create("/bff/v1/student/"+ idStudent +"/measure"))
                .build();
    }

    @PutMapping("/{idMeasure}")
    public ResponseEntity<MeasureResponse> updateMeasure(@PathVariable Integer idStudent, @PathVariable Integer idMeasure,
                                                         @RequestBody @Valid MeasureRequest requestBody) {
        studentMeasureService.updateMeasure(idStudent, idMeasure, requestBody);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{idMeasure}")
    public ResponseEntity<MeasureResponse> getMeasure(@PathVariable Integer idStudent, @PathVariable Integer idMeasure) {
        return ResponseEntity.ok(studentMeasureService.getMeasure(idStudent, idMeasure));
    }

    @DeleteMapping("/{idMeasure}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer idStudent, @PathVariable Integer idMeasure) {
        studentMeasureService.deleteMeasure(idStudent, idMeasure);
        return ResponseEntity.noContent()
                .build();
    }

}
