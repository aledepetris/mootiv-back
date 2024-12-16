package com.mootiv.domain.exporter;

import com.mootiv.domain.plan.ExerciseRoutine;
import com.mootiv.domain.plan.TrainingCycle;
import com.mootiv.domain.plan.TrainingDay;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class CsvRutinaExporter extends RutinaExporter {

    public CsvRutinaExporter(TrainingCycle ciclo) {
        super(ciclo);
    }

    @Override
    protected void initializeDocument(ByteArrayOutputStream outputStream) {
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("Ejercicio,Series,Repeticiones,Peso(Kg),Descanso(Seg),Notas");
        writer.flush();
    }

    @Override
    protected void adjustExercise(TrainingDay day, int index, ByteArrayOutputStream outputStream) {
        PrintWriter writer = new PrintWriter(outputStream);

        // Línea que indica el número del día
        writer.printf("Dia %d%n", index);

        // Procesar cada ejercicio en el día
        for (ExerciseRoutine routine : day.getExercises()) {
            writer.printf("%s,%d,%d,%.2f,%d,%s%n",
                    routine.getExercise().getName(),
                    routine.getSets(),
                    routine.getRepetitions(),
                    routine.getWeight(),
                    routine.getRest(),
                    routine.getNotes()
            );
        }
        writer.printf("%n");
        writer.printf("%n");
        writer.flush();
    }


    @Override
    protected void finalizeDocument(ByteArrayOutputStream outputStream) {
        // Nothing specific to finalize in CSV
    }
}
