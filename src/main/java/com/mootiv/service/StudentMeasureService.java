package com.mootiv.service;

import com.mootiv.shared.MeasureRequest;
import com.mootiv.shared.MeasureResponse;

import java.util.List;

public interface StudentMeasureService {

    List<MeasureResponse> getMeasures(Integer idStudent);
    void createMeasure(Integer idStudent, MeasureRequest bodyRequest);
    void updateMeasure(Integer idStudent, Integer idMeasure, MeasureRequest bodyRequest);
    MeasureResponse getMeasure(Integer idStudent, Integer idMeasure);
    void deleteMeasure(Integer idStudent, Integer idMeasure);

}
