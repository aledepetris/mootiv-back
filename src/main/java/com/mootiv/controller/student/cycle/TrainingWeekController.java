package com.mootiv.controller.student.cycle;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.plan.TrainingWeekStatus;
import com.mootiv.service.TrainingCycleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/v1/student/{idStudent}/week")
public class TrainingWeekController {

    private final TrainingCycleService trainingCycleService;

    public TrainingWeekController(TrainingCycleService trainingCycleService) {
        this.trainingCycleService = trainingCycleService;
    }

    @PutMapping("/{idWeek}/{status}")
    public ResponseEntity<List<Exercise>> getTrainingCycleAvailableExercise(@PathVariable Integer idStudent,
                                                                            @PathVariable Integer idWeek,
                                                                            @PathVariable String status) {
        if (!TrainingWeekStatus.isValidValue(status)) {
            throw new RuntimeException("El estado ingresado no se encuentra dentro de los valores permitidos");
        }

        trainingCycleService.cambiarSemanaEstado(idStudent, idWeek, TrainingWeekStatus.valueOf(status));

        return ResponseEntity
                .noContent()
                .build();
    }

}
