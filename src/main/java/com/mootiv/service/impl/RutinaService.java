package com.mootiv.service.impl;

import com.mootiv.repository.StudentRepository;
import com.mootiv.service.subida.HandlerSubida;
import com.mootiv.service.subida.RutinaExporter;
import org.springframework.stereotype.Service;

@Service
public class RutinaService {

    private final StudentRepository studentRepository;
    private final RutinaExporter rutinaExporter;
    private final HandlerSubida handlerSubida;


    public RutinaService(StudentRepository studentRepository, RutinaExporter rutinaExporter, HandlerSubida handlerSubida) {
        this.studentRepository = studentRepository;
        this.rutinaExporter = rutinaExporter;
        this.handlerSubida = handlerSubida;
    }


    public void generarySubirRutina(Integer idStudent, Integer idCiclo) {

        var student = studentRepository.findById(idStudent)
                .get();

        var ciclo = student.getCycle(idCiclo);

        var file = rutinaExporter.generarRutina(ciclo);

        handlerSubida.setStrategy(student.getRepositorioSubida());
        handlerSubida.subir(file);

    }

}
