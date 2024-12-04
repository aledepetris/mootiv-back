package com.mootiv.service;

import com.mootiv.shared.TrainerRequest;
import com.mootiv.shared.TrainerResponse;

import java.util.List;

public interface TrainerCrudService {

    List<TrainerResponse> getTrainers();
    TrainerResponse createTrainer(TrainerRequest request);
    TrainerResponse updateTrainer(Integer id, TrainerRequest request);
    TrainerResponse getTrainer(Integer id);

}
