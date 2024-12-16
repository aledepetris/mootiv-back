package com.mootiv.domain.exporter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mootiv.domain.plan.ExerciseRoutine;
import com.mootiv.domain.plan.TrainingCycle;
import com.mootiv.domain.plan.TrainingDay;

import java.io.ByteArrayOutputStream;

public class PdfRutinaExporter extends RutinaExporter {

    private Document document;
    private PdfWriter writer;

    public PdfRutinaExporter(TrainingCycle ciclo) {
        super(ciclo);
    }

    @Override
    protected void initializeDocument(ByteArrayOutputStream outputStream) {
        document = new Document();
        try {
            // Vincular el PdfWriter al Document y al ByteArrayOutputStream
            writer = PdfWriter.getInstance(document, outputStream);
            document.open(); // Abrir el documento para escribir
            document.add(new Paragraph("Rutina de entrenamiento"));
            document.add(new Paragraph("--------------------------------------------"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void processDay(TrainingDay day, int index, ByteArrayOutputStream outputStream) {
        try {
            document.add(new Paragraph("Dia: " + index));
            for (ExerciseRoutine routine : day.getExercises()) {
                document.add(new Paragraph(String.format(
                        "%s - Sets: %d, Reps: %d, Weight: %.2f, Rest: %d, Notes: %s",
                        routine.getExercise().getName(),
                        routine.getSets(),
                        routine.getRepetitions(),
                        routine.getWeight(),
                        routine.getRest(),
                        routine.getNotes()
                )));
            }
            document.add(new Paragraph(" "));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalizeDocument(ByteArrayOutputStream outputStream) {
        document.close();
    }
}
