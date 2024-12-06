package com.mootiv.service;

import com.mootiv.shared.TrainingPlaceRequest;
import com.mootiv.shared.TrainingPlaceResponse;

import java.util.List;

public interface StudentTrainingPlaceService {

    List<TrainingPlaceResponse> getTrainingPlaces(Integer idStudent);
    void createTrainingPlace(Integer idStudent, TrainingPlaceRequest bodyRequest);
    void updateTrainingPlace(Integer idStudent, Integer idTrainingPlace, TrainingPlaceRequest bodyRequest);
    TrainingPlaceResponse getTrainingPlace(Integer idStudent, Integer idTrainingPlace);
    void deleteTrainingPlace(Integer idStudent, Integer idTrainingPlace);

}
