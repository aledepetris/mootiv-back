-- Enero: Obesidad
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (40, 120, '2024-01-01', 170, 110, 1, 65, 50, 1, 105, 95);

-- Febrero: Obesidad baja
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (38, 115, '2024-02-01', 170, 108, 2, 64, 49, 1, 102, 90);

-- Marzo: Sobrepeso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (35, 110, '2024-03-01', 170, 100, 3, 62, 48, 1, 95, 85);

-- Abril: Normal
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (32, 100, '2024-04-01', 170, 95, 4, 60, 47, 1, 88, 75);

-- Mayo: Bajo peso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (30, 95, '2024-05-01', 170, 90, 5, 58, 45, 1, 80, 60);

-- Junio: Normal
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (33, 105, '2024-06-01', 170, 92, 6, 60, 46, 1, 85, 73);

-- Julio: Sobrepeso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (36, 110, '2024-07-01', 170, 97, 7, 62, 48, 1, 90, 83);

-- Agosto: Obesidad
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (40, 120, '2024-08-01', 170, 105, 8, 65, 50, 1, 98, 95);

-- Septiembre: Normal
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (32, 100, '2024-09-01', 170, 92, 9, 60, 46, 1, 86, 72);

-- Octubre: Bajo peso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (28, 90, '2024-10-01', 170, 85, 10, 55, 44, 1, 78, 58);

-- Noviembre: Sobrepeso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (36, 112, '2024-11-01', 170, 98, 11, 62, 49, 1, 92, 87);

-- Diciembre: Obesidad
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (40, 120, '2024-12-01', 170, 105, 12, 65, 50, 1, 100, 96);

-- Enero: Normal
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (30, 100, '2024-01-01', 160, 90, 13, 58, 45, 2, 75, 60);

-- Febrero: Bajo peso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (28, 95, '2024-02-01', 160, 85, 14, 56, 44, 2, 70, 50);

-- Marzo: Normal
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (31, 102, '2024-03-01', 160, 92, 15, 59, 46, 2, 78, 63);

-- Abril: Sobrepeso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (34, 110, '2024-04-01', 160, 98, 16, 62, 48, 2, 85, 75);

-- Mayo: Normal
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (32, 105, '2024-05-01', 160, 94, 17, 60, 47, 2, 80, 68);

-- Junio: Bajo peso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (27, 90, '2024-06-01', 160, 82, 18, 54, 43, 2, 65, 50);


-- Enero: Sobrepeso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (35, 105, '2024-01-01', 180, 95, 19, 62, 48, 3, 85, 85);

-- Febrero: Normal
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (32, 100, '2024-02-01', 180, 92, 20, 60, 47, 3, 80, 75);

-- Marzo: Bajo peso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (30, 90, '2024-03-01', 180, 85, 21, 58, 45, 3, 75, 60);

-- Abril: Normal
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (33, 105, '2024-04-01', 180, 92, 22, 60, 47, 3, 80, 73);

-- Mayo: Sobrepeso
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (37, 110, '2024-05-01', 180, 100, 23, 64, 49, 3, 88, 90);

-- Junio: Obesidad
INSERT INTO public.measure
(arm, chest, "date", height, hip, id, leg, shoulder, student_id, waist, weight)
VALUES (40, 120, '2024-06-01', 180, 110, 24, 65, 50, 3, 95, 110);

ALTER SEQUENCE measure_id_seq RESTART WITH 37;


-- Condiciones para el estudiante con ID 1
INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (1, '2024-01-15', 1, 1, 'ACTIVA', 'El dolor se intensifica durante curls de bíceps.', 'SEVERA');

INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (5, '2024-03-20', 2, 1, 'RESUELTA', 'Terapia física realizada con éxito.', 'MODERADA');

INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (9, '2024-06-10', 3, 1, 'ACTIVA', 'Dolor persistente al realizar peso muerto.', 'SEVERA');

-- Condiciones para el estudiante con ID 2
INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (3, '2024-02-10', 4, 2, 'ACTIVA', 'Molestia al realizar levantamientos laterales.', 'MODERADA');

INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (8, '2024-04-05', 5, 2, 'INACTIVA', 'Recuperación parcial, el dolor ha disminuido.', 'BAJA');

INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (7, '2024-07-22', 6, 2, 'ACTIVA', 'Dolor significativo al realizar remo con barra.', 'SEVERA');

-- Condiciones para el estudiante con ID 3
INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (10, '2024-01-05', 7, 3, 'ACTIVA', 'Hernia detectada, limitación severa en ejercicios de torsión.', 'SEVERA');

INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (6, '2024-05-12', 8, 3, 'RESUELTA', 'Tratamiento exitoso, rango de movimiento recuperado.', 'MODERADA');

INSERT INTO "condition"
(affection_id, diagnosis_date, id, student_id, current_status, notes, severity)
VALUES (4, '2024-09-25', 9, 3, 'ACTIVA', 'Dolor leve en el hombro izquierdo, ejercicios de empuje limitados.', 'BAJA');

ALTER SEQUENCE condition_id_seq RESTART WITH 10;
