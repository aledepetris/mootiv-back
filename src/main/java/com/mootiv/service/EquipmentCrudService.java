package com.mootiv.service;

import com.mootiv.shared.EquipmentRequest;
import com.mootiv.shared.EquipmentResponse;

import java.util.List;

public interface EquipmentCrudService {

    List<EquipmentResponse> getEquipments();
    EquipmentResponse createEquipment(EquipmentRequest bodyRequest);
    EquipmentResponse updateEquipment(Integer id, EquipmentRequest bodyRequest);
    EquipmentResponse getEquipment(Integer id);
    void deleteEquipment(Integer id);

}
