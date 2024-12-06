package com.mootiv.service;

import com.mootiv.shared.ConditionRequest;
import com.mootiv.shared.ConditionResponse;

import java.util.List;

public interface StudentConditionService {

    List<ConditionResponse> getConditions(Integer idStudent);
    void createCondition(Integer idStudent, ConditionRequest bodyRequest);
    void updateCondition(Integer idStudent, Integer idCondition, ConditionRequest bodyRequest);
    ConditionResponse getCondition(Integer idStudent, Integer idCondition);
    void deleteCondition(Integer idStudent, Integer idCondition);


}
