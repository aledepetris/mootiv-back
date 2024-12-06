package com.mootiv.controller.student;

import com.mootiv.service.StudentTrainingPlaceService;
import com.mootiv.shared.TrainingPlaceRequest;
import com.mootiv.shared.TrainingPlaceResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/student/{idStudent}/training-place")
public class StudentTrainingPlaceController {

    private final StudentTrainingPlaceService studentTrainingPlaceService;

    public StudentTrainingPlaceController(StudentTrainingPlaceService studentTrainingPlaceService) {
        this.studentTrainingPlaceService = studentTrainingPlaceService;
    }

    @GetMapping
    public ResponseEntity<List<TrainingPlaceResponse>> getAllTrainingPlaces(@PathVariable Integer idStudent) {
        return ResponseEntity
                .ok(studentTrainingPlaceService.getTrainingPlaces(idStudent));
    }

    @PostMapping
    public ResponseEntity<TrainingPlaceResponse> addTrainingPlace(@PathVariable Integer idStudent, @RequestBody @Valid TrainingPlaceRequest requestBody) {
        studentTrainingPlaceService.createTrainingPlace(idStudent, requestBody);
        return ResponseEntity
                .created(URI.create("/bff/v1/student/"+ idStudent +"/training-place"))
                .build();
    }

    @PutMapping("/{idTrainingPlace}")
    public ResponseEntity<TrainingPlaceResponse> updateTrainingPlace(@PathVariable Integer idStudent, @PathVariable Integer idTrainingPlace,
                                                         @RequestBody @Valid TrainingPlaceRequest requestBody) {
        studentTrainingPlaceService.updateTrainingPlace(idStudent, idTrainingPlace, requestBody);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{idTrainingPlace}")
    public ResponseEntity<TrainingPlaceResponse> getTrainingPlace(@PathVariable Integer idStudent, @PathVariable Integer idTrainingPlace) {
        return ResponseEntity.ok(studentTrainingPlaceService.getTrainingPlace(idStudent, idTrainingPlace));
    }

    @DeleteMapping("/{idTrainingPlace}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer idStudent, @PathVariable Integer idTrainingPlace) {
        studentTrainingPlaceService.deleteTrainingPlace(idStudent, idTrainingPlace);
        return ResponseEntity.noContent()
                .build();
    }

}
