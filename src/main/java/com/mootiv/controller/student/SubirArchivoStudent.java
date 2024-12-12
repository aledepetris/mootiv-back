package com.mootiv.controller.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bff/v1/student/{idStudent}/cycle/{idCycle}/generar-rutina")
public class SubirArchivoStudent {

    @PostMapping
    ResponseEntity<Void> generarSubir(@PathVariable Integer idStudent, @PathVariable Integer idCycle ) {

        return null; // llamada al servicio de generar y subir rutina

    }

}
