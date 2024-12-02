package com.mootiv.controller;

import com.mootiv.service.contract.EquipmentCrudService;
import com.mootiv.shared.EquipmentRequest;
import com.mootiv.shared.EquipmentResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/equipment")
public class EquipmentController {

    private final EquipmentCrudService equipmentCrudService;


    public EquipmentController(EquipmentCrudService equipmentCrudService) {
        this.equipmentCrudService = equipmentCrudService;
    }

    @GetMapping
    public ResponseEntity<List<EquipmentResponse>> getAllEquipments() {
        return ResponseEntity
                .ok(equipmentCrudService.getEquipments());
    }

    @PostMapping
    public ResponseEntity<EquipmentResponse> addEquipment(@RequestBody @Valid EquipmentRequest requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/equipment"))
                .body(equipmentCrudService.createEquipment(requestBody));
    }

    @PutMapping("/{idEquipment}")
    public ResponseEntity<EquipmentResponse> updateEquipment(@PathVariable Integer idEquipment, @RequestBody @Valid EquipmentRequest requestBody) {
        return ResponseEntity.ok(equipmentCrudService.updateEquipment(idEquipment, requestBody));
    }

    @GetMapping("/{idEquipment}")
    public ResponseEntity<EquipmentResponse> getEquipment(@PathVariable Integer idEquipment) {
        return ResponseEntity.ok(equipmentCrudService.getEquipment(idEquipment));
    }

    @DeleteMapping("/{idEquipment}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer idEquipment) {
        equipmentCrudService.deleteEquipment(idEquipment);
        return ResponseEntity.noContent()
                .build();
    }


}
