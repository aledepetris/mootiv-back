package com.mootiv.service;

import com.mootiv.shared.TrainingTypeRequest;
import com.mootiv.shared.TrainingTypeResponse;

import java.util.List;

public interface TrainingTypeCrudService {

    List<TrainingTypeResponse> getTrainingTypes();
    TrainingTypeResponse createTrainingType(TrainingTypeRequest request);
    TrainingTypeResponse updateTrainingType(Integer id, TrainingTypeRequest request);
    TrainingTypeResponse getTrainingType(Integer id);
    void deleteTrainingType(Integer id);

}
