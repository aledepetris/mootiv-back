package com.mootiv.controller;

import com.mootiv.service.contract.AffectionCrudService;
import com.mootiv.shared.AffectionRequest;
import com.mootiv.shared.AffectionResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/affection")
public class AffectionController {

    private final AffectionCrudService affectionCrudService;

    public AffectionController(AffectionCrudService affectionCrudService) {
        this.affectionCrudService = affectionCrudService;
    }

    @GetMapping
    public ResponseEntity<List<AffectionResponse>> getAllAffections() {
        return ResponseEntity
                .ok(affectionCrudService.getAffections());
    }

    @PostMapping
    public ResponseEntity<AffectionResponse> addAffection(@RequestBody @Valid AffectionRequest requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/affection"))
                .body(affectionCrudService.createAffection(requestBody));
    }

    @PutMapping("/{idAffection}")
    public ResponseEntity<AffectionResponse> updateAffection(@PathVariable Integer idAffection, @RequestBody @Valid AffectionRequest requestBody) {
        return ResponseEntity.ok(affectionCrudService.updateAffection(idAffection, requestBody));
    }

    @GetMapping("/{idAffection}")
    public ResponseEntity<AffectionResponse> getAffection(@PathVariable Integer idAffection) {
        return ResponseEntity.ok(affectionCrudService.getAffection(idAffection));
    }

    @DeleteMapping("/{idAffection}")
    public ResponseEntity<Void> deleteAffection(@PathVariable Integer idAffection) {
        affectionCrudService.deleteAffection(idAffection);
        return ResponseEntity.noContent()
                .build();
    }

}
