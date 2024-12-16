package com.mootiv.domain.exporter;

import com.mootiv.domain.plan.TrainingCycle;
import com.mootiv.domain.plan.TrainingDay;
import com.mootiv.domain.plan.TrainingWeek;

import java.util.Base64;
import java.io.ByteArrayOutputStream;
import java.util.Comparator;
import java.util.List;

public abstract class RutinaExporter {

    protected TrainingCycle ciclo;

    public RutinaExporter(TrainingCycle ciclo) {
        this.ciclo = ciclo;
    }

    // Template Method
    public String generateRoutineFile(Integer idSemana) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        initializeDocument(outputStream);

        if (idSemana != null) {
            TrainingWeek semana = ciclo.getWeeks().stream().filter(x -> x.getId().equals(idSemana)).findFirst().get();
            processWeek(semana, outputStream);
        } else {
            for (TrainingWeek semana : ciclo.getWeeks()) {
                processWeek(semana, outputStream);
            }
        }

        finalizeDocument(outputStream);

        // Convert to Base64
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }

    // Steps to be implemented in subclasses
    protected abstract void initializeDocument(ByteArrayOutputStream outputStream);
    protected abstract void processDay(TrainingDay day, int dayIndex, ByteArrayOutputStream outputStream);
    protected abstract void finalizeDocument(ByteArrayOutputStream outputStream);

    private void processWeek(TrainingWeek week, ByteArrayOutputStream outputStream) {
        // Ordenar los días por su ID en orden ascendente
        List<TrainingDay> sortedDays = week.getDays().stream()
                .sorted(Comparator.comparing(TrainingDay::getId)) // Ordenar por ID
                .toList();

        // Procesar los días ordenados
        int dayIndex = 1;
        for (TrainingDay day : sortedDays) {
            processDay(day, dayIndex, outputStream);
            dayIndex++;
        }
    }


}
