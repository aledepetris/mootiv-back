package com.mootiv.service.impl;

import com.mootiv.domain.Equipment;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.EquipmentRepository;
import com.mootiv.service.EquipmentCrudService;
import com.mootiv.shared.EquipmentRequest;
import com.mootiv.shared.EquipmentResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mootiv.error.ApiMootivErrors.*;

@Service
public class EquipmentCrud implements EquipmentCrudService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentCrud(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<EquipmentResponse> getEquipments() {
        return equipmentRepository.findAll().stream()
                .map(EquipmentResponse::mapFrom)
                .toList();
    }

    @Override
    public EquipmentResponse createEquipment(EquipmentRequest request) {

        var equipment = equipmentRepository.findByName(request.getName());
        if (equipment.isPresent()) {
            throw new BusinessException(EQUIPMENT_ALREADY_CREATED);
        }
        var equipmentSaved = equipmentRepository.save(new Equipment(request.getName()));

        return EquipmentResponse.mapFrom(equipmentSaved);

    }

    @Override
    public EquipmentResponse updateEquipment(Integer id, EquipmentRequest request) {

        var equipmentToUpdate = equipmentRepository.findById(id)
                .orElseThrow(BusinessException.of(EQUIPMENT_NOT_FOUND));

        equipmentRepository.findByName(request.getName())
                .filter(existingEquipment -> !existingEquipment.getId().equals(id))
                .ifPresent(equipment -> { throw new BusinessException(EQUIPMENT_ALREADY_CREATED);});

        equipmentToUpdate.setName(request.getName());
        var equipmentSaved = equipmentRepository.save(equipmentToUpdate);

        return EquipmentResponse.mapFrom(equipmentSaved);

    }

    @Override
    public EquipmentResponse getEquipment(Integer id) {
        return equipmentRepository.findById(id)
                .map(EquipmentResponse::mapFrom)
                .orElseThrow(NotFoundException.of(EQUIPMENT_NOT_FOUND));
    }

    @Override
    public void deleteEquipment(Integer id) {
        try {
            equipmentRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es posible eliminar este equipo ya que se encuentra asociado a otra entidad.");
        }
    }

}
