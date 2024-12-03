package com.mootiv.service;

import com.mootiv.shared.MuscleRequest;
import com.mootiv.shared.MuscleResponse;

import java.util.List;

public interface MuscleCrudService {

    List<MuscleResponse> getMuscles();
    MuscleResponse createMuscle(MuscleRequest bodyRequest);
    MuscleResponse updateMuscle(Integer id, MuscleRequest bodyRequest);
    MuscleResponse getMuscle(Integer id);
    void deleteMuscle(Integer id);

}
